package ar.edu.unlam.pb2.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Evento {

	private String nombre;
	private LocalDate fecha;
	private Double duracion;
	private Integer numeroParticipantes;
	private Set<Comisario> comisarios;

	public Evento(String nombre, LocalDate fecha, Double duracion, Integer numeroParticipantes) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.duracion = duracion;
		this.numeroParticipantes = numeroParticipantes;
		this.comisarios = new HashSet<>();
	}

	public Boolean agregarComisario(Comisario comisario) throws Exception {
		if (comisario == null) {
			throw new Exception("Comisario Inexistente");
		}

		return this.comisarios.add(comisario);

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroParticipantes() {
		return numeroParticipantes;
	}

	public void setNumeroParticipantes(Integer numeroParticipantes) {
		this.numeroParticipantes = numeroParticipantes;
	}

	
}
