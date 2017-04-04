package business.impl.citizen;

import business.impl.Command;
import model.Citizen;
import model.Sugerencia;
import model.exception.BusinessException;
import persistence.util.Jpa;

public class AddCitizen implements Command {

	private Citizen citizen;
	
	public AddCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(citizen);
		return citizen;
	}

}
