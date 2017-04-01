package business;


import model.Sugerencia;

import model.exception.BusinessException;

public interface CitizenService {
	
	public void updateSugerencia(Sugerencia sugerencia) throws BusinessException;
	
	public void deleteSugerencia(Long id) throws BusinessException;
	
	public void deleteComentario(Long id) throws BusinessException;

}
