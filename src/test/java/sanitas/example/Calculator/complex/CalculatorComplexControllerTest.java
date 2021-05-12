package sanitas.example.Calculator.complex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import sanitas.example.Calculator.minimal.util.JSONUtils;
import sanitas.example.Calculator.model.ApiResult;
import sanitas.example.Calculator.model.CalculatorRequest;
import sanitas.example.Calculator.util.APIConstants;

/**
 * 
 * Tests de integracion para el controlador de las operaciones complejas de la calculadora.
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = { CalculatorComplexController.class })
@WebMvcTest
public class CalculatorComplexControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void potenciaTest() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post(APIConstants.COMPLEJO_URI+APIConstants.POTENCIA_URI)
					.content(JSONUtils.toPrettyJSONString(new CalculatorRequest(new BigDecimal(1.2), new BigDecimal(2))))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
		ApiResult apiResult = (ApiResult)JSONUtils.jsonToObject(result.getResponse().getContentAsString());
		assertNotNull(apiResult);
		assertEquals(apiResult.getResult(), new BigDecimal(1.44).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING).toString());
	}
}
