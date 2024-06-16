package ar.edu.unlam.pb2.dominio;

import java.util.Objects;

public class AreaDeporte {
	
	private String nombre;
	private String ubicacion;
	
	
	public AreaDeporte(String nombre, String ubicacion) {
	
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ubicacion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaDeporte other = (AreaDeporte) obj;
		return Objects.equals(ubicacion, other.ubicacion);
	}
	
}
