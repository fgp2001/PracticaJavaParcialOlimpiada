package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class ComplejoDeportivo {

	private String nombre;
	private Double areaTotalOcupada;
	private List<Evento> eventos;

	public ComplejoDeportivo(String nombre, Double areaTotalOcupada) {
		super();
		this.nombre = nombre;
		this.areaTotalOcupada = areaTotalOcupada;
		this.eventos = new ArrayList<>();
	}

	public Boolean agregarEvento(Evento evento) throws Exception {
		if (evento == null) {
			throw new Exception("El evento es nulo.");
		}
		return this.eventos.add(evento);
	}

	public Evento buscarEventoPorNombre(String nombre) {
		Evento evento = null;
		for (Evento e : eventos) {
			if (e.getNombre().equals(nombre)) {
				evento = e;
				break;
			}
		}
		return evento;
	}
	
	public List<Evento> listarEventos(){
		return this.eventos;
	}
}
