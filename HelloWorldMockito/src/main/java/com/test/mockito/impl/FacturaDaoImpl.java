package com.test.mockito.impl;

import com.test.mockito.FacturaDao;

public class FacturaDaoImpl implements FacturaDao {
	private String[] items ;
	
	
	public FacturaDaoImpl(){
		items = new String[]{ "Linea 1", "Linea 2", "Linea 3" };
	}

	@Override
	public String[] obtenerLineasFactura() {
		return items;
	}

	
	@Override
	public void actualizarItem(String nuevoItem, Integer posicion) {
		
	}

	

}
