package sanitas.example.Calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

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
public class PotenciaOperationServiceTest {
	
	@Autowired
	PotenciaOperationService servicioOperacionPotencia;
	
	@Test
	public void performOperationTest() {
		assertEquals(new BigDecimal("8.00"), servicioOperacionPotencia.performOperation(new BigDecimal("2.00"), new BigDecimal("3.00")));
	}
}
