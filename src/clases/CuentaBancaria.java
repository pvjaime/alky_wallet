package clases;

/**
 * Se define la clase cuenta con <br>
 * sus respectivos parametros
 */
public class CuentaBancaria {
	/**
	 * Tiene 3 datos que son ,int numeroCuenta , String titular, double saldoCuenta
	 */
	private int numeroCuenta;
	private String titular;
	private double saldoCuenta;

	// Creamos los constructores
	/**
	 * Constructor Vacio
	 */
	public CuentaBancaria() {
	}

	/**
	 * Constructor con datos
	 * 
	 * @param numeroCuenta Numero de la cuenta de usuario
	 * @param titular      Nombre del titular
	 * @param saldoCuenta  Saldo Inicial de la cuenta
	 */
	public CuentaBancaria(int numeroCuenta, String titular, double saldoCuenta) {
		this.numeroCuenta = numeroCuenta;
		this.titular = titular;
		this.saldoCuenta = saldoCuenta;
	}

	// Get & Seters
	/**
	 * @return the numeroCuenta
	 */
	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * @return the titular
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * @param titular the titular to set
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * @return the saldoCuenta
	 */
	public double getSaldoCuenta() {
		return saldoCuenta;
	}

	/**
	 * @param saldoCuenta the saldoCuenta to set
	 */
	public void setSaldoCuenta(double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	// Metodos extras
	/**
	 * Metodo para ingresar saldo a nuestra cuenta
	 * 
	 * @param montoIngresado
	 */
	public void ingresarDinero(double montoIngresado) {
		this.saldoCuenta = this.saldoCuenta + montoIngresado;
	}

	/**
	 * Metodo para retirar saldo de nuestra cuenta
	 * 
	 * @param montoRetirado
	 */
	public void retirarDinero(double montoRetirado) {
		// Validar si podemos retirar el dinero
		if (this.saldoCuenta >= montoRetirado) {
			this.saldoCuenta = this.saldoCuenta - montoRetirado;
		} else {
			System.out.println("Saldo insuficiente para retiro, el saldo actual es: " + this.saldoCuenta);
		}
	}

	/**
	 * Metodo que no recibe parametros y que imprime la data
	 */
	public void imprimirDatos() {
		// Vamos a mostrar los datos de la cuenta del jorge
		System.out.println(" ---- Datos Bancarios ---- ");
		System.out.println(" Num Cuenta: " + numeroCuenta);
		System.out.println(" Titular: " + titular);
		System.out.println(" Saldo: " + saldoCuenta);
	}
}
