package com.jspoloa.pruebalineamientoscodigo.servicios;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public interface ServicioGenerarHeaderErrorI {
	
	public HttpHeaders generarHeader(HttpStatus codigoError);

}
