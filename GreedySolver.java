package mochila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GreedySolver{
	private Instancia _instancia;
	
	public GreedySolver(Instancia instancia){
		_instancia = instancia;
	}

	// Algoritmos Golosos.
	public Subconjunto porBeneficios(){
		
		ArrayList<Objeto> objetos = ordenarPorBeneficio();
		return construirSolucion(objetos);		
	}
	
	public Subconjunto porPesos(){
		
		ArrayList<Objeto> objetos = ordenarPorPeso();
		return construirSolucion(objetos);		
	}
	
	public Subconjunto porCociente(){
		ArrayList<Objeto> objetos = ordenarPorCociente();
		return construirSolucion(objetos);		
	}

	private Subconjunto construirSolucion(ArrayList<Objeto> objetos) {
		Subconjunto ret = new Subconjunto();
		for(int i = 0; i < objetos.size(); i++){
			Objeto obj = objetos.get(i);
			if( ret.peso() + obj.getPeso() <= _instancia.getCapacidad() )
				ret.agregar(obj);
		}
		return ret;
	}

	// Ordenamientos.
	private ArrayList<Objeto> ordenarPorBeneficio() {
		ArrayList<Objeto> ret = _instancia.getObjetos();
		Collections.sort(ret, new Comparator <Objeto>()
		{
			@Override
			public int compare(Objeto o1, Objeto o2) {
				if( o1.getBeneficio() > o2.getBeneficio() )
					return -1;
				
					if( o1.getBeneficio() == o2.getBeneficio() )
						return 0;
				
				return 1;
			}
		});
	
		return ret;
	}
	
	private ArrayList<Objeto> ordenarPorPeso() {
		ArrayList<Objeto> ret = _instancia.getObjetos();
		Collections.sort(ret, new Comparator <Objeto>()
		{
			@Override
			public int compare(Objeto o1, Objeto o2) {
				if( o1.getPeso() > o2.getPeso() )
					return -1;
				
					if( o1.getPeso() == o2.getPeso() )
						return 0;
				
				return 1;
			}
		});
	
		return ret;
	}
	
	private ArrayList<Objeto> ordenarPorCociente() {
		ArrayList<Objeto> ret = _instancia.getObjetos();
		Collections.sort(ret, new Comparator <Objeto>()
		{
			@Override
			public int compare(Objeto o1, Objeto o2) {
				
				double miCociente = o1.getBeneficio() / o1.getPeso();
				double tuCociente = o2.getBeneficio() / o2.getPeso();
				
				if( miCociente > tuCociente )
					return -1;
				
				if(miCociente  == tuCociente)
					return 0;
				
				return 1;
			}
		});
	
		return ret;
	}
	
	
}
