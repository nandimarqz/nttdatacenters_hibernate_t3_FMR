package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando existe un contrato que se va a insertar
 * 
 * @author nandi
 *
 */
public class ExistingContract extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public ExistingContract(String msg) {
		super(msg);
		
		
	}
}
