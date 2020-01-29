package com.distribuida.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.distribuida.dto.Singer;

@ApplicationScoped
public class Controlador {

	private static final String URL_SERVICIO_SINGER = "http://localhost:8080/controller/singers";
	private static final String URL_SERVICIO_ALBUM = "http://localhost:8080/controller/albums";
	private static final String URL_SERVICIO_INSTRUMENT = "http://localhost:8080/controller/instruments";

	public List<Singer> listarSingers() {
		List<Singer> result = new ArrayList<>();
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet(URL_SERVICIO_SINGER + "/singers");
			request.addHeader("accept", "application/json");
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				result = (List<Singer>) entity;
			}
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String listarAlbums() {
		String result = "";
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet(URL_SERVICIO_ALBUM + "/albums");
			request.addHeader("accept", "application/json");
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				result = EntityUtils.toString(entity);
			}
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String listarInstruments() {
		String result = "";
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet(URL_SERVICIO_INSTRUMENT + "/instruments");
			request.addHeader("accept", "application/json");
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				result = EntityUtils.toString(entity);
			}
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String buscarSinger(Integer id) {
		String result = "";
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet(URL_SERVICIO_SINGER + "/singers/" + id);
			request.addHeader("accept", "application/json");
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				result = EntityUtils.toString(entity);
			}
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String buscarAlbum(Integer id) {
		String result = "";
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet(URL_SERVICIO_ALBUM + "/albums/" + id);
			request.addHeader("accept", "application/json");
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				result = EntityUtils.toString(entity);
			}
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String buscarInstrument(Integer id) {
		String result = "";
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet request = new HttpGet(URL_SERVICIO_INSTRUMENT + "/instruments/" + id);
			request.addHeader("accept", "application/json");
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// return it as a String
				result = EntityUtils.toString(entity);
			}
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
