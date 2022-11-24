package nttdatacenters_hibernate_t2_FMR.exceptions;
/**
 * Excepcion para cuando se busca un contrato y no existe
 * @author nandi
 *
 */
public class ContractNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public ContractNotFound(String msg) {
		super(msg);
		
		
	}

}
