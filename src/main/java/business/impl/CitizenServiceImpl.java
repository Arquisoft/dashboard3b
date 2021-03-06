package business.impl;

import persistence.CitizenFinder;
import scala.NotImplementedError;
import util.Encriptador;
import business.CitizenService;
import business.impl.citizen.*;
import model.*;
import model.exception.BusinessException;

public class CitizenServiceImpl extends SuperService implements CitizenService {
	
	private CommandExecutor cmd = new CommandExecutor();
	
	
	@Override
	public void updateSugerencia(Sugerencia sugerencia) throws BusinessException {
		cmd.execute(new UpdateSugerencia(sugerencia));
	}



	@Override
	public void deleteSugerencia(Long id) throws BusinessException {
		throw new NotImplementedError();
		
	}

	@Override
	public void deleteComentario(Long id) throws BusinessException {
		throw new NotImplementedError();
		
	}




	@Override
	public void changePassword(Citizen user, String newPassword) throws BusinessException {
	
		if(CitizenFinder.findByUser(user.getUsuario())!=null){
			user.setPassword(Encriptador.encriptar(newPassword));
			cmd.execute(new UpdateCitizen(user));
		}
	}

	@Override
	public void changeEmail(Citizen user, String email) throws BusinessException {
		if(CitizenFinder.findByUser(user.getUsuario())!=null){
			user.setEmail(email);
			cmd.execute(new UpdateCitizen(user));
		}
	}



	@Override
	public Citizen addCitizen(Citizen ciudadano) throws BusinessException {
//		if(CitizenFinder.findLoggableCitizen(ciudadano.getUsuario(), ciudadano.getPassword())==null){
			cmd.execute(new AddCitizen(ciudadano));
			return ciudadano;
	}	
	

}
