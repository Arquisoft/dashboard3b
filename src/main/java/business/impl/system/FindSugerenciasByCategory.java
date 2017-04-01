package business.impl.system;

import persistence.SugerenciaFinder;
import model.exception.BusinessException;
import business.impl.Command;


public class FindSugerenciasByCategory implements Command {
	
	private Long idCategory;

	public FindSugerenciasByCategory(Long id) {
		this.idCategory = id;
	}
	
	@Override
	public Object execute() throws BusinessException {
		return SugerenciaFinder.findByCategory(idCategory);
	}

}
