package clases;

public class CuentaUSD extends CuentaBancaria{
	
	Dolar dolarConversion = new Dolar();
	
	@Override
	public void ingresarDinero(double montoIngresado) {
		montoIngresado = montoIngresado * dolarConversion.getFactorConversion(); 
		super.ingresarDinero(montoIngresado);
	}
	
	@Override
	public void retirarDinero(double montoRetirado) {
		montoRetirado = montoRetirado * dolarConversion.getFactorConversion(); 
		super.retirarDinero(montoRetirado);
	}
}
