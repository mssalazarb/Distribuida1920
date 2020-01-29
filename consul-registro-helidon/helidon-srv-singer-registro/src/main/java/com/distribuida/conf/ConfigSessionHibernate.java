package com.distribuida.conf;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.distribuida.dto.Singer;

@ApplicationScoped
public class ConfigSessionHibernate {

	@Inject
	@ConfigProperty(name = "hibernate.dialect")
	private  String hibernateDialect;

	@Inject
	@ConfigProperty(name = "jdbc.driver")
	private  String jdbcDriver;

	@Inject
	@ConfigProperty(name = "jdbc.url")
	private  String jdbcUrl;

	@Inject
	@ConfigProperty(name = "jdbc.user")
	private  String jdbcUser;

	@Inject
	@ConfigProperty(name = "jdbc.password")
	private  String jdbcPassword;

	private static SessionFactory sessionFactory;

	@Produces
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			Properties prop = new Properties();
			prop.put(Environment.DIALECT, hibernateDialect);
			prop.put(Environment.DRIVER, jdbcDriver);
			prop.put(Environment.URL, jdbcUrl);
			prop.put(Environment.USER, jdbcUser);
			prop.put(Environment.PASS, jdbcPassword);
			prop.put(Environment.HBM2DDL_AUTO, "update");

			config.setProperties(prop);
			config.addAnnotatedClass(Singer.class);

			ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
					.build();

			sessionFactory = config.buildSessionFactory(service);

		}
		return sessionFactory;
	}
}