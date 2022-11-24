package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando el cliente que se busca no existe
 * 
 * @author nandi
 *
 */
public class EmployeeNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public EmployeeNotFound(String msg) {
		super(msg);
		
		
	}
	
}
