package calcualdora;

import java.util.Scanner;

public class CerebroCalculadoraED {

	private Operaciones operacion;
	public double resultado, numero1, numero2; 
	public String[] historial;
	private final int TAMANOHISTORIAL = 5;
	Scanner tecladoCce = new Scanner(System.in);

	CerebroCalculadoraED() {
		historial = new String[TAMANOHISTORIAL];
		resultado = 0; 
	}
 

	public void procesarOperacion(String op) {
		Operaciones operacion;
		System.out.println("proceso " + op);
		switch (op) {
		case "1":
			operacion = Operaciones.SUMAR;
			operarSuma(operacion);
			break;
		case "2":
			operacion = Operaciones.RESTAR;
			operarResta(operacion);
			break;
		case "3":
			operacion = Operaciones.MULTIPLICAR;
			operarMultiplica(operacion);
			break;
		case "4":
			operacion = Operaciones.DIVIDIR;
			operarDivide(operacion);
			break;
		case "5":
			operacion = Operaciones.SUMAR_RES;
			operarSumaRes(operacion);
			break;
		case "6":
			operacion = Operaciones.RESTAR_RES;
			operarRestaRes(operacion);
			break;
		case "7":
			operacion = Operaciones.MULTIPLICAR_RES;
			operarMultiplicaRes(operacion);
			break;
		case "8":
			operacion = Operaciones.DIVIDIR_RES;
			operarDivideRes(operacion);
			break;
		case "9":
			operacion = Operaciones.RESULTADO;
			mostrarResultadoActual(operacion);
			break;
		case "10":
			operacion = Operaciones.RANDOM;
			numeroAleatorio(operacion);
			break;
		case "11":
			operacion = Operaciones.HISTORIAL;
			operarHistorial(operacion);
			break;
		default:
			System.out.println("ERROR: La operación " + op + " no es conocida.");
		}
	}

	public void operarSuma(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void operarResta(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void operarMultiplica(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void operarDivide(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void operarSumaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void operarRestaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void operarMultiplicaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void operarDivideRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado / this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}
	
	public void mostrarResultadoActual(Operaciones op) {
		infoOperacion(op);
		System.out.println("El valor actual del resultado es: " + this.resultado + "\n");
	}
	
	public void numeroAleatorio(Operaciones op) {
		infoOperacion(op);
		this.resultado = (double)(Math.random()*100+1);
		System.out.println("El número aleatorio generado es: " + this.resultado + "\n");
		anadirHistorialAleatorio(op);
	}
	
	private void operarHistorial(Operaciones op) {
		System.out.println("*** Historial de las cinco últimas operaciones ***");
		for (String hist : historial) {
			System.out.println(hist);
		}
		System.out.println("\n");
	}
	
	private void infoOperacion(Operaciones op) {
		System.out.println("//////////////////////////////");
		System.out.println("-> " + op.getNombre() + " - " + op.getInfo());
	}
	
	public void pedirUnNumero() {
		System.out.println("Introduce el número: ");
		this.numero1 = this.resultado;
		this.numero2 = tecladoCce.nextDouble();
	}
	
	private void pedirDosNumeros() {
		System.out.println("Introduce el primer número: ");
		this.numero1 = tecladoCce.nextDouble();
		System.out.println("Introduce el segundo número: ");
		this.numero2 = tecladoCce.nextDouble();
	}
	
	public void mostrarResultado(Operaciones op) {
		System.out.println("El resultado de la operación " + op.getNombre().toLowerCase() + " es:");
		System.out.println(Double.toString(numero1) 
				+ " " +op.getSimbolo() + " " 
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado) + "\n");
	}
	
	public void anadirHistorial(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " 
				+ Double.toString(numero1) 
				+ " " + op.getSimbolo() + " " 
				+ Double.toString(numero2) + " = "
				+ Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}
	 
	public void anadirHistorialAleatorio(Operaciones op) {
		String nuevaOperacion = op.getNombre() + " -> " 
				+ Double.toString(resultado);
		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;
	}


}
