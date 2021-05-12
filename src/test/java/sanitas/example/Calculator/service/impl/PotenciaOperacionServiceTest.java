package sanitas.example.Calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * Test unitario para la operacion de potencia.
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
public class PotenciaOperacionServiceTest {
	
	@Autowired
	PotenciaOperacionService servicioOperacionPotencia;
	
	@Test
	public void performOperationTest() {
		assertEquals("8.00", servicioOperacionPotencia.performOperation("2.00", "3.00"));
	}
}
