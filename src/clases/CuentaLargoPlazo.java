package clases;

public class CuentaLargoPlazo extends CuentaBancaria{

	private double saldo;
	
	@Override
	public void depositar(double monto) {
		this.saldo += monto;
		
	}

}
