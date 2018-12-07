package mochila;

public class Solver
{
	private Instancia _instancia;
	private Subconjunto _conjunto;
	private Subconjunto _mejor; // Hasta ahora
	private Algoritmo _algoritmo;

	private int _hojas;
	private int _nodos;
	private int _boundings;
	private double _tiempo;
	
	public enum Algoritmo { FuerzaBruta, Backtracking };
	
	public Solver(Instancia instancia, Algoritmo algoritmo)
	{
		_instancia = instancia;
		_algoritmo = algoritmo;
	}
	
	public int getHojas()
	{
		return _hojas;
	}
	
	public int getNodos()
	{
		return _nodos;
	}
	
	public int getBoundings()
	{
		return _boundings;
	}

	public double getTiempo()
	{
		return _tiempo;
	}
	
	public Subconjunto resolver()
	{
		long inicio = System.currentTimeMillis();
		
		_conjunto = new Subconjunto();
		_mejor = null;
		_hojas = 0;
		_nodos = 0;
		_boundings = 0;
		
		generarDesde(0);
		
		long fin = System.currentTimeMillis();
		_tiempo = (fin - inicio) / 1000.0; // Para que sea un float
		
		return _mejor;
	}
	
	private void generarDesde(int i)
	{
		_nodos += 1;
		
		// Backtracking si estamos pasados de peso o no hay optimos en esta rama
		if( _algoritmo == Algoritmo.Backtracking )
		{
			if( _conjunto.peso() > _instancia.getCapacidad() )
				return;
			
			if( _mejor != null && _conjunto.beneficio() + _instancia.beneficioDesde(i) < _mejor.beneficio() )
			{
				_boundings += 1;
				return;
			}
		}
		
		// Caso base
		if( i == _instancia.getObjetos().size() )
		{
			_hojas += 1;
			analizarActual();
			return;
		}
		
		// Caso recursivo
		Objeto obj = _instancia.getObjetos().get(i);
		_conjunto.agregar(obj);
		generarDesde(i+1);
		
		_conjunto.eliminar(obj);
		generarDesde(i+1);
	}
	
	private void analizarActual()
	{
		// Si no cumple la capacidad de la mochila, se rechaza
		if( _conjunto.peso() > _instancia.getCapacidad() )
			return;
		
		// Si no, se compara su beneficio con el mejor hasta ahora
		if( _mejor == null || _conjunto.beneficio() >= _mejor.beneficio() )
			_mejor = _conjunto.clonar();
	}
}
