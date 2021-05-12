package sanitas.example.Calculator.util;

/**
 * 
 * Constantes de la app para evitar uso de valores hardcodeados.
 */
public class APIConstants {
	
	/* HTTP STATUS CODES */
	public static final int STATUS_HTTP_200 = 200;
	public static final int STATUS_HTTP_500 = 500;
	
	/* ERROR MESSAGES */
	public static final String NUMERIC_PARAMS_ERROR_MSG = "Los parámetros deben ser numéricos";
	public static final String EMPTY_PARAMS_ERROR_MSG = "Debe introducir dos parámetros para realizar la operación";
	
	/* PRECISION FOR MATH OPERATIONS */
	public static final int BIG_DECIMAL_SCALE = 2;
	
	/* ENDPOINT URIs */
	public static final String OPERAR_URI = "/operar";
	public static final String ROOT_URI = "/";
	public static final String SUMAR_URI = "/sumar";
	public static final String RESTAR_URI = "/restar";
	public static final String COMPLEJO_URI = "/complejo";
	public static final String POTENCIA_URI = "/potencia";
	
	/* BASE PACKAGE */
	public static final String APP_BASE_PACKAGE = "sanitas.example.Calculator";
	
	/* OPERAND NAMES && TYPES */
	public static final String OPERANDO1_NAME = "operando1";
	public static final String OPERANDO2_NAME = "operando2";
	public static final String OPERANDO_TYPE = "Numeric";
	public static final String NUMERIC_REGEX = "-?\\d+(\\.\\d+)?";
}
