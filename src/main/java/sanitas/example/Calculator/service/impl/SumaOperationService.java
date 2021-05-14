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
public class SumaOperationService extends BaseOperationService {
	
	private static String OPNAME = "sumar";
	
	public SumaOperationService() {
		super(OPNAME);
	}

	@Override
	public BigDecimal performOperation(BigDecimal operando1, BigDecimal operando2) {
		return operando1.add(operando2).setScale(APIConstants.BIG_DECIMAL_SCALE, RoundingMode.CEILING);
	}
	
	

}
