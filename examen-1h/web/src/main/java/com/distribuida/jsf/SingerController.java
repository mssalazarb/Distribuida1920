package com.distribuida.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.distribuida.controller.Controlador;
import com.distribuida.dto.Singer;

@Named("singerController")
@SessionScoped
public class SingerController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject private Controlador singerControlador;
	
	private Singer singer;
	private List<Singer> singers;
	private boolean banderaListar;
	
	@PostConstruct
	public void init() {
		singer = new Singer();
		singers = singerControlador.listarSingers();
		banderaListar = true;
	}
	
	public void listarSingers() {
		banderaListar = true;
		singers = singerControlador.listarSingers();
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
}
