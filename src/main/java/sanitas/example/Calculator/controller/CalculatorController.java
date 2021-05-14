package sanitas.example.Calculator.controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sanitas.example.Calculator.model.ApiResult;
import sanitas.example.Calculator.model.CalculatorRequest;
import sanitas.example.Calculator.model.ResultBuilder;
import sanitas.example.Calculator.service.impl.DynamicMapOperationsService;
import sanitas.example.Calculator.util.APIConstants;

/**
 * Controlador REST para la calculadora a implementar. Lleva la lógica de sumar
 * y restar
 *
 */

@ApiResponses(value= {
@ApiResponse(code = 200, message = "Operacion realizada correctamente", response = ApiResult.class ),
@ApiResponse(code = 500, message = "Operacion realizada con errores", response = ApiResult.class )
})
@RestController
@RequestMapping(APIConstants.OPERAR_URI)
@ComponentScan(APIConstants.APP_BASE_PACKAGE)
@ResponseBody
public class CalculatorController {

	@Autowired
	DynamicMapOperationsService operationsService;

	public CalculatorController(DynamicMapOperationsService operationsService) {
		this.operationsService = operationsService;
	}

	@ApiOperation(value = "Operacion a realizar con la calculadora"
			,notes = "Metodo a invocar para las operaciones a realizar. Acepta JSON")
	@PostMapping(APIConstants.ROOT_URI)
	public ApiResult calculate(@RequestBody CalculatorRequest request) throws TypeMismatchException, MissingServletRequestParameterException {
		return ResultBuilder.getResult(operationsService.execute(request.getOperando1(), request.getOperando2(), request.getOperacion()));
	}

}
