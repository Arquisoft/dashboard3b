package business.impl.system;


import java.util.List;

import persistence.CategoriaFinder;
import model.Categoria;
import model.exception.BusinessException;
import business.impl.Command;


public class FindAllCategories implements Command {
	
	@Override
	public List<Categoria> execute() throws BusinessException {
		return CategoriaFinder.findAll();
	}

}
