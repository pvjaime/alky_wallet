package wallet;

import java.util.Scanner;

import clases.Cliente;
import clases.CuentaBancaria;
import clases.CuentaUSD;
import clases.Efectivo;
import clases.FormaPago;
import clases.PayPal;
import clases.TarjetaCredito;

public class Main {

	public static void main(String[] args) {
		// Vamos a crear el objeto cuenta Jorge vacia
		Cliente jorgeCliente = crearCliente();
		CuentaUSD cuentaDolares = new CuentaUSD();
		cuentaDolares.ingresarDinero(100);
		cuentaDolares.imprimirDatos();
		cuentaDolares.retirarDinero(50);
		jorgeCliente.imprimirDatos();
		// Vamos a mostrar los datos de la cuenta del jorge
		// jorgeCliente.imprimirDatos();

		// Vamos a practicar el Polimorfismo
//		FormaPago pagos; //Esta es la interfaz
//		pagos = new TarjetaCredito();
//		pagos.procesarPago();
//		
//		pagos = new PayPal();
//		pagos.procesarPago();
//		
//		pagos = new Efectivo();
//		pagos.procesarPago();

	}

	/**
	 * Metodo para crear cuenta
	 * 
	 * @return un cliente con los datos completos
	 */
	public static Cliente crearCliente() {
		Cliente nuevoCliente = new Cliente();
		System.out.println("-- Paso 1 --");
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingresa el numero de cliente: ");
		nuevoCliente.setId(lector.nextLong());
		lector.nextLine();
		System.out.println("Ingresa el nombre del titular: ");
		// opcion 1 usando variables
		String nombreCliente = lector.nextLine();
		nuevoCliente.setNombre(nombreCliente);
		// Al nuevo cliente le creare la cuenta
		CuentaBancaria nuevaCuenta = crearCuenta(nombreCliente);
		nuevoCliente.setCuenta(nuevaCuenta);

		/*
		 * Opcion 2 usando metodos nuevoCliente.setNombre(lector.nextLine());
		 * nuevoCliente.setCuenta(crearCuenta(nuevoCliente.getNombre()));
		 */
		return nuevoCliente;
	}

	/**
	 * Metoso para crear cuenta
	 * 
	 * @param nombre que el usario ingreso al momento de crear al cliente
	 * @return la cuenta con los datos completos
	 */
	public static CuentaBancaria crearCuenta(String nombre) {
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		System.out.println("-- Paso 2 --");
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingresa el numero de cuenta: ");
		cuentaBancaria.setNumeroCuenta(lector.nextInt());
		lector.nextLine();
		cuentaBancaria.setTitular(nombre);
		System.out.println("Ingresa el saldo Inicial: ");
		cuentaBancaria.setSaldoCuenta(lector.nextDouble());
		return cuentaBancaria;
	}

}
