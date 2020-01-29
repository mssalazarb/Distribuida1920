package com.distribuida.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.dto.Singer;
import com.distribuida.proxy.SingerProxy;

@Named("singerController")
@SessionScoped
public class SingerController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject private SingerProxy singerProxy;
	
	private Singer singer;
	private List<Singer> singers;
	private boolean banderaListar;
	private boolean banderaCrear;
	private boolean banderaEditar;
	
	@PostConstruct
	public void init() {
		singer = new Singer();
		singers = singerProxy.listarTodos();
		banderaListar = true;
		banderaCrear = false;
		banderaEditar = false;
	}
	
	public void listarSingers() {
		banderaListar = true;
		banderaCrear = false;
		banderaEditar = false;
		singers = singerProxy.listarTodos();
	}
	
	public void banderaCrear() {
		singer = new Singer();
		banderaListar = false;
		banderaCrear = true;
		banderaEditar = false;
	}
	
	public void banderaEditar(Singer element) {
		singer = new Singer();
		banderaListar = false;
		banderaCrear = false;
		banderaEditar = true;
		singer = element;
	}
	
	public void eliminarSinger(Singer element) {
		singerProxy.eliminarSinger(element.getId());
		listarSingers();
	}
	
	public void guardarSinger() {
		singer = singerProxy.crearSinger(singer);
		listarSingers();
	}
	
	public void actualizarSinger() {
		singer = singerProxy.editarSinger(singer);
		listarSingers();
	}
	
	public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
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
}
