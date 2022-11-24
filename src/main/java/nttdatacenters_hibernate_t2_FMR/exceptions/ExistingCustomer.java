package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando existe un cliente que se va insertar
 * @author nandi
 *
 */
public class ExistingCustomer extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public ExistingCustomer(String msg) {
		super(msg);

	}

}
