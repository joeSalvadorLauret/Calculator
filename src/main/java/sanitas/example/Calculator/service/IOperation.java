package sanitas.example.Calculator.service;

import java.math.BigDecimal;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 * Interfaz a implementar por cada Servicio que realiza cada operacion
 *
 */
public interface IOperation {
	/**
	 * Operacion concreta a realizar
	 * @param operando1
	 * @param operando2
	 * @return
	 */
	public BigDecimal execute(BigDecimal operando1, BigDecimal operando2) throws TypeMismatchException, MissingServletRequestParameterException ;
}