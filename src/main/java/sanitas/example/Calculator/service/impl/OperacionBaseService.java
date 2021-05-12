package sanitas.example.Calculator.service.impl;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import sanitas.example.Calculator.service.IOperacion;
import sanitas.example.Calculator.util.APIConstants;

/**
 * Clase Base para los servicios que implementan la interfaz de Operacion.
 *
 */
public abstract class OperacionBaseService implements IOperacion {
	
	protected String operacion;
	
	public OperacionBaseService(String operacion) {
		super();
		this.operacion = operacion;
	}
	
	/**
	 * realiza la operacion de la interfaz y deja la implementacion de la propia operacion a las clases que la implementan.
	 */
	public String ejecutar(String operando1, String operando2) throws TypeMismatchException, MissingServletRequestParameterException {
		String resultado;
		validateParams(operando1,operando2);
		resultado = performOperation(operando1, operando2);
		return resultado;
	}
	
	/**
	 * Realiza el calculo concreto para la operacion
	 * @param operando1
	 * @param operando2
	 * @return
	 */
	public abstract String performOperation(String operando1, String operando2);
	
	/**
	 * Valida los parametros recibidos para la operacion
	 * @param operando1
	 * @param operando2
	 * @throws TypeMismatchException
	 * @throws MissingServletRequestParameterException
	 */
	public void validateParams(String operando1, String operando2) throws TypeMismatchException, MissingServletRequestParameterException{
		// Validacion de existencia de parametros
		if (operando1 == null || "".equals(operando1)) {
			throw new MissingServletRequestParameterException(APIConstants.OPERANDO1_NAME, APIConstants.OPERANDO_TYPE);
		}else if (operando2 == null || "".equals(operando2)) {
			throw new MissingServletRequestParameterException(APIConstants.OPERANDO2_NAME, APIConstants.OPERANDO_TYPE);
		} else {
			// Validacion de tipos adecuados
			Pattern pattern = Pattern.compile(APIConstants.NUMERIC_REGEX);
			if(!pattern.matcher(operando1).matches()) {
				throw new TypeMismatchException(operando1, BigDecimal.class);
			}else if (!pattern.matcher(operando2).matches()) {
				throw new TypeMismatchException(operando2, BigDecimal.class);
			}
		}
	}
	
	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
}
