package sanitas.example.Calculator.model;

/**
 * 
 * Clase para representar las peticiones a la calculadora.
 */
public class CalculatorRequest {

	private String operando1;
	private String operando2;
	private String operacion;

	public CalculatorRequest() {
		super();
	}

	public CalculatorRequest(String operando1, String operando2, String operacion) {
		super();
		this.operando1 = operando1;
		this.operando2 = operando2;
		this.operacion = operacion;
	}

	public String getOperando1() {
		return operando1;
	}

	public void setOperando1(String operando1) {
		this.operando1 = operando1;
	}

	public String getOperando2() {
		return operando2;
	}

	public void setOperando2(String operando2) {
		this.operando2 = operando2;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}
