package business.impl.admin;

import business.impl.Command;
import model.Categoria;
import model.exception.BusinessException;
import persistence.util.Jpa;

public class DeleteCategoria implements Command {
	
	private Long idCategoria;
	
	public DeleteCategoria(Long id) {
		this.idCategoria = id;
	}

	@Override
	public Object execute() throws BusinessException {
		Categoria categoria = Jpa.getManager().find(Categoria.class, idCategoria);
		Jpa.getManager().remove(categoria);
		return categoria;
	}

}
