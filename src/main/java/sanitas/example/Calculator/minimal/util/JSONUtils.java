package sanitas.example.Calculator.minimal.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import sanitas.example.Calculator.model.ApiResult;

/**
 * Clase de utilidades JSON
 * @author Jose Luis Salvador Lauret
 *
 */
public class JSONUtils {
	
	public static String toPrettyJSONString(final Object obj) {
	    try {
	        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static ApiResult jsonToObject(String json) {
		try {
			return new ObjectMapper().readValue(json, ApiResult.class);
		} catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
