package sanitas.example.Calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import sanitas.example.Calculator.util.APIConstants;

@Service
public class PotenciaOperationService extends BaseOperationService {
	
	private static String OPNAME = "potencia";
	
	public PotenciaOperationService() {
		super(OPNAME);
	}

	@Override
	public BigDecimal performOperation(BigDecimal operando1, BigDecimal operando2) {
		return operando1.pow(operando2.intValue()).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING);
	}
	
}
