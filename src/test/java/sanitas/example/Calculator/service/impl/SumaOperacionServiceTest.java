package sanitas.example.Calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * Test unitario para la operacion de suma.
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
public class SumaOperacionServiceTest {
	
	@Autowired
	SumaOperacionService servicioOperacionSuma;
	
	@Test
	public void performOperationTest() {
		assertEquals("3.11", servicioOperacionSuma.performOperation("1.11", "2.00"));
	}
}
