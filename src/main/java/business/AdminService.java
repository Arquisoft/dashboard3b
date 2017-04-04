package business;

import model.Administrador;
import model.Categoria;
import model.exception.BusinessException;

public interface AdminService {
	
	public void updateCategoria(Categoria categoria) throws BusinessException;
	
	public void deleteCategoria(Long id) throws BusinessException;
	
	public void deleteSugerencia(Long id) throws BusinessException;

	void addCategoria(Categoria categoria) throws BusinessException;
	
	public Administrador addAdmin(Administrador admin) throws BusinessException;
}
