package sanitas.example.Calculator.complex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sanitas.example.Calculator.model.ApiResult;
import sanitas.example.Calculator.model.CalculatorRequest;
import sanitas.example.Calculator.model.ResultBuilder;
import sanitas.example.Calculator.service.CalculatorMathOpService;
import sanitas.example.Calculator.util.APIConstants;

/**
 * Controlador REST para la calculadora a implementar. Lleva la lógica de sumar
 * y restar
 * 
 * @author Jose Luis Salvador Lauret
 *
 */
@RestController
@RequestMapping(APIConstants.COMPLEJO_URI)
@ComponentScan(APIConstants.APP_BASE_PACKAGE)
@ResponseBody
public class CalculatorComplexController {
	
	@Autowired
	CalculatorMathOpService operationsService;
	
	@PostMapping(APIConstants.POTENCIA_URI)
	public ApiResult potencia(@RequestBody CalculatorRequest request) {
		return ResultBuilder.getResult(operationsService.potencia(request.getOperando1(), request.getOperando2()));
	}
	
}
