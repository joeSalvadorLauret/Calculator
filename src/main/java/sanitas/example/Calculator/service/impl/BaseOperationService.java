package sanitas.example.Calculator.service.impl;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.springframework.beans.TypeMismatchException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import sanitas.example.Calculator.service.IOperation;
import sanitas.example.Calculator.util.APIConstants;

/**
 * Clase Base para los servicios que implementan la interfaz de Operacion.
 *
 */
public abstract class BaseOperationService implements IOperation {
	
	protected String operation;
	
	public BaseOperationService(String operation) {
		this.operation = operation;
	}
	
	/**
	 * realiza la operacion de la interfaz y deja la implementacion de la propia operacion a las clases que la implementan.
	 */
	public BigDecimal execute(BigDecimal operando1, BigDecimal operando2) throws TypeMismatchException, MissingServletRequestParameterException {
		BigDecimal resultado;
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
	public abstract BigDecimal performOperation(BigDecimal operando1, BigDecimal operando2);
	
	/**
	 * Valida los parametros recibidos para la operacion
	 * @param operando1
	 * @param operando2
	 * @throws TypeMismatchException
	 * @throws MissingServletRequestParameterException
	 */
	public void validateParams(BigDecimal operando1, BigDecimal operando2) throws TypeMismatchException, MissingServletRequestParameterException{
		// Validacion de existencia de parametros
		if (operando1 == null) {
			throw new MissingServletRequestParameterException(APIConstants.OPERANDO1_NAME, APIConstants.OPERANDO_TYPE);
		}else if (operando2 == null) {
			throw new MissingServletRequestParameterException(APIConstants.OPERANDO2_NAME, APIConstants.OPERANDO_TYPE);
		} else {
			// Validacion de tipos adecuados
			Pattern pattern = Pattern.compile(APIConstants.NUMERIC_REGEX);
			if(!pattern.matcher(operando1.toString()).matches()) {
				throw new TypeMismatchException(operando1, BigDecimal.class);
			}else if (!pattern.matcher(operando2.toString()).matches()) {
				throw new TypeMismatchException(operando2, BigDecimal.class);
			}
		}
	}
	
	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	
}
