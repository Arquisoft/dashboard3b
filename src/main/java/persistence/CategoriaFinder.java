package persistence;

import java.util.List;

import model.Categoria;
import persistence.util.Jpa;

public class CategoriaFinder {
	
	public static List<Categoria> findAll() {
		return Jpa.getManager().createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
	}
	
}
