package business;


import model.Citizen;
import model.Sugerencia;
import model.exception.BusinessException;

public interface CitizenService {
	
	public Citizen addCitizen(Citizen ciudadano) throws BusinessException;
	
	public void updateSugerencia(Sugerencia sugerencia) throws BusinessException;
	
	public void deleteSugerencia(Long id) throws BusinessException;
	
	public void deleteComentario(Long id) throws BusinessException;
	
	public void changePassword(Citizen user, String newPassword) throws BusinessException;
	
	public void changeEmail(Citizen user, String email)throws BusinessException;
}
