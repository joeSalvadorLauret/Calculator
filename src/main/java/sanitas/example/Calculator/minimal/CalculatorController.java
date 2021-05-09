package sanitas.example.Calculator.minimal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sanitas.example.Calculator.model.ApiResult;
import sanitas.example.Calculator.model.CalculatorRequest;
import sanitas.example.Calculator.model.ResultBuilder;

/**
 * Controlador REST para la calculadora a implementar. Lleva la lógica de sumar y restar
 * @author Jose Luis Salvador Lauret
 *
 */
@RestController
@RequestMapping("/basico")
@ResponseBody
public class CalculatorController {
	
	   @PostMapping("/sumar")
	   public ApiResult sumar(@RequestBody CalculatorRequest request) {
	      return ResultBuilder.getResult(request.getOperando1().add(request.getOperando2()));
	   }

	   @PostMapping("/restar")
	   public ApiResult restar(@RequestBody CalculatorRequest request) {
	      return ResultBuilder.getResult(request.getOperando1().subtract(request.getOperando2()));
	   }
	   
	   /* AQUI SE GENERARIAN EL RESTO DE OPERACIONES COMO P. EJ MULTIPLICACION Y DIVISION */
	   
	   
}
