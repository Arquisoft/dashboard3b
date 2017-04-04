package business.impl;

import model.Administrador;
import model.Categoria;
import model.exception.BusinessException;
import business.AdminService;
import business.impl.admin.AddAdmin;
import business.impl.admin.DeleteCategoria;
import business.impl.admin.DeleteSugerencia;
import business.impl.admin.UpdateCategoria;


public class AdminServiceImpl extends SuperService implements AdminService {
	
	private CommandExecutor cmd = new CommandExecutor();


	@Override
	public void updateCategoria(Categoria categoria) throws BusinessException {
		cmd.execute(new UpdateCategoria(categoria));
	}

	@Override
	public void deleteCategoria(Long id) throws BusinessException {
		cmd.execute(new DeleteCategoria(id));
	}

	@Override
	public void deleteSugerencia(Long id) throws BusinessException {
		cmd.execute(new DeleteSugerencia(id));
	}

	@Override
	public void addCategoria(Categoria categoria) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador addAdmin(Administrador admin) throws BusinessException {
		return (Administrador) cmd.execute(new AddAdmin(admin));
	}

}
