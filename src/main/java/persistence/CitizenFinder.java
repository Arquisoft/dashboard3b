package persistence;

import java.util.List;

import model.Citizen;
import persistence.util.Jpa;

public class CitizenFinder {

	// public static Citizen findByDNI(String dni) {
	// return (Citizen) Jpa.getManager().createNamedQuery("Citizen.findByDNI",
	// Citizen.class).setParameter(1, dni)
	// .getResultList()).stream().findFirst().orElse(null);
	// }

	public static List<Citizen> findAll() {
		return Jpa.getManager()
				.createNamedQuery("Citizen.findAll", Citizen.class)
				.getResultList();
	}

	public static Citizen findByUser(String nombre) {
		List<Citizen> r = Jpa.getManager()
				.createNamedQuery("Citizen.findByUser", Citizen.class)
				.setParameter(1, nombre).getResultList();
		if (r.isEmpty())
			return null;

		return r.get(0);
	}

	public static Citizen findLoggableCitizen(String user, String password) {
		List<Citizen> r=Jpa.getManager().createNamedQuery("Citizen.findByUserAndPass", Citizen.class).
				setParameter(1, user).setParameter(2, password).getResultList();
		if (r.isEmpty())
			return null;

		return r.get(0);
	}
}
