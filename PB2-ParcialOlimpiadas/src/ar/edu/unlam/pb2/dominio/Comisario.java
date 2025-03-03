package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public abstract class Comisario {
	
	private Integer dni;
	private String nombre;
	private Integer edad;
	
	public Comisario(Integer dni, String nombre, Integer edad) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comisario other = (Comisario) obj;
		return Objects.equals(dni, other.dni);
	}
	
	
}
