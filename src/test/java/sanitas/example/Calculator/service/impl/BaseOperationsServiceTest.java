package sanitas.example.Calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 * Test unitario para la funcionalidad de validacion de parametros contenida en la clase de servicio Base
 *
 */
@AutoConfigureMockMvc
@WebMvcTest
public class BaseOperationsServiceTest {
	
	/**
	 * Servicio Base operaciones. Se usa una de sus implementaciones para hacer la validacion
	 */
	@Autowired
	SumaOperationService servicioBaseOperaciones;
	
	@Test
	public void validateParamsTestOK() {
		assertDoesNotThrow(() -> servicioBaseOperaciones.validateParams(new BigDecimal("1.0"), new BigDecimal("1.0")));
	}
	
	@Test
	public void validateParamsMismatchExceptionTest() {
		assertThrows(Exception.class, () -> servicioBaseOperaciones.validateParams(new BigDecimal("1"), new BigDecimal("a")));
		assertThrows(Exception.class, () -> servicioBaseOperaciones.validateParams(new BigDecimal("a"), new BigDecimal("1")));
	}
	
	@Test
	public void validateParamsMissingServletRequestParameterExceptionTest() {
		assertThrows(MissingServletRequestParameterException.class, () -> servicioBaseOperaciones.validateParams(new BigDecimal("1"), null));
		assertThrows(MissingServletRequestParameterException.class, () -> servicioBaseOperaciones.validateParams(null, new BigDecimal("1")));
	}

	
}
