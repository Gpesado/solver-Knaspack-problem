package mochila;

import java.util.ArrayList;
import java.util.Collections;

// Representa una instancia del problema de la mochila
public class Instancia
{
	private double _capacidad;
	private ArrayList<Objeto> _objetos;
	private ArrayList<Double> _cache;
	
	public Instancia(double capacidad)
	{
		_capacidad = capacidad;
		_objetos = new ArrayList<Objeto>();
	}
	
	public void agregarObjeto(Objeto obj)
	{
		_objetos.add(obj);
		_cache = null;
		
		Collections.sort(_objetos);
	}
	
	public double getCapacidad()
	{
		return _capacidad;
	}
	
	public ArrayList<Objeto> getObjetos()
	{
		return _objetos;
	}
	
	public double beneficioDesde(int desde)
	{
		if( _cache == null )
			recalcularCache();
		
		return _cache.get(desde);
	}
	
	private void recalcularCache()
	{
		_cache = new ArrayList<Double>();
		for(int i=0; i<=_objetos.size(); ++i)
			_cache.add( calculoBeneficioDesde(i) );
	}
	
	private double calculoBeneficioDesde(int desde)
	{
		double ret = 0;
		for(int i=desde; i<_objetos.size(); ++i)
			ret += _objetos.get(i).getBeneficio();
		
		return ret;
	}	
}
