package sanitas.example.Calculator.service.impl;

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
public class MapaDinamicoOperacionesService {
	
	private final Map<String, OperacionBaseService> servicesByCountryCode;

	@Autowired
    public MapaDinamicoOperacionesService(List<OperacionBaseService> serviciosOperaciones) {
		servicesByCountryCode = serviciosOperaciones.stream()
                .collect(Collectors.toMap(OperacionBaseService::getOperacion, Function.identity()));
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
	public String ejecutar(String operando1, String operando2, String operacion) throws TypeMismatchException, MissingServletRequestParameterException {
		OperacionBaseService operacionService = servicesByCountryCode.get(operacion);
		return operacionService.ejecutar(operando1, operando2);
	}
}
