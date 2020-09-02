package com.jspoloa.pruebalineamientoscodigo.servicios;

import com.jspoloa.pruebalineamientoscodigo.dtos.UsuarioDTO;
import com.jspoloa.pruebalineamientoscodigo.entidades.Usuario;
import com.jspoloa.pruebalineamientoscodigo.excepciones.UnauthorizedException;

public interface ServicioMapeoEntidadesI {
	
	public UsuarioDTO aDto(Long usuarioId) throws UnauthorizedException;
	
	public Usuario aEntidad();

}
