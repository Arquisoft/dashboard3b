package persistence;

import model.Administrador;
import persistence.util.Jpa;

public class AdministradorFinder {
	
	public static Object findByUserAndPass(String user, String pass) {
		return Jpa.getManager().createNamedQuery("Administrador.findByUserAndPass", Administrador.class).
				setParameter(1, user).setParameter(2, pass).getSingleResult();
	}

}
