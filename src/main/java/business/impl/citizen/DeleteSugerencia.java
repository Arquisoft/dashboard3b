package business.impl.citizen;

import persistence.util.Jpa;
import model.Sugerencia;
import model.exception.BusinessException;
import business.impl.Command;


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
