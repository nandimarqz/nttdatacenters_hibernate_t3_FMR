package nttdatacenters_hibernate_t2_FMR.persistence;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "NTTDATA_T1_HIBERNATE_CUSTOMER")
public class Customer extends AbstracEntity {

	/**  */
	private static final long serialVersionUID = 1L;

	/** ID del cliente en base de datos */
	private Long customerId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String firstSurname;

	/** Segundo apellido del cliente */
	private String secondSurname;

	/** DNI del cliente */
	private String dni;

	/** Contratos del cliente */
	private List<Contract> contracts;

	/** Empleados por los que ha sido atendido */
	private List<Employee> employeesSeen;

	/***/

	/** Logger para la clase */
	private static final Logger CUSTOMERLOG = LoggerFactory.getLogger(Customer.class);

	/**
	 * Devuelve el ID del clietne
	 * 
	 * @return Long
	 */
	@Column(name = "ID")
	@Id
	@GeneratedValue(generator = "NNTDATA_SEC")
	@SequenceGenerator(name = "NNTDATA_SEC", sequenceName = "NNTDATA_CUSTOMER_SEC",allocationSize = 1)
	public Long getCustomerId() {
		CUSTOMERLOG.debug("Obteniendo el ID del cliente {}", this.dni);
		return customerId;
	}

	/**
	 * Establece el ID del cliente por el id pasado por parametro
	 * 
	 * @param id
	 */
	public void setCustomerId(Long id) {
		CUSTOMERLOG.debug("Estableciendo el ID del cliente {}", this.dni);
		this.customerId = id;
	}

	/**
	 * Devuelve el nombre del cliente
	 * 
	 * @return String
	 */
	@Column(name = "NAME")
	public String getName() {
		CUSTOMERLOG.debug("Obteniendo el nombre del cliente {}", this.dni);
		return name;
	}

	/**
	 * Establece el nombre del cliente por el nombre pasado por parametro
	 * 
	 * @param name
	 */
	public void setName(String name) {
		CUSTOMERLOG.debug("Estableciendo el nombre del cliente {}", this.dni);
		this.name = name;
	}

	/**
	 * Devuelve el primer apellido del cliente
	 * 
	 * @return String
	 */
	@Column(name = "FIRST_SURNAME")
	public String getFirstSurname() {
		CUSTOMERLOG.debug("Obteniendo el primer apellido del cliente {}", this.dni);
		return firstSurname;
	}

	/**
	 * Establece el primer apellido del cliente por el apellido pasado por parametro
	 * 
	 * @param firstSurname
	 */
	public void setFirstSurname(String firstSurname) {
		CUSTOMERLOG.debug("Estableciendo el primer apellido del cliente {}", this.dni);
		this.firstSurname = firstSurname;
	}

	/**
	 * Devuelve el segundo apellido del cliente
	 * 
	 * @return String
	 */
	@Column(name = "SECOND_SURNAME")
	public String getSecondSurname() {
		CUSTOMERLOG.debug("Obteniendo el segundo apellido del cliente {}", this.dni);
		return secondSurname;
	}

	/**
	 * Establece el segundo apellido del cliente por el apellido pasado por
	 * parametro
	 * 
	 * @param secondSurname
	 */
	public void setSecondSurname(String secondSurname) {
		CUSTOMERLOG.debug("Estableciendo el segundo apellido del cliente {}", this.dni);
		this.secondSurname = secondSurname;
	}

	/**
	 * Devuelve el DNI del cliente
	 * 
	 * @return String
	 */
	@Column(name = "DNI", unique = true, nullable = false, length = 9)
	public String getDni() {
		CUSTOMERLOG.debug("Obteniendo el DNI del cliente {}", this.dni);
		return dni;
	}

	/**
	 * Establece el DNI del cliente por el DNI pasado por parametro
	 * 
	 * @param dni
	 */
	public void setDni(String dni) {
		CUSTOMERLOG.debug("Estableciendo el DNI del cliente {}", this.dni);
		this.dni = dni;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "NTTDATA_HIBERNATE_T2_ATENDIDOS", joinColumns = @JoinColumn(name = "ID_CLIENTE"), inverseJoinColumns = @JoinColumn(name = "ID_EMPLEADO"))
	public List<Employee> getEmployeesSeen() {
		return employeesSeen;
	}

	public void setEmployeesSeen(List<Employee> employeesSeen) {
		this.employeesSeen = employeesSeen;
	}

	@Override
	@Transient
	public Long getId() {

		return this.customerId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.customerId = id;

	}

	@Override
	public int hashCode() {
		CUSTOMERLOG.debug("Obteniendo el HASH del cliente {}", this.dni);
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Customer [id=" + customerId + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname="
				+ secondSurname + ", dni=" + dni + "]";
	}

}
