package persistence;

import java.util.List;

import model.Administrador;
import persistence.util.Jpa;

public class AdministradorFinder {
	
	public static Administrador findByUserAndPass(String user, String pass) {
		List<Administrador> admin = Jpa.getManager().createNamedQuery("Administrador.findByUserAndPass", Administrador.class).
				setParameter(1, user).setParameter(2, pass).getResultList();
		if(!admin.isEmpty()){
			return admin.get(0);
		}
		else return null;
	}

}
