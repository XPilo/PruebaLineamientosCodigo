package com.jspoloa.pruebalineamientoscodigo.servicios.implementacion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jspoloa.pruebalineamientoscodigo.enumeradores.CabecerasPorCodigoHttpEnum;
import com.jspoloa.pruebalineamientoscodigo.servicios.ServicioGenerarHeaderErrorI;

@Service
@PropertySource("classpath:propiedades.properties")
public class ServicioGenerarHeaderError implements ServicioGenerarHeaderErrorI{

	@Value("${header.mensaje}")
	private String headerMensaje;
	
	public HttpHeaders generarHeader(HttpStatus codigoError) {
		HttpHeaders responseHeaders = new HttpHeaders();
		CabecerasPorCodigoHttpEnum cabecera = CabecerasPorCodigoHttpEnum.buscarPorValor(codigoError);
		responseHeaders.set(headerMensaje, cabecera.getMensaje());
		return responseHeaders;
	}

}
