package com.distribuida.servicio;

import java.util.List;

import com.distribuida.dto.Instrument;

public interface InstrumentService {
	
	Instrument buscarPorId(Integer id);
	
	List<Instrument> listarTodos();
}
