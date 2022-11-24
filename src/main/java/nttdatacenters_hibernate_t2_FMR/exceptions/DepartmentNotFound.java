package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando se busca y departamento y no existe
 * 
 * @author nandi
 *
 */
public class DepartmentNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public DepartmentNotFound(String msg) {
		super(msg);
		
		
	}
}
