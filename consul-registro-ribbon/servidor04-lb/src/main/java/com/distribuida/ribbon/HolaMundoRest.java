package com.distribuida.ribbon;

import com.netflix.ribbon.RibbonRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.ribbon.proxy.annotation.ResourceGroup;

import io.netty.buffer.ByteBuf;

@ResourceGroup(name = "hola-mundo")
public interface HolaMundoRest {
	
	@Http(
			method = Http.HttpMethod.GET,
			uri = "/servicio/hola"
	)
	public RibbonRequest<ByteBuf> hola();
}
