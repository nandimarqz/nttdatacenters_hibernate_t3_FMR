package nttdatacenters_hibernate_t2_FMR.exceptions;

/**
 * Excepcion para cuando existe un tipo de contrato que se va a insertar
 * @author nandi
 *
 */
public class ExistingContractType extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor excepcion
	 * 
	 * @param msg
	 */
	public ExistingContractType(String msg) {
		super(msg);
		
		
	}
	
}
