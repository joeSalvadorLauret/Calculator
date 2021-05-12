package sanitas.example.Calculator.model;

import java.math.BigDecimal;

/**
 * Objeto que construye la respuesta de la API con el resultado.
 * Devuelve siempre un objeto de Tipo ApiResult que representa los resultados devueltos por la API.
 */
public class ResultBuilder {

	   private ResultBuilder() {
		   super();
	   }

	   public static ApiResult getResult( Object result ) {
	      return ApiResult.withResult(result.toString());
	   }

	   public static ApiResult getResult( BigDecimal result ) {
	      return ApiResult.withResult(result.toPlainString());
	   }

	   public static ApiResult getResultFromError(String errorMessage) {
	      return ApiResult.withError(errorMessage);
	   }
	}