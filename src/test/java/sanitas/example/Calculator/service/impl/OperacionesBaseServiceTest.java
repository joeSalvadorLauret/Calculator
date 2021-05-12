package sanitas.example.Calculator.service.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.TypeMismatchException;
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
public class OperacionesBaseServiceTest {
	
	/**
	 * Servicio Base operaciones. Se usa una de sus implementaciones para hacer la validacion
	 */
	@Autowired
	SumaOperacionService servicioBaseOperaciones;
	
	@Test
	public void validateParamsTestOK() {
		assertDoesNotThrow(() -> servicioBaseOperaciones.validateParams("1.0", "1.0"));
	}
	
	@Test
	public void validateParamsMismatchExceptionTest() {
		assertThrows(TypeMismatchException.class, () -> servicioBaseOperaciones.validateParams("1", "a"));
		assertThrows(TypeMismatchException.class, () -> servicioBaseOperaciones.validateParams("a", "1"));
	}
	
	@Test
	public void validateParamsMissingServletRequestParameterExceptionTest() {
		assertThrows(MissingServletRequestParameterException.class, () -> servicioBaseOperaciones.validateParams("1", ""));
		assertThrows(MissingServletRequestParameterException.class, () -> servicioBaseOperaciones.validateParams("", "1"));
	}

	
}
