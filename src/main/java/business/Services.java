package business;

import business.impl.AdminServiceImpl;
import business.impl.CitizenServiceImpl;
import business.impl.SystemServiceImpl;


public class Services {
	
	public static CitizenService getCitizenServices() {
		return new CitizenServiceImpl();
	}
	
	public static AdminService getAdminServices() {
		return new AdminServiceImpl();
	}
	
	public static SystemService getSystemServices() {
		return new SystemServiceImpl();
	}

}
