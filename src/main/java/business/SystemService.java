package business;

import java.util.List;

import model.Categoria;
import model.Sugerencia;
import model.exception.BusinessException;

public interface SystemService {
	
	public List<Categoria> findAllCategories() throws BusinessException;
	
	public List<Sugerencia> findAllSugerencias() throws BusinessException;
	
	public Sugerencia findSugerenciaById(Long id) throws BusinessException;
	
	public List<Sugerencia> findSugerenciasByCategory(Long idCategory) throws BusinessException;

}
