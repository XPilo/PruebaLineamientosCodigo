package com.jspoloa.pruebalineamientoscodigo.enumeradores;

import java.util.EnumMap;
import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum CabecerasPorCodigoHttpEnum {

	NO_AUTORIZADO(HttpStatus.UNAUTHORIZED, "Usuario no autorizado"),
	ERROR_INTERNO(HttpStatus.INTERNAL_SERVER_ERROR,
			"Ha ocurrdo un error por favor intente mas tarde, si el error persiste comuniquese con soporte técnico.");

	private static final EnumMap<HttpStatus, CabecerasPorCodigoHttpEnum> MAP_VALOR = new EnumMap<>(HttpStatus.class);

	static {
		for (CabecerasPorCodigoHttpEnum mensaje : values()) {
			MAP_VALOR.put(mensaje.codigoError, mensaje);
		}
	}

	private final HttpStatus codigoError;
	private final String mensaje;

	/**
	 * @param nombre
	 * @param valor
	 * @param descripcion
	 */
	private CabecerasPorCodigoHttpEnum(HttpStatus codigoError, String mensaje) {
		this.codigoError = codigoError;
		this.mensaje = mensaje;
	}

	public static CabecerasPorCodigoHttpEnum buscarPorValor(HttpStatus codigoError) {
		return MAP_VALOR.get(codigoError);
	}
}
