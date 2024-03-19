package clases;

public class Efectivo implements FormaPago {

	@Override
	public void procesarPago() {
		System.out.println("Rompiendo el chanchito");
	}
}
