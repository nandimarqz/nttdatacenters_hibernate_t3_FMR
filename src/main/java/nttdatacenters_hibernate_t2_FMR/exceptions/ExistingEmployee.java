package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando ya existe un empleado que se quiere insertar
 * 
 * @author nandi
 *
 */
public class ExistingEmployee extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public ExistingEmployee(String msg) {
		super(msg);
		
		
	}
	
}
