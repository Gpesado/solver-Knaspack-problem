package mochila;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreedyTest {

	@Test
	public void porBeneficiotest() {
		Instancia instancia= new Instancia(25);
		
		instancia.agregarObjeto(new Objeto("Obj1",8, 12));
		instancia.agregarObjeto(new Objeto("Obj2",8, 12));
		instancia.agregarObjeto(new Objeto("Obj3",8, 12));
		instancia.agregarObjeto(new Objeto("Obj4",8, 8.66));
		instancia.agregarObjeto(new Objeto("Obj5",3, 4.33));
		
		GreedySolver goloso = new GreedySolver(instancia);
		Subconjunto solucion =  goloso.porBeneficios();
		
		assertEquals(36, solucion.beneficio(), 0.001);
		assertEquals(24, solucion.peso(), 0.001);
	}
	
	@Test
	public void todosPesadosTest() {
		Instancia instancia= new Instancia(3);
		
		instancia.agregarObjeto(new Objeto("Obj1",8, 12));
		instancia.agregarObjeto(new Objeto("Obj2",4, 15));
		instancia.agregarObjeto(new Objeto("Obj3",5, 17));
		
		GreedySolver goloso = new GreedySolver(instancia);
		Subconjunto solucion =  goloso.porBeneficios();
		
		assertEquals(0, solucion.beneficio(), 0.001);
		assertEquals(0, solucion.peso(), 0.001);
	}
	
}
