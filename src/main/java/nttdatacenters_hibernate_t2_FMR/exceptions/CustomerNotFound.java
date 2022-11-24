package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando se busca un cliente y no existe
 * 
 * @author nandi
 *
 */
public class CustomerNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public CustomerNotFound(String msg) {
		super(msg);

	}

}
