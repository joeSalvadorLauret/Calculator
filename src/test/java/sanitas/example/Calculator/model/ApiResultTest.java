package sanitas.example.Calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import sanitas.example.Calculator.util.APIConstants;

/**
 * Test unitario de la clase que representa el resultado devuelto por la API.
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
public class ApiResultTest {
	
	private static final BigDecimal value = new BigDecimal("1.0");
	private static final String message = "message";
	
	@Test
	public void withResultTest() {
		ApiResult resultado = ApiResult.withResult(value);
		assertEquals(resultado.getResult(), value);
		assertEquals(resultado.getStatus(), APIConstants.STATUS_HTTP_200);
	}
	
	@Test
	public void withErrorTest() {
		ApiResult resultado = ApiResult.withError(message);
		assertEquals(resultado.getError(), message);
		assertEquals(resultado.getStatus(), APIConstants.STATUS_HTTP_500);
	}
	
	
}
