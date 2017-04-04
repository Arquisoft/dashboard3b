package business.impl.admin;

import business.impl.Command;
import model.Administrador;
import model.exception.BusinessException;
import persistence.util.Jpa;

public class AddAdmin implements Command {

	private Administrador admin;
	
	public AddAdmin(Administrador admin) {
		this.admin = admin;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().persist(admin);
		return admin;
	}

}
