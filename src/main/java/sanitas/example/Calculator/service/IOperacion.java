package sanitas.example.Calculator.service;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 * Interfaz a implementar por cada Servicio que realiza cada operacion
 *
 */
public interface IOperacion {
	/**
	 * Operacion concreta a realizar
	 * @param operando1
	 * @param operando2
	 * @return
	 */
	public String ejecutar(String operando1, String operando2) throws TypeMismatchException, MissingServletRequestParameterException ;
}