package business.impl.system;

import persistence.SugerenciaFinder;
import model.exception.BusinessException;
import business.impl.Command;



public class FindSugerenciaById implements Command {
	
	private Long id;

	public FindSugerenciaById(Long id) {
		this.id = id;
	}
	
	@Override
	public Object execute() throws BusinessException {
		return SugerenciaFinder.findById(id);
	}

}
