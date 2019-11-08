package com.distribuida.main;

import java.sql.Date;

import com.distribuida.cliente.AlbumCliente;
import com.distribuida.cliente.SingerCliente;
import com.distribuida.dto.Album;
import com.distribuida.dto.Singer;

public class RestEasyMain {
	public static void main(String args[]) {
		SingerCliente singerCliente = new SingerCliente();
		AlbumCliente albumCliente = new AlbumCliente();
		String resp = "";
		Singer singer = new Singer();
		Album album = new Album();
		
		/*ELIMINAR*/
		System.out.println("################ELIMINAMOS UN SINGER Y LISTAMOS################");
		singerCliente.eliminarSinger(6);
		resp = singerCliente.getSingers();
		System.out.println(resp);
		
		System.out.println("################ELIMINAMOS UN ALBUM Y LISTAMOS################");
		albumCliente.eliminarAlbum(6);
		resp = albumCliente.getAlbums();
		System.out.println(resp);
		
		
		/*LISTAR TODOS*/
		System.out.println("################LISTAR TODOS LOS SINGERS################");
		resp = singerCliente.getSingers();
		System.out.println(resp);		
		resp = albumCliente.getAlbums();
		
		System.out.println("################LISTAR TODOS LOS ALBUMS################");
		System.out.println(resp);
		
		/*LISTAR POR ID*/
		System.out.println("################BUSCAMOS UN SOLO SINGER################");
		resp = singerCliente.getSingerPorId(1);
		System.out.println(resp);
		resp = albumCliente.getAlbumPorId(2);
		
		System.out.println("################BUSCAMOS UN SOLO ALBUM################");
		System.out.println(resp);
		
		/*GUARDAR*/
		System.out.println("################GUARDAMOS UN SINGER Y LISTAMOS################");
		singer.setId(6);
		singer.setFirst_name("PRUEBA RESTEasy CLIENTE");
		singer.setLast_name("PRUEBA");
		singer.setBirth_date(new Date(19, 10, 3));
		resp = singerCliente.crearSinger(singer);
		System.out.println(resp);
		resp = singerCliente.getSingers();
		System.out.println(resp);
		
		System.out.println("################GUARDAMOS UN ALBUM Y LISTAMOS################");
		
		album.setId(6);
		album.setTitle("PRUEBA RESTEasy Album");
		album.setSinger_id(2);
		album.setRelease_date(new Date(19, 10, 3));
		resp = albumCliente.crearAlbum(album);
		System.out.println(resp);
		resp = albumCliente.getAlbums();
		System.out.println(resp);
		
		/*ACTUALIZAR*/
		System.out.println("################ACTUALIZAMOS UN SINGER Y LISTAMOS################");
		singer.setId(6);
		singer.setFirst_name("PRUEBA ACTUALIZAR SINGER");
		singer.setLast_name("PRUEBA");
		singer.setBirth_date(new Date(19, 10, 3));
		resp = singerCliente.updateSinger(singer);
		System.out.println(resp);
		resp = singerCliente.getSingers();
		System.out.println(resp);
		
		System.out.println("################ACTUALIZAMOS UN ALBUM Y LISTAMOS################");
		album.setId(6);
		album.setTitle("PRUEBA RESTEasy ACTUALIZAR");
		album.setSinger_id(2);
		album.setRelease_date(new Date(19, 10, 3));
		resp = albumCliente.updateAlbum(album);
		System.out.println(resp);
		resp = albumCliente.getAlbums();
		System.out.println(resp);
	}
}
