package com.test.mockito.impl;

import java.util.Arrays;
import java.util.List;

import com.test.mockito.FacturaController;
import com.test.mockito.FacturaDao;

public class FacturaControllerImpl implements FacturaController {
	String EMPTY_STRING = "";
	
	
	private FacturaDao facturaDao;

	public FacturaControllerImpl() {
	}

	public FacturaControllerImpl(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}

	public FacturaDao getFacturaDao() {
		return facturaDao;
	}

	public void setFacturaDao(FacturaDao facturaDao) {
		this.facturaDao = facturaDao;
	}

	@Override
	public List<String> obtenerLineasFactura() {
		return Arrays.asList(facturaDao.obtenerLineasFactura());
	}

	@Override
	public void actualizarItem(String item, Integer posicion) {
		facturaDao.actualizarItem(item, posicion);
	}

	 
}
