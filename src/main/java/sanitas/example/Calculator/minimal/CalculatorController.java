package sanitas.example.Calculator.minimal;

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
 */
@RestController
@RequestMapping(APIConstants.BASICO_URI)
@ComponentScan(APIConstants.APP_BASE_PACKAGE)
@ResponseBody
public class CalculatorController {

	@Autowired
	CalculatorMathOpService operationsService;

	public CalculatorController(CalculatorMathOpService operationsService) {
		super();
		this.operationsService = operationsService;
	}

	@PostMapping(APIConstants.SUMAR_URI)
	public ApiResult sumar(@RequestBody CalculatorRequest request) {
		return ResultBuilder.getResult(operationsService.sumar(request.getOperando1(), request.getOperando2()));
	}

	@PostMapping(APIConstants.RESTAR_URI)
	public ApiResult restar(@RequestBody CalculatorRequest request) {
		return ResultBuilder.getResult(operationsService.restar(request.getOperando1(), request.getOperando2()));
	}
	
	/*
	 * AQUI SE GENERARIAN EL RESTO DE OPERACIONES COMO P. EJ MULTIPLICACION Y
	 * DIVISION
	 */

}
