package business.impl.admin;

import persistence.util.Jpa;
import business.impl.Command;
import model.*;
import model.exception.BusinessException;

public class DeleteSugerencia implements Command{
	
	private Long idSugerencia;
	
	public DeleteSugerencia(Long id) {
		this.idSugerencia = id;
	}

	@Override
	public Object execute() throws BusinessException {
		Sugerencia sugerencia = Jpa.getManager().find(Sugerencia.class, idSugerencia);
		Jpa.getManager().remove(sugerencia);
		return sugerencia;
	}

}
