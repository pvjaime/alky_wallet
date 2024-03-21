package clases;

public class CuentaBancariaPremium extends CuentaBancariaRetirable{

	private double saldo;
	private int puntosPrefiero;
	
	@Override
	public void depositar(double monto) {
		this.saldo += monto;
		aumentarPuntosPrefiero();
	}

	@Override
	public boolean retirar(double monto) {
		if(this.saldo < monto) {
			return false;
		}else {
			this.saldo -= monto;
			aumentarPuntosPrefiero();
			return true;
		}
	}

	private void aumentarPuntosPrefiero() {
		this.puntosPrefiero++;	
	}
	
}
