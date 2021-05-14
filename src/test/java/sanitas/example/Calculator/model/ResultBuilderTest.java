package sanitas.example.Calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/**
 * Test unitario para la clase que construye los resultados.
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
public class ResultBuilderTest {
	
	private static final BigDecimal value = new BigDecimal("1.0");
	private static final String message = "message";
	
	@Test
	public void getResultTest() {
		ApiResult resultado = ResultBuilder.getResult(value);
		assertEquals(resultado.getResult(), value);
	}
	
	@Test
	public void getResultFromError() {
		ApiResult resultado = ResultBuilder.getResultFromError(message);
		assertEquals(resultado.getError(), message);
	}
}
