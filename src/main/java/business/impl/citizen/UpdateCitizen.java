package business.impl.citizen;

import model.Citizen;
import model.exception.BusinessException;
import persistence.util.Jpa;
import business.impl.Command;

public class UpdateCitizen implements Command{
	private Citizen ciudadano;
	
	public UpdateCitizen(Citizen citizen) {
		this.ciudadano= citizen;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().merge(ciudadano);
		return ciudadano;
	}
}
