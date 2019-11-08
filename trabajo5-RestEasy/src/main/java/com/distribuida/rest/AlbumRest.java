package com.distribuida.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.dto.Album;
import com.distribuida.service.AlbumService;
import com.distribuida.service.AlbumServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/albums")
public class AlbumRest {
	
	private AlbumService albumService = new AlbumServiceImpl();

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@PathParam(value = "id") Integer id) {
		Album album = albumService.buscarPorId(id);
		String resp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			resp = mapper.writeValueAsString(album);
		} catch (Exception e) {
			e.printStackTrace();
			resp = "ERROR AL LISTAR POR ID";
		}
		return resp;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarTodos() {
		List<Album> albums = albumService.listar();
		String resp = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			for (Album b: albums) {
				resp = resp + mapper.writeValueAsString(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = "ERROR AL LISTAR TODOS";
		}
		return resp;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String crear(String album) {
		String resp = "";
		Album a = new Album();
		ObjectMapper mapper = new ObjectMapper();
		try {
			a = mapper.readValue(album, Album.class);
			a = albumService.crear(a);
			resp = mapper.writeValueAsString(a);
		} catch (Exception e) {
			e.printStackTrace();
			resp = "ERROR AL CREAR";
		}
		return resp;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String editar(String album) {
		String resp = "";
		Album a = new Album();
		ObjectMapper mapper = new ObjectMapper();
		try {
			a = mapper.readValue(album, Album.class);
			a = albumService.editar(a);
			resp = mapper.writeValueAsString(a);
		} catch (Exception e) {
			e.printStackTrace();
			resp = "ERROR AL EDITAR";
		}
		return resp;
	}

	@DELETE
	@Path("/{id}")
	public void eliminar(@PathParam(value = "id") Integer id) {
		albumService.eliminar(id);
		String resp = "";
	}
}
