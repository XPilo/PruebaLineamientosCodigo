package com.jspoloa.pruebalineamientoscodigo.servicios.implementacion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspoloa.pruebalineamientoscodigo.dtos.UsuarioDTO;
import com.jspoloa.pruebalineamientoscodigo.entidades.Usuario;
import com.jspoloa.pruebalineamientoscodigo.excepciones.UnauthorizedException;
import com.jspoloa.pruebalineamientoscodigo.servicios.ServicioMapeoEntidadesI;

@Service
public class ServicioMapeoEntidades implements ServicioMapeoEntidadesI{

	@Autowired
	ModelMapper modelMapper;

	public UsuarioDTO aDto(Long usuarioId) throws UnauthorizedException {
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);
		usuario.setFirstName("prueba a DTO");
		usuario.setEmail("email");
		
		if(usuario.getId() != 1) {
			throw new UnauthorizedException();
		}
		
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	public Usuario aEntidad() {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(1l);
		usuarioDTO.setFirstName("prueba a Entidad");
		usuarioDTO.setEmail("email");

		return modelMapper.map(usuarioDTO, Usuario.class);
	}
}
