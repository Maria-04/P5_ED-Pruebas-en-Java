package calcualdora;

import java.util.Scanner;

public class CalculadoraED {

	public static void main(String[] args) {
		
		CerebroCalculadoraED cce = new CerebroCalculadoraED();
		Scanner teclado = new Scanner(System.in);
		String entrada;
		do {
			imprimirCabecera();
			imprimirSeleccionOp();
	
			entrada = teclado.next();
			if (validarEntrada(entrada)) {
				cce.procesarOperacion(entrada);
			}else {
				System.out.println("Entrada no reconocida");
			}
		} while (!entrada.equals("x"));
		imprimirDespedida();
	}
	
	private static void imprimirCabecera() {
		System.out.println("*----------------------------------*");
		System.out.println("*----------Calculadora ED----------*");
		System.out.println("*----------------------------------*");
	}
	
	private static void imprimirDespedida() {
		System.out.println("*-----------------------------------------*");
		System.out.println("*----¡Gracias por usar Calculadora ED!----*");
		System.out.println("*-----------------------------------------*");
	}
	
	private static void imprimirSeleccionOp() {
		Operaciones[] ops = Operaciones.values();
		for(Operaciones op: ops)
		{
			System.out.println(op.getOpcionMenu());
	    }
		System.out.println("¿Qué operación desea realizar? (x para terminar)");
	}
	
	private static boolean validarEntrada(String entrada) {
		if (entrada.equals("x")) {
			return true;
		} else {
			boolean opValida = false;
			Operaciones[] ops = Operaciones.values();
			for(Operaciones op: ops)
			{
				if(Integer.toString(op.getId()).equals(entrada)) {
					opValida = true;
				}
		    }
			return opValida;
		}
	}
	
	

}
