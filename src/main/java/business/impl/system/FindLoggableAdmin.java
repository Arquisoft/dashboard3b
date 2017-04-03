package business.impl.system;

import model.exception.BusinessException;
import persistence.AdministradorFinder;
import business.impl.Command;

public class FindLoggableAdmin implements Command {

	String user;
	String password;
	
	public FindLoggableAdmin(String login, String password) {
		this.user=login;
		this.password=password;
	}
	
	@Override
	public Object execute() throws BusinessException {
		return AdministradorFinder.findByUserAndPass(user, password);
	}

}
