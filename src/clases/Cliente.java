package clases;

public class Cliente {
	//Atributos de una clase
	long id;
	String nombre;
	CuentaBancariaOld cuenta;
	
	/**
	 * Constructor Vacio
	 */
	public Cliente() {
	}
	
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param cuenta
	 */
	public Cliente(long id, String nombre, CuentaBancariaOld cuenta) {
		this.id = id;
		this.nombre = nombre;
		this.cuenta = cuenta;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cuenta
	 */
	public CuentaBancariaOld getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(CuentaBancariaOld cuenta) {
		this.cuenta = cuenta;
	}
	
	public void imprimirDatos() {
		// Vamos a mostrar los datos de la cuenta del jorge
		System.out.println(" ---- Datos Cliente ---- ");
		System.out.println(" Num Cuenta: " + id);
		System.out.println(" Titular: " + nombre);
		System.out.println(" ---- Datos Bancarios ---- ");
		System.out.println(" Num Cuenta: " + cuenta.getNumeroCuenta());
		System.out.println(" Saldo: " + cuenta.getSaldoCuenta());
	}
	
}
