package sanitas.example.Calculator.minimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

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

/**
 * Clase para realizar Tests de Integracion sobre las operaciones que acepta el
 * controlador de la calculadora básica.
 * 
 * @author Jose Luis Salvador Lauret
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
				.perform(MockMvcRequestBuilders.post("/basico/sumar")
					.content(JSONUtils.asJsonString(new CalculatorRequest(new BigDecimal(1), new BigDecimal(2))))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
		ApiResult apiResult = JSONUtils.jsonToObject(result.getResponse().getContentAsString());
		assertNotNull(apiResult);
		assertEquals(apiResult.getResult(), new BigDecimal(3).toString());
	}
	
	@Test
	public void restarTest() throws Exception {

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/basico/restar")
					.content(JSONUtils.asJsonString(new CalculatorRequest(new BigDecimal(2), new BigDecimal(1))))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andReturn();
		ApiResult apiResult = JSONUtils.jsonToObject(result.getResponse().getContentAsString());
		assertNotNull(apiResult);
		assertEquals(apiResult.getResult(), new BigDecimal(1).toString());
	}
}
