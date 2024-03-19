package clases;

public interface Moneda {
	/**
	 * Interfaz que devuelve el simbolo de la conversion
	 * @return el simbolo
	 */
	public String getSimbolo();
	
	/**
	 * Interfaz para obtener el factor de conversion
	 * @return el factor en float
	 */
	public float getFactorConversion();
	
	/**
	 * Para convertir monedas
	 */
	public void convertir();
}
