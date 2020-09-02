package com.jspoloa.pruebalineamientoscodigo.servicios.implementacion;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jspoloa.pruebalineamientoscodigo.enumeradores.CabecerasPorCodigoHttpEnum;
import com.jspoloa.pruebalineamientoscodigo.servicios.ServicioGenerarHeaderErrorI;

@Service
public class ServicioGenerarHeaderError implements ServicioGenerarHeaderErrorI{

	public HttpHeaders generarHeader(HttpStatus codigoError) {
		HttpHeaders responseHeaders = new HttpHeaders();
		CabecerasPorCodigoHttpEnum cabecera = CabecerasPorCodigoHttpEnum.buscarPorValor(codigoError);
		responseHeaders.set("mensaje", cabecera.getMensaje());
		return responseHeaders;
	}

}
