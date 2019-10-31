package com.distribuida.factory;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

import com.distribuida.conexion.Persistencia;
import com.distribuida.impl.AlbumImpl;
import com.distribuida.impl.SingerImpl;
import com.distribuida.producer.PersistenceProducer;
import com.distribuida.producer.ProducerType;

@SessionScoped
public class PersistenciaFactory implements Serializable{
	
	private static final long serialVersionUID = 5269302440619391616L;
	
	@Produces
	@PersistenceProducer(ProducerType.SINGER)
	public Persistencia getInstanceSinger() {
		return new SingerImpl();
	}

	@Produces
	@PersistenceProducer(ProducerType.ALBUM)
	public Persistencia getInstanceAlbum() {
		return new AlbumImpl();
	}
}
