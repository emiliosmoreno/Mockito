package com.tests.mockito;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.test.mockito.FacturaDao;
import com.test.mockito.impl.FacturaControllerImpl;

@RunWith(MockitoJUnitRunner.class)
public class FacturaControllerTest {

	@Mock
	private FacturaDao itemFacturaDao;
	
	@InjectMocks
	private FacturaControllerImpl itemController;

	
//	@Before
//	public void initMocks(){
//		itemController.setFacturaDao(itemFacturaDao);
//	}
	
	@Test
	public void comprobarObtencionLineasFactura() {

		// ARRANGE
		List<String> resultado = null;
		Mockito.when(itemFacturaDao.obtenerLineasFactura()).thenReturn(

		new String[] { "Item 1", "Item 2" });

		// ACT
		try {
			resultado = itemController.obtenerLineasFactura();
		} catch (Exception e) {
			fail("Se ha lanzado una excepción no esperada");
		}

		// ASSERT
		Mockito.verify(itemFacturaDao).obtenerLineasFactura();
		assertThat(resultado, contains("Item 1", "Item 2"));
	}
	
	@Test
	public void comprobarObtencionLineasFacturaUsandoAnswer() {

		// ARRANGE
		Answer<String[]> MyAnswer = new Answer<String[]>() {

			@Override
			public String[] answer(InvocationOnMock invocation)
					throws Throwable {

				String resultado[] = new String[] { "Item 1", "Item 2" };

				return resultado;
			}

		};
		List<String> resultado = null;
		Mockito.when(itemFacturaDao.obtenerLineasFactura()).then(MyAnswer);

		// ACT
		try {
			resultado = itemController.obtenerLineasFactura();
		} catch (Exception e) {
			fail("Se ha lanzado una excepción no esperada");
		}

		// ASSERT
		Mockito.verify(itemFacturaDao).obtenerLineasFactura();
		assertThat(resultado, contains("Item 1", "Item 2"));

	}
	

	@Test
	public void comprobarControlExcepcionesViaProgramatica() {

		// ARRANGE
		List<String> resultado = null;
		Mockito.when(itemFacturaDao.obtenerLineasFactura()).thenThrow(
				new NullPointerException());
		// ACT
		try {
			resultado = itemController.obtenerLineasFactura();
		} catch (NullPointerException e) {
			// ASSERT
			Mockito.verify(itemFacturaDao).obtenerLineasFactura();
		} catch (Exception e) {
			fail("Se ha lanzado una excepción no esperada");
		}

	}
	
	@Test
	public void comprobarParametrosLlamada() {
		
		// ARRANGE
		Answer<String[]> MyAnswer = new Answer<String[]>() {

			@Override
			public String[] answer(InvocationOnMock invocation)
					throws Throwable {

				String param=invocation.getArgumentAt(0,String.class);
				
				String resultado[]=null;
				 if (param.equalsIgnoreCase("Item 1"))
					 resultado=new String[]{"Linea 1"};
				 else
					 resultado=new String[]{"Linea 1", "Linea 2"};
				 
				 return resultado;
			}

		};
		List<String> resultado = null;
		String item="Item 1";
		int posicion=0;
//		Mockito.when(itemFacturaDao.actualizarItem(item,posicion));  //Esto no se puede hacer
		
		//TODO: pendiente de terminar
		/*
		Mockito.doAnswer(MyAnswer).when(itemFacturaDao).actualizarItem(item, posicion);

		// ACT
		try {
			resultado = itemController.obtenerLineasFactura();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Se ha lanzado una excepción no esperada");
		}

		// ASSERT
		Mockito.verify(itemFacturaDao).obtenerLineasFactura();
		assertThat(resultado, contains("Item 1", "Item 2"));
		
		*/
	}

}
