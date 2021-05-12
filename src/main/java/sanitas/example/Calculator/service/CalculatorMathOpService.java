package sanitas.example.Calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import sanitas.example.Calculator.util.APIConstants;

/**
 * Servicio para gestionar las operaciones matemáticas invocadas por los controladores.
 */
@Service
public class CalculatorMathOpService {
	
	
	public CalculatorMathOpService() {
		super();
	}

	public BigDecimal sumar(BigDecimal operando1, BigDecimal operando2) {
		return operando1.add(operando2).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING);
	}
	
	public BigDecimal restar(BigDecimal operando1, BigDecimal operando2) {
		return operando1.subtract(operando2).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING);
	}
	
	public BigDecimal potencia(BigDecimal operando1, BigDecimal operando2) {
		return operando1.pow(operando2.intValue()).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING);
	}
	
}
