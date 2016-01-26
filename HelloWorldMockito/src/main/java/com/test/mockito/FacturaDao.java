package com.test.mockito;

public interface FacturaDao {

	String[] obtenerLineasFactura();

	void actualizarItem(String nuevoItem, Integer posicion);

}
