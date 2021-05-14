package sanitas.example.Calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import sanitas.example.Calculator.util.APIConstants;

@Service
public class RestaOperationService extends BaseOperationService {
	
	private static String OPNAME = "restar";
	
	public RestaOperationService() {
		super(OPNAME);
	}

	public RestaOperationService(String operacion) {
		super(operacion);
	}

	@Override
	public BigDecimal performOperation(BigDecimal operando1, BigDecimal operando2) {
		return operando1.subtract(operando2).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING);
	}
	
	

}
