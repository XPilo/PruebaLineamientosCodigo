package com.jspoloa.pruebalineamientoscodigo.controladores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspoloa.pruebalineamientoscodigo.dtos.UsuarioDTO;
import com.jspoloa.pruebalineamientoscodigo.entidades.Usuario;
import com.jspoloa.pruebalineamientoscodigo.excepciones.UnauthorizedException;
import com.jspoloa.pruebalineamientoscodigo.servicios.ServicioGenerarHeaderErrorI;
import com.jspoloa.pruebalineamientoscodigo.servicios.ServicioMapeoEntidadesI;

@RestController
@CrossOrigin
@RequestMapping("/pruebasspring")
public class ControladorPruebasSpring {

	private Logger logger = LogManager.getLogger(ControladorPruebasSpring.class);
	
	@Autowired
	ServicioMapeoEntidadesI servicioMapeoEntidades;

	@Autowired
	ServicioGenerarHeaderErrorI servicioGenerarHeaderError;

	@GetMapping(path = "/adto", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDTO> aDTO(@RequestParam("usuarioid") Long usuarioId) {
		try {
			return ResponseEntity.ok(servicioMapeoEntidades.aDto(usuarioId));
		} catch (UnauthorizedException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.headers(servicioGenerarHeaderError.generarHeader(HttpStatus.UNAUTHORIZED)).build();
		} catch (Exception e) {
			logger.error("", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.headers(servicioGenerarHeaderError.generarHeader(HttpStatus.INTERNAL_SERVER_ERROR)).build();
		}
	}

	@GetMapping(path = "/aentidad", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> aEntidad() {
		try {
			return ResponseEntity.ok(servicioMapeoEntidades.aEntidad());
		} catch (Exception e) {
			logger.error("", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.headers(servicioGenerarHeaderError.generarHeader(HttpStatus.INTERNAL_SERVER_ERROR)).build();
		}
	}
}
