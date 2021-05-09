package sanitas.example.Calculator.model;

import io.corp.calculator.TracerImpl;
import sanitas.example.Calculator.util.APIConstants;

/**
 * Representa el resultado devuelto por la API Rest Implementada. Contiene el
 * resultado de la operacion solicitada, el status code para conocer el
 * resultado de la operación y el mensaje de error en caso de producirse el
 * mismo.
 * 
 * @author Jose Luis Salvador Lauret
 *
 */
public class ApiResult {

	private int status;
	private String result;
	private String error;

	private ApiResult() {
	}

	static ApiResult withResult(String resultMessage) {
		ApiResult apiResult = new ApiResult();
		apiResult.status = APIConstants.STATUS_HTTP_200;
		apiResult.result = resultMessage;
		traceResult(apiResult);
		return apiResult;
	}

	static ApiResult withError(String errorMessage) {
		ApiResult apiResult = new ApiResult();
		apiResult.status = APIConstants.STATUS_HTTP_500;
		apiResult.error = errorMessage;
		traceResult(apiResult);
		return apiResult;
	}
	
	/**
	 * Imprime el resultado a través de la api de TRACER
	 * @param apiResult
	 */
	public static void traceResult(ApiResult apiResult) {
		TracerImpl tracer = new TracerImpl();
		tracer.trace(apiResult);
	}

	public String getResult() {
		return result;
	}

	public String getError() {
		return error;
	}

	public int getStatus() {
		return status;
	}
	
}