package com.distribuida.ribbon;

import org.apache.commons.configuration.AbstractConfiguration;

import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.Hystrix;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.RibbonRequest;

import io.netty.buffer.ByteBuf;

public class PrincipalRibbon {

	public static void main(String[] args) {

		// Configurar los servidores
		AbstractConfiguration config = ConfigurationManager.getConfigInstance();

		config.setProperty("hola-mundo.ribbon." + CommonClientConfigKey.ListOfServers,
				"127.0.0.1:7001, 127.0.0.1:7002");

		HolaMundoRest servicio = Ribbon.from(HolaMundoRest.class);

		for (int i = 0; i < 10; i++) {
			RibbonRequest<ByteBuf> ret = servicio.hola();

			// Ejecutar la accion
			ByteBuf result = ret.execute();

			// Convertir a String
			int size = result.readableBytes();
			byte[] data = new byte[size];
			result.readBytes(data);

			String str = new String(data);
			System.out.println(str);
		}
		
		Hystrix.reset();
	}

}
