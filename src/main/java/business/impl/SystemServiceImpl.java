package business.impl;

import java.util.List;

import business.SystemService;
import business.impl.system.*;
import model.*;
import model.exception.BusinessException;

public class SystemServiceImpl extends SuperService implements SystemService {
	
	private CommandExecutor cmd = new CommandExecutor();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllCategories() throws BusinessException {
		return (List<Categoria>) cmd.execute(new FindAllCategories());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sugerencia> findAllSugerencias() throws BusinessException {
		return (List<Sugerencia>) cmd.execute(new FindAllSugerencias());
	}

	@Override
	public Sugerencia findSugerenciaById(Long id) throws BusinessException {
		return (Sugerencia) cmd.execute(new FindSugerenciaById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sugerencia> findSugerenciasByCategory(Long idCategory) throws BusinessException {
		return (List<Sugerencia>) cmd.execute(new FindSugerenciasByCategory(idCategory));
	}

	@Override
	public Citizen findLoggableCitizen(String user, String password)
			throws BusinessException {
		return (Citizen) cmd.execute(new FindLoggableCitizen(user,password));
	}

	@Override
	public Administrador findLoggableAdmin(String usuario, String password)
			throws BusinessException {
		return (Administrador) cmd.execute(new FindLoggableAdmin(usuario, password));
	}

}
