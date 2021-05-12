package sanitas.example.Calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import sanitas.example.Calculator.util.APIConstants;

@Service
public class RestaOperacionService extends OperacionBaseService {
	
	private static String OPNAME = "restar";
	
	public RestaOperacionService() {
		super(OPNAME);
	}

	public RestaOperacionService(String operacion) {
		super(operacion);
	}

	@Override
	public String performOperation(String operando1, String operando2) {
		BigDecimal op1, op2;
		op1 = BigDecimal.valueOf(Double.parseDouble(operando1));
		op2 = BigDecimal.valueOf(Double.parseDouble(operando2));
		return op1.subtract(op2).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING).toString();
	}
	
	

}
