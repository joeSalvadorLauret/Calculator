package sanitas.example.Calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

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
public class RestaOperationServiceTest {
	
	@Autowired
	RestaOperationService servicioOperacionResta;
	
	@Test
	public void performOperationTest() {
		assertEquals(new BigDecimal("1.00"), servicioOperacionResta.performOperation(new BigDecimal("3.00"), new BigDecimal("2.00")));
	}
}
