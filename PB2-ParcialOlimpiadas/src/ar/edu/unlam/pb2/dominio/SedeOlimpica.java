package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SedeOlimpica {

	private String nombre;
	private ArrayList<ComplejoDeportivo> complejos;

	public SedeOlimpica(String nombre) {
		this.nombre = nombre;
		this.complejos = new ArrayList<>();
	}

	public Boolean crearComplejo(ComplejoDeportivo complejo) throws Exception {

		if (!this.complejos.contains(complejo)) {
			return this.complejos.add(complejo);

		}
		throw new Exception("El complejo no pudo agregarse ya que el mismo ya existe.");

	}

	public Boolean agregarEventoAlComplejo(Evento evento, ComplejoDeportivo complejo) throws Exception {
		
			
		for (ComplejoDeportivo c : this.complejos) {

			if (c.equals(complejo)) {

				c.agregarEvento(evento);
				return true;
			}
		}
		throw new ComplejoInexistenteException("El complejo es Inexistente");
	}
	
	public Boolean agregarAreaDeportivaAlComplejoPolideportivo (ComplejoPolideportivo complejo, String area) throws IndicadorAreaException {
		
		for (ComplejoDeportivo c : this.complejos) {
			if (c.equals(complejo)) {
				complejo.agregarAreaDeportiva(area);
				return true;
			}
		}
		throw new IndicadorAreaException("Area ya agregada");
	}
	
	public Boolean agregarComisarioJuezAUnEvento(ComplejoDeportivo complejo, String nombreEvento, Comisario comisario) throws Exception{
		Evento eventoBuscado = null;
		for (ComplejoDeportivo c : this.complejos) {
			if (c.equals(complejo)) {
				eventoBuscado = complejo.buscarEventoPorNombre(nombreEvento);
				break;
			}	
		}
		
		if (eventoBuscado == null) {
			throw new Exception("El evento ingresado no existe.");
		}
		
		if (!(comisario instanceof Juez)) {
			throw new ComisarioException("El comisario no es un juez.");
		}
		
		return eventoBuscado.agregarComisario(comisario);
	}
	
	public Integer calcularTotalDeParticipantesDeUnEventoEnUnComplejoSimple(ComplejoDeportivo complejo) throws ComplejoInexistenteException {
		ComplejoSimple complejoEncontrado = null;
		Integer totalParticipantes = 0;
		
		
		for (ComplejoDeportivo c : this.complejos) {
			if (c instanceof ComplejoSimple && c.equals(complejo)) {
				complejoEncontrado = (ComplejoSimple) c;
				List<Evento> eventos = complejoEncontrado.listarEventos();
				for (Evento e : eventos) {
					totalParticipantes += e.getNumeroParticipantes();
				}
				return totalParticipantes;
			}

		}
		
		throw new ComplejoInexistenteException("El complejo no fue encontrado.");
		
	}
	
}