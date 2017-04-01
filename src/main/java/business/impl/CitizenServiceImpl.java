package business.impl;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComentario(Long id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	

}
