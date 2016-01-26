package com.tests.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.test.mockito.FacturaDao;
import com.test.mockito.impl.FacturaControllerImpl;

@RunWith(MockitoJUnitRunner.class)
public class FacturaControllerTest {

	@Mock
	private FacturaDao itemFacturaDao;
	
	@InjectMocks
	private FacturaControllerImpl itemController;

	
	@Before
	public void initMocks(){
		itemController.setFacturaDao(itemFacturaDao);
	}
	
	@Test
	public void comprobarObtencionLineasFactura() {
	}
	
	@Test
	public void comprobarActualizacionLineasFactura() {
	}
	

}
