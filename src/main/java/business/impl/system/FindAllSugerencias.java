package business.impl.system;

import java.util.List;

import persistence.SugerenciaFinder;
import model.Sugerencia;
import model.exception.BusinessException;
import business.impl.Command;




public class FindAllSugerencias implements Command {
	
	@Override
	public List<Sugerencia> execute() throws BusinessException {
		return SugerenciaFinder.findAll();
	}

}
