package sanitas.example.Calculator.model;

import java.math.BigDecimal;

/**
 * Constructor del resultado tanto para casos OK como para errores.
 * Devuelve siempre un objeto de Tipo ApiResult que representa los resultados devueltos por la API.
 * @author Jose Luis Salvador Lauret
 *
 */
public class ResultBuilder {

	   private ResultBuilder() {
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