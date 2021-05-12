package sanitas.example.Calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * Test unitario para la operacion de resta.
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
public class RestaOperacionServiceTest {
	
	@Autowired
	RestaOperacionService servicioOperacionResta;
	
	@Test
	public void performOperationTest() {
		assertEquals("1.00", servicioOperacionResta.performOperation("3.00", "2.00"));
	}
}
