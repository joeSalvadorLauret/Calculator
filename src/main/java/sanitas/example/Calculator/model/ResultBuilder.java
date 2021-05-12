package sanitas.example.Calculator.model;

/**
 * Objeto que construye la respuesta de la API con el resultado.
 * Devuelve siempre un objeto de Tipo ApiResult que representa los resultados devueltos por la API.
 */
public class ResultBuilder {

	   private ResultBuilder() {
		   super();
	   }

	   public static ApiResult getResult(String result) {
	      return ApiResult.withResult(result);
	   }

	   public static ApiResult getResultFromError(String errorMessage) {
	      return ApiResult.withError(errorMessage);
	   }
	}