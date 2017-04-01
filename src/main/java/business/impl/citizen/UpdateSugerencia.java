package business.impl.citizen;

import persistence.util.Jpa;
import business.impl.Command;
import model.Sugerencia;
import model.exception.BusinessException;



public class UpdateSugerencia implements Command {
	
	private Sugerencia sugerencia;
	
	public UpdateSugerencia(Sugerencia sugerencia) {
		this.sugerencia = sugerencia;
	}

	@Override
	public Object execute() throws BusinessException {
		Jpa.getManager().merge(sugerencia);
		return sugerencia;
	}

}
