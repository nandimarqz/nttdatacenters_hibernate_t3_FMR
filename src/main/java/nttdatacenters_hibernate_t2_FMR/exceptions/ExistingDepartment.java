package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando existe un departamento que se quiere insertar
 * 
 * @author nandi
 *
 */
public class ExistingDepartment extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public ExistingDepartment(String msg) {
		super(msg);
		
		
	}
}
