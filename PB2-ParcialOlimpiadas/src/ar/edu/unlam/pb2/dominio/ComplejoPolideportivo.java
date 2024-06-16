package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ComplejoPolideportivo extends ComplejoDeportivo {
	private List<String> areas;

	public ComplejoPolideportivo(String nombre, Double areaTotalOcupada) {
		super(nombre, areaTotalOcupada);
		this.areas = new ArrayList<>();
	}

	
	public void agregarAreaDeportiva(String area) throws IndicadorAreaException{
		
		for (String a : this.areas) {
			if (a.equals(area)) {
				throw new IndicadorAreaException("El area ya fue agregada");
			}
		}
		
		this.areas.add(area);
		
	};


}
