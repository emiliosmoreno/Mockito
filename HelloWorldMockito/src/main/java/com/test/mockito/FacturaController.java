package com.test.mockito;

import java.util.List;

public interface FacturaController {
	
	List<String> obtenerLineasFactura();

	void actualizarItem(String item, Integer posicion);

}
