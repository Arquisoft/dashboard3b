package business;

import java.util.List;

import model.Administrador;
import model.Categoria;
import model.Citizen;
import model.Sugerencia;
import model.exception.BusinessException;

public interface SystemService {
	
	public List<Categoria> findAllCategories() throws BusinessException;
	
	public List<Sugerencia> findAllSugerencias() throws BusinessException;
	
	public Sugerencia findSugerenciaById(Long id) throws BusinessException;
	
	public List<Sugerencia> findSugerenciasByCategory(Long idCategory) throws BusinessException;
	
	public Citizen findLoggableCitizen(String usuario, String password) throws BusinessException;

	public Administrador findLoggableAdmin(String usuario, String password) throws BusinessException;

}
