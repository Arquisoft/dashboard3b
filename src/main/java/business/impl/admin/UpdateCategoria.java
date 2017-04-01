package business.impl.admin;

import persistence.util.Jpa;
import model.Categoria;
import model.exception.BusinessException;
import business.impl.Command;


public class UpdateCategoria implements Command {
	
	private Categoria categoria;
	
	public UpdateCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().merge(categoria);
		return categoria;
	}

}
