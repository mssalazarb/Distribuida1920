package com.distribuida.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.distribuida.dto.Album;
import com.distribuida.dto.Singer;
import com.distribuida.proxy.AlbumProxyImpl;
import com.distribuida.proxy.SingerProxyImpl;

@Named("albumController")
@ApplicationScoped
public class AlbumController implements Serializable{

	private static final long serialVersionUID = 1L;

	private SingerProxyImpl singerProxy = new SingerProxyImpl();
	private AlbumProxyImpl albumProxy = new AlbumProxyImpl();
	
	private Album album;
	private Singer singer;
	private List<Singer> singers;
	private List<Album> albums;
	private boolean banderaListar;
	private boolean banderaCrear;
	private boolean banderaEditar;
	
	@PostConstruct
	public void init() {
		album = new Album();
		singer = new Singer();
		singers = singerProxy.listarTodos();
		albums = albumProxy.listarTodos();
		banderaListar = true;
		banderaCrear = false;
		banderaEditar = false;
	}
	
	public void listarAlbums() {
		banderaListar = true;
		banderaCrear = false;
		banderaEditar = false;
		albums = albumProxy.listarTodos();
		singers = singerProxy.listarTodos();
	}
	
	public void banderaCrear() {
		album = new Album();
		singer = new Singer();
		banderaListar = false;
		banderaCrear = true;
		banderaEditar = false;
	}
	
	public void banderaEditar(Album element) {
		album = new Album();
		banderaListar = false;
		banderaCrear = false;
		banderaEditar = true;
		album = element;
		singer = element.getSingerId();
	}
	
	public void eliminarAlbum(Album element) {
		albumProxy.eliminarAlbum(element.getId());
		listarAlbums();
	}
	
	public void guardarAlbum() {
		buscarSinger(singer.getId());
		album.setSingerId(singer);
		album = albumProxy.crearAlbum(album);
		listarAlbums();
	}
	
	public void actualizarAlbum() {
		buscarSinger(singer.getId());
		album.setSingerId(singer);
		album = albumProxy.editarAlbum(album);
		listarAlbums();
	}
	
	public void buscarSinger(Integer id) {
		for (Singer s : singers) {
			if(s.getId() == id) {
				singer = s;
				break;
			}
		} 
	}

	public List<Singer> getSingers() {
		return singers;
	}

	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}

	public boolean isBanderaListar() {
		return banderaListar;
	}

	public void setBanderaListar(boolean banderaListar) {
		this.banderaListar = banderaListar;
	}

	public boolean isBanderaCrear() {
		return banderaCrear;
	}

	public void setBanderaCrear(boolean banderaCrear) {
		this.banderaCrear = banderaCrear;
	}

	public boolean isBanderaEditar() {
		return banderaEditar;
	}

	public void setBanderaEditar(boolean banderaEditar) {
		this.banderaEditar = banderaEditar;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	
}
