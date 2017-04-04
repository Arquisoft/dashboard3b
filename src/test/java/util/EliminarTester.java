package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Citizen;
import persistence.CitizenFinder;
import persistence.util.Jpa;


public  class EliminarTester {

	public static void borrarTester(String user){
		try{
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			Citizen citizen= CitizenFinder.findByUser(user);
			Jpa.getManager().remove(citizen);
			
			trx.commit();
			
		}catch(Exception e){
			
		}
	}
	
}
