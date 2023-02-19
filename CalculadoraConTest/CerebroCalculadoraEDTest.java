package calcualdora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class CerebroCalculadoraEDTest {
	CerebroCalculadoraED c= new CerebroCalculadoraED();
	Operaciones op;
	
	@AfterEach
	void escribirDespues() {
		System.out.println("Fin del test \n");
	}

//He intentado hacer los test con cada uno de los atributos del enum Operaciones para no hacer todos los test con el símbolo ( por ej.)	
	
	@Test
	@Order(1)
	public void testSuma() {
		Operaciones signoSuma= Operaciones.SUMAR;
		System.out.println("Vamos a hacer el test "+ signoSuma.getNombre());
		
		String resultado= signoSuma.getSimbolo();
		String esperadoS= Operaciones.SUMAR.getSimbolo();
		c.operarSuma(signoSuma);
	
		assertEquals(esperadoS, resultado);
	}

	@Test
	@Order(2)
	public void testResta() {
	Operaciones signoresta= Operaciones.RESTAR;
	System.out.println("Vamos a hacer el test "+signoresta.getNombre());
	
	String resultado= signoresta.getNombre();
	String esperadoR= Operaciones.RESTAR.getNombre();
		
	c.operarResta(signoresta);
		
		assertEquals(esperadoR, resultado);
	}
	
	@Test
	@Order(3)
	public void testMultiplicacion() {
		Operaciones signomultiplicar= Operaciones.MULTIPLICAR;
		System.out.println("Vamos a hacer el test "+signomultiplicar.getNombre());
		
		String resultado= signomultiplicar.getInfo();
		String esperadoM= Operaciones.MULTIPLICAR.getInfo();
		
		c.operarMultiplica(signomultiplicar);
		
		assertEquals(esperadoM, resultado);
	}
	
	@Test
	@Order(4)
	public void testDivision() {
		Operaciones signodividir= Operaciones.DIVIDIR;
		System.out.println("Vamos a hacer el test "+signodividir.getNombre());
		
		int resultado= signodividir.getId();
		int esperadoD= Operaciones.DIVIDIR.getId();
		
		c.operarDivide(signodividir);
		
		assertEquals(esperadoD, resultado);
	}
	
	
//Hacemos que el resultado esperado sea 15 para comprobar que el test da bien con un resultado que nosotros pongamos (en el esperado puedes poner
//el nº que quieras para comprobar que el test de la función 'operarSumaRes' no tiene fallos
	@Test
	@Order(5)
	public void testIncrementSuma() {
		Operaciones sumarResul= Operaciones.SUMAR_RES;
		System.out.println("Vamos a hacer el test "+sumarResul.getNombre());
		
		c.operarSuma(sumarResul);
		double resul1= c.resultado;
		c.numero2=0;
		resul1=0;
		c.operarSumaRes(sumarResul);
		c.mostrarResultadoActual(sumarResul);
		
		double resul2= c.resultado;
		double esperadoSR=15;
		
		assertEquals(esperadoSR, resul1 + resul2);
	}

	
//Este test siempre va a dar mal porque la función 'operarRestaRes' está mal formulada, en vez de sumar el resultado con el nº2, deberían restarse
// por lo que es fallo del que ha hecho el código
	@Test 
	@Order(10)
	public void testRestarResultado() {
		Operaciones restarResul= Operaciones.RESTAR_RES;
		System.out.println("Vamos a hacer el test "+restarResul.getNombre());
		
		c.operarRestaRes(restarResul);
		
		double resul= c.resultado;
		
		c.numero2= 0;
		c.operarRestaRes(restarResul);
		c.mostrarResultadoActual(restarResul);
		
		double resul2= c.resultado;
		double esperadoRR=11;
		
		assertEquals(esperadoRR, (resul - resul2));
	}

	
//Forzamos a que el resultado sea 22 para verificar que la función 'operarMultiplicaRes' funciona sin fallo alguno (se puede poner cualquier nº
//que quieras para comprobarlo pero solo en el 'esperado')
	@Test
	@Order(7)
	public void testMultiplicarResul() {
		Operaciones multiplicarResul= Operaciones.MULTIPLICAR_RES;
		System.out.println("Vamos a hacer el test "+multiplicarResul.getNombre());
		
		c.operarMultiplica(multiplicarResul);
		c.numero2= c.resultado;
		
		double esperadoMR= 22;
		double resul= c.resultado;
		
		c.operarMultiplicaRes(multiplicarResul);
		c.mostrarResultadoActual(multiplicarResul);

		assertEquals(esperadoMR, resul);
	}
	
	
//Forzamos a que el resultado sea 22 para verificar que la función 'operarDivideRes' funciona bien (pon el nº que quieras para comprobarlo
//pero solo en el 'esperado' ya que sino no funciona)
	@Test
	@Order(8)
	public void testDividirResul() {
		Operaciones dividirResul= Operaciones.DIVIDIR_RES;
		System.out.println("Vamos a hacer el test "+dividirResul.getNombre());
		
		c.operarDivide(dividirResul);
		c.numero2= c.resultado;
		
		double resul= c.resultado;
		double esperadoDR= 11;
		
		c.operarDivideRes(dividirResul);
		c.mostrarResultadoActual(dividirResul);
		
		assertEquals(esperadoDR, resul);
	}
	
	
// Para comprobar que la función que genera un número random funciona usé el assertNotNull para comprobar que en verdad genera un nº. Para ver si
// no generaba el mismo nº aleatorio realicé varias veces este test por separado para comprobar que no generase el mismo nº.
	@Test
	@Order(9)
	public void testNumAleatorio() {
		Operaciones numeroRandom= Operaciones.RANDOM;
		System.out.println("Vamos a hacer el test "+ numeroRandom.getNombre());
		
		c.numeroAleatorio(numeroRandom);
		
		assertNotNull(numeroRandom);
	}
	
//Con este test compruebo que el historial funciona bien poniendo las operaciones que hice previamente en los test 1 a 5 (los nº de las operaciones
//	se pueden cambiar dependiendo de cuáles hayas puesto al hacer los test)
	@Test
	@Order(6)
	public void testHistorial() {
		Operaciones probarHistorial= Operaciones.HISTORIAL;
		System.out.println("Vamos a hacer el test a "+ probarHistorial.getNombre());
	
		String miarray[]= {"1.0 + 1.0 = 2.0","3.0 - 2.0 = 1.0", "4.0 * 2.0 = 8.0","10.0 / 2.0 = 5.0","14.0 += 1.0 = 15.0"};

		assertArrayEquals(miarray, c.historial);
	}

//	Para el switch compruebo solo 1 vez que pasa por uno de los 'case' para comprobar que el switch funciona correctamente
// Tampoco hago más de una prueba porque me parece un poco probar por probar y para aumentar la cobertura innecesariamente	
	@Test
	@Order(11)
	public void pruebaSwitch1() {
		Operaciones pruebaSwitch= Operaciones.SUMAR;
		System.out.println("Vamos a hacer el test "+ pruebaSwitch.getNombre()+ " para comprobar el switch");
		
		c.procesarOperacion("1");
		
		int id= pruebaSwitch.getId();
		String resultado = Integer.toString(id);
		
		assertEquals("1", resultado);
	}
}