package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando se busca un tipo de contrato y no existe
 * 
 * @author nandi
 *
 */
public class ContractTypeNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public ContractTypeNotFound(String msg) {
		super(msg);

	}

}
