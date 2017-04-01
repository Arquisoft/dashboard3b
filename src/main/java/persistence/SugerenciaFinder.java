package persistence;

import java.util.List;

import model.Sugerencia;
import persistence.util.Jpa;

public class SugerenciaFinder {
	
	public static List<Sugerencia> findAll() {
		return Jpa.getManager().createNamedQuery("Sugerencia.findAll", Sugerencia.class).getResultList();
	}
	
	public static Sugerencia findById(Long id) {
		return Jpa.getManager().createNamedQuery("Sugerencia.findById", Sugerencia.class).getSingleResult();
	}

	public static Object findByCategory(Long idCategory) {
		return Jpa.getManager().createNamedQuery("Sugerencia.findByCategory", Sugerencia.class).getResultList();
	}

}
