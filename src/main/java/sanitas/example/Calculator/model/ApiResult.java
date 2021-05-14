package sanitas.example.Calculator.model;

import java.math.BigDecimal;

import io.corp.calculator.TracerImpl;
import sanitas.example.Calculator.util.APIConstants;
import sanitas.example.Calculator.util.JSONUtils;

/**
 * Representa el resultado devuelto por la API Rest Implementada. Contiene el
 * resultado de la operacion solicitada, el status code para conocer el
 * resultado de la operación y el mensaje de error en caso de producirse el
 * mismo.
 *
 */
public class ApiResult {

	private int status;
	private BigDecimal result;
	private String error;

	private ApiResult() {
	}

	public static ApiResult withResult(BigDecimal resultMessage) {
		ApiResult apiResult = new ApiResult();
		apiResult.status = APIConstants.STATUS_HTTP_200;
		apiResult.result = resultMessage;
		traceResult(apiResult);
		return apiResult;
	}

	public static ApiResult withError(String errorMessage) {
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
		tracer.trace(JSONUtils.toPrettyJSONString(apiResult));
	}
	
	/**
	 * Imprime el resultado a través de la api de TRACER
	 * @param apiResult
	 */
	public static void traceError(ApiResult apiResult) {
		TracerImpl tracer = new TracerImpl();
		tracer.trace(JSONUtils.toPrettyJSONString(apiResult));
	}
	
	@Override
	public boolean equals(Object o) {
		return ( ((ApiResult)o).getResult().equals(this.result) 
				&& (((ApiResult)o).getStatus() == this.status));
	}

	public BigDecimal getResult() {
		return result;
	}

	public String getError() {
		return error;
	}

	public int getStatus() {
		return status;
	}
	
}