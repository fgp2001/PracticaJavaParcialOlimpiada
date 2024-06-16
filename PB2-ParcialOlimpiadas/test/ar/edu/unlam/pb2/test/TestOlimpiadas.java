package ar.edu.unlam.pb2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.dominio.ComplejoDeportivo;
import ar.edu.unlam.pb2.dominio.ComplejoPolideportivo;
import ar.edu.unlam.pb2.dominio.ComplejoSimple;
import ar.edu.unlam.pb2.dominio.Evento;
import ar.edu.unlam.pb2.dominio.IndicadorAreaException;
import ar.edu.unlam.pb2.dominio.Juez;
import ar.edu.unlam.pb2.dominio.Observador;
import ar.edu.unlam.pb2.dominio.SedeOlimpica;
import ar.edu.unlam.pb2.dominio.Comisario;
import ar.edu.unlam.pb2.dominio.ComisarioException;

public class TestOlimpiadas {

	private SedeOlimpica sede;
	private static final String NOMBRE_SEDE = "San Martin";

	@Before
	public void init() {

		this.sede = new SedeOlimpica(NOMBRE_SEDE);
	}

	@Test
	public void queSePuedaCrearUnComplejoSimpleEnUnaSedeOlimpica() throws Exception {
		String nombreComplejo = "Lionel Messi";
		Double areaOcupada = 200.0;

		ComplejoDeportivo complejo = new ComplejoSimple(nombreComplejo, areaOcupada);

		Boolean creado = sede.crearComplejo(complejo);
		assertTrue(creado);

	}

	@Test(expected = Exception.class)
	public void queNoSePuedaCrearUnComplejoSimpleEnUnaSedeOlimpicaSiEsteYaFueCreado() throws Exception {
		String nombreComplejo = "Lionel Messi";
		Double areaOcupada = 200.0;

		ComplejoDeportivo complejo = new ComplejoSimple(nombreComplejo, areaOcupada);
		sede.crearComplejo(complejo);
		sede.crearComplejo(complejo);
	}

	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaEnUnaSedeOlimpica() throws Exception {
		String nombreComplejoDep = "Lionel Messi2";
		Double areaOcupadaDep = 200.0;
		ComplejoDeportivo complejo2 = new ComplejoPolideportivo(nombreComplejoDep, areaOcupadaDep);
		boolean creado = sede.crearComplejo(complejo2);

		assertTrue(creado);
	}

	@Test
	public void queSePuedaCrearUnComplejoPolideportivoConUnAreaYUnEventoEnUnaSedeOlimpica() throws Exception {
		String nombreComplejoDep = "Lionel Messi2";
		Double areaOcupadaDep = 200.0;

		String nombreEvento = "Carrera 1";
		LocalDate fecha = LocalDate.of(2024, 6, 13);
		Double duracion = 120.0;
		Integer numeroParticipantes = 4;

		Evento evento = new Evento(nombreEvento, fecha, duracion, numeroParticipantes);

		ComplejoDeportivo complejo2 = new ComplejoPolideportivo(nombreComplejoDep, areaOcupadaDep);
		sede.crearComplejo(complejo2);

		boolean creado = sede.agregarEventoAlComplejo(evento, complejo2);
		sede.agregarAreaDeportivaAlComplejoPolideportivo((ComplejoPolideportivo) complejo2, "Centro");

		assertTrue(creado);
	}

	@Test(expected = IndicadorAreaException.class)
	public void queAlAgregarUnAreaAUnPolideportivoConIndicadorYaExistenteLanceUnaExcepcionIndicadorAreaException()
			throws Exception {
		String nombreComplejoDep = "Lionel Messi2";
		Double areaOcupadaDep = 200.0;
		ComplejoDeportivo complejo1 = new ComplejoPolideportivo(nombreComplejoDep, areaOcupadaDep);
		sede.crearComplejo(complejo1);

		sede.agregarAreaDeportivaAlComplejoPolideportivo((ComplejoPolideportivo) complejo1, "Centro");
		sede.agregarAreaDeportivaAlComplejoPolideportivo((ComplejoPolideportivo) complejo1, "Centro");
	}

	@Test
	public void queSePuedaAgregarUnComisarioJuezAUnEvento() throws Exception {
		String nombreComplejoDep = "Lionel Messi2";
		Double areaOcupadaDep = 200.0;
		ComplejoDeportivo complejo1 = new ComplejoPolideportivo(nombreComplejoDep, areaOcupadaDep);

		String nombreEvento = "Carrera 1";
		LocalDate fecha = LocalDate.of(2024, 6, 13);
		Double duracion = 120.0;
		Integer numeroParticipantes = 4;

		Evento evento = new Evento(nombreEvento, fecha, duracion, numeroParticipantes);

		Integer dni = 43102959;
		String nombre = "Facundo";
		Integer edad = 20;
		Comisario comisario = new Juez(dni, nombre, edad);

		sede.crearComplejo(complejo1);
		sede.agregarEventoAlComplejo(evento, complejo1);
		boolean agregado = sede.agregarComisarioJuezAUnEvento(complejo1, evento.getNombre(), comisario);

		assertTrue(agregado);

	}

	@Test(expected = ComisarioException.class)
	public void queAlAgregarUnComisarioJuezInexistenteLanceUnaExcepcionComisarioException() throws Exception {

		String nombreComplejoDep = "Lionel Messi2";
		Double areaOcupadaDep = 200.0;
		ComplejoDeportivo complejo1 = new ComplejoPolideportivo(nombreComplejoDep, areaOcupadaDep);

		String nombreEvento = "Carrera 1";
		LocalDate fecha = LocalDate.of(2024, 6, 13);
		Double duracion = 120.0;
		Integer numeroParticipantes = 4;

		Evento evento = new Evento(nombreEvento, fecha, duracion, numeroParticipantes);

		Comisario comisario = null;

		sede.crearComplejo(complejo1);
		sede.agregarEventoAlComplejo(evento, complejo1);
		sede.agregarComisarioJuezAUnEvento(complejo1, evento.getNombre(), comisario);

	}
	
	@Test
	public void queSePuedaCalcularElTotalDeParticipantesDeLosEventosDeUnComplejoSimple() throws Exception {

		String nombreComplejoDep = "Lionel Messi2";
		Double areaOcupadaDep = 200.0;
		ComplejoDeportivo complejo1 = new ComplejoSimple(nombreComplejoDep, areaOcupadaDep);
		
		String nombreEvento = "Carrera 1";
		LocalDate fecha = LocalDate.of(2024, 6, 13);
		Double duracion = 120.0;
		Integer numeroParticipantes = 4;
		
		String nombreEvento2 = "Carrera 2";
		LocalDate fecha2 = LocalDate.of(2024, 6, 13);
		Double duracion2 = 120.0;
		Integer numeroParticipantes2 = 25;
		
		Evento evento = new Evento(nombreEvento, fecha, duracion, numeroParticipantes);
		Evento evento2 = new Evento(nombreEvento2, fecha2, duracion2, numeroParticipantes2);
		
		
		sede.crearComplejo(complejo1);
		sede.agregarEventoAlComplejo(evento, complejo1);
		sede.agregarEventoAlComplejo(evento2, complejo1);
		
		Integer totalParticipantes = sede.calcularTotalDeParticipantesDeUnEventoEnUnComplejoSimple(complejo1);
		Integer valorEsperado = 29;
		
		assertEquals(valorEsperado, totalParticipantes);
		
	}

}
