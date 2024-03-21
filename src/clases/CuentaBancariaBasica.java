package clases;

public class CuentaBancariaBasica extends CuentaBancariaRetirable{

	private double saldo;
	
	@Override
	public void depositar(double monto) {
		this.saldo += monto;
	}

	@Override
	public boolean retirar(double monto) {
		if(this.saldo < monto) {
			return false;
		}else {
			this.saldo -= monto;
			return true;
		}
	}

	
}
