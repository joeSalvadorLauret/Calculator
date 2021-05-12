package sanitas.example.Calculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import sanitas.example.Calculator.model.ApiResult;

@AutoConfigureMockMvc
@WebMvcTest
public class JSONUtilsTest {
	
	private static final String value = "1.00";
	private static final ApiResult resultadoOK = ApiResult.withResult(value);
	private static String json = "{\r\n" + 
			"  \"status\" : 200,\r\n" + 
			"  \"result\" : \"1.00\",\r\n" + 
			"  \"error\" : null\r\n" + 
			"}";
	
	@Test
	public void toPrettyJSONStringTest() {
		assertEquals(JSONUtils.toPrettyJSONString(resultadoOK),json);
	}
	
	@Test
	public void toPrettyJSONToObjectTest() {
		assertEquals(JSONUtils.jsonToObject(json),resultadoOK);
	}
	
}
