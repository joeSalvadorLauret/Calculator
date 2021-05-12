package sanitas.example.Calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import sanitas.example.Calculator.util.APIConstants;

/**
 *	Componente encargado de la operacion de suma
 *
 */
@Service
public class SumaOperacionService extends OperacionBaseService {
	
	private static String OPNAME = "sumar";
	
	public SumaOperacionService() {
		super(OPNAME);
	}

	@Override
	public String performOperation(String operando1, String operando2) {
		BigDecimal op1, op2;
		op1 = BigDecimal.valueOf(Double.parseDouble(operando1));
		op2 = BigDecimal.valueOf(Double.parseDouble(operando2));
		return op1.add(op2).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING).toString();
	}
	
	

}
