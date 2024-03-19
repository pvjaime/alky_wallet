package clases;

public class PayPal implements FormaPago {

	@Override
	public void procesarPago() {
		System.out.println("Entrega tus dolares a Paypal");
	}

}
