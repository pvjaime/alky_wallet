package clases;

import java.util.ArrayList;
import java.util.List;

public class ServicioRetiros {

	public static final double MONTO_GASTO_ADMIN = 25.00;
	
	public void cargarDebitarCuentas() {
		
		CuentaBancariaRetirable cuentaBasica = new CuentaBancariaBasica();
		cuentaBasica.depositar(100);
		
		CuentaBancariaRetirable cuentaPremium = new CuentaBancariaPremium();
		cuentaPremium.depositar(200);
		
		List<CuentaBancariaRetirable> cuentas = new ArrayList();
		
		cuentas.add(cuentaBasica);
		cuentas.add(cuentaPremium);
		
		debitarGastos(cuentas);
	}

	private void debitarGastos(List<CuentaBancariaRetirable> cuentas) {
		for (CuentaBancariaRetirable cuentaBancaria : cuentas) {
			cuentaBancaria.retirar(MONTO_GASTO_ADMIN);
		}
	}

}
