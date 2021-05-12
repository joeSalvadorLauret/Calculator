package sanitas.example.Calculator.minimal;

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
 * Clase para realizar Tests de Integracion sobre las operaciones que acepta el
 * controlador de la calculadora básica.
 *
 */

@AutoConfigureMockMvc
@ContextConfiguration(classes = { CalculatorController.class })
@WebMvcTest
public class CalculatorControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void sumarTest() throws Exception {

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post(APIConstants.BASICO_URI+APIConstants.SUMAR_URI)
					.content(JSONUtils.toPrettyJSONString(new CalculatorRequest(new BigDecimal(1.2), new BigDecimal(2.3))))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
		ApiResult apiResult = (ApiResult)JSONUtils.jsonToObject(result.getResponse().getContentAsString());
		assertNotNull(apiResult);
		assertEquals(apiResult.getResult(), new BigDecimal(3.5).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING).toString());
	}
	
	@Test
	public void restarTest() throws Exception {

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post(APIConstants.BASICO_URI+APIConstants.RESTAR_URI)
					.content(JSONUtils.toPrettyJSONString(new CalculatorRequest(new BigDecimal(2.11), new BigDecimal(1.11))))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
		ApiResult apiResult = (ApiResult)JSONUtils.jsonToObject(result.getResponse().getContentAsString());
		assertNotNull(apiResult);
		assertEquals(apiResult.getResult(), new BigDecimal(1).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING).toString());
	}
	
}
