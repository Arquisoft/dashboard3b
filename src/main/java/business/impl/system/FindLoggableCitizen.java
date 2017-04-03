package business.impl.system;

import business.impl.Command;
import model.exception.BusinessException;
import persistence.CitizenFinder;

public class FindLoggableCitizen implements Command {

	String user;
	String password;
	
	public FindLoggableCitizen(String login, String password) {
		this.user=login;
		this.password=password;
	}
	
	@Override
	public Object execute() throws BusinessException {
		return CitizenFinder.findLoggableCitizen(user, password);
	}

}
