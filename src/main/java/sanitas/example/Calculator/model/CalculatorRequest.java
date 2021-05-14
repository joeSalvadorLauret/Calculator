package sanitas.example.Calculator.model;

import java.math.BigDecimal;

/**
 * 
 * Clase para representar las peticiones a la calculadora.
 */
public class CalculatorRequest {

	private BigDecimal operando1;
	private BigDecimal operando2;
	private String operacion;

	public CalculatorRequest() {
	}

	public CalculatorRequest(BigDecimal operando1, BigDecimal operando2, String operacion) {
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.operacion = operacion;
	}

	public BigDecimal getOperando1() {
		return operando1;
	}

	public void setOperando1(BigDecimal operando1) {
		this.operando1 = operando1;
	}

	public BigDecimal getOperando2() {
		return operando2;
	}

	public void setOperando2(BigDecimal operando2) {
		this.operando2 = operando2;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}
