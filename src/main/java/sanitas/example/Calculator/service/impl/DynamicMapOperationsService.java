package sanitas.example.Calculator.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;

/**
 * Clase que ejecuta dinamicamente las operaciones.
 *
 */
@Service
public class DynamicMapOperationsService {
	
	private final Map<String, BaseOperationService> servicesByOpCode;

	@Autowired
    public DynamicMapOperationsService(List<BaseOperationService> serviciosOperaciones) {
		servicesByOpCode = serviciosOperaciones.stream()
                .collect(Collectors.toMap(BaseOperationService::getOperation, Function.identity()));
    }
	
	/**
	 * Carga dinamicamente la operacion a ejecutar en base al servicio que la implementa.
	 * @param operando1
	 * @param operando2
	 * @param operacion
	 * @return
	 * @throws TypeMismatchException
	 * @throws MissingServletRequestParameterException
	 */
	public BigDecimal execute(BigDecimal operando1, BigDecimal operando2, String operacion) throws TypeMismatchException, MissingServletRequestParameterException {
		BaseOperationService operacionService = servicesByOpCode.get(operacion);
		return operacionService.execute(operando1, operando2);
	}
}
