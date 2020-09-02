package com.jspoloa.pruebalineamientoscodigo.entidades;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String securitySocialNumber;
	private boolean isAdmin;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id == other.id;
	}

	
}
