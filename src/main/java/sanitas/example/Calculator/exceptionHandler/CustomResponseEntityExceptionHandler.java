package sanitas.example.Calculator.exceptionHandler;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sanitas.example.Calculator.model.ResultBuilder;
import sanitas.example.Calculator.util.APIConstants;

/**
 * Clase para realizar el manejo de excepciones a lo largo de toda la
 * aplicación. Esto es posible con la anotacion @ControllerAdvice
 * 
 * @author Jose Luis Salvador Lauret
 *
 */
@ControllerAdvice
public class CustomResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler {
	
	/**
	 * Se encarga del manejo de excepciones para tipos no válidos en los parámetros de entrada.
	 */
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, ResultBuilder.getResultFromError(APIConstants.NUMERIC_PARAMS_ERROR_MSG), headers, status, request);
	}
	
	/**
	 * Se encarga del manejo de excepciones al faltar algún parámetro en la petición.
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, ResultBuilder.getResultFromError(APIConstants.EMPTY_PARAMS_ERROR_MSG), headers, status, request);
	}
}
