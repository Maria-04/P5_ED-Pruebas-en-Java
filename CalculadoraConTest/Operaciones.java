package calcualdora;

import java.util.Arrays;

public enum Operaciones {
	SUMAR("Suma","+","Suma dos números",1),
	RESTAR("Resta","-","Resta dos números",2),
	MULTIPLICAR("Multiplicación","*","Multiplica dos números",3),
	DIVIDIR("División","/","Divide dos números",4),
	SUMAR_RES("Sumar al resultado","+=","Suma un número al resultado actual",5),
	RESTAR_RES("Restar al resultado","-=","Al resultado actual le resta un número",6),
	MULTIPLICAR_RES("Multiplicar al resultado","*=","Multiplica un número al resultado actual",7),
	DIVIDIR_RES("Dividir al resultado","/=","Resultado actual dividido por un número",8),
	RESULTADO("Mostrar resultado","!","Muestra el último resultado",9),
	RANDOM("Número aleatorio","¿?","Crea un número aleatorio 1-100", 10),
	HISTORIAL("Historial","h","Muestra las cinco últimas operaciones",11);

	private final String nombreOperacion;
	private final String simboloOperacion;
	private final String infoOperacion;
	public final int idOperacion;
	
	Operaciones (String nombre, String simbolo, String info, int id){
		this.nombreOperacion = nombre;
		this.simboloOperacion = simbolo;
		this.infoOperacion = info;
		this.idOperacion = id;
	}
	
	public String getNombre() {return nombreOperacion;}
	public String getInfo() {return infoOperacion;}
	public String getSimbolo() {return simboloOperacion;}
	public int getId() {return idOperacion;}
	public String getOpcionMenu() {return idOperacion + ".- " + nombreOperacion;}
	

}
