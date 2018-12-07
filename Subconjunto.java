package mochila;

import java.util.HashSet;
import java.util.Set;

public class Subconjunto
{
	private Set<Objeto> _objetos;
	private double _peso;
	private double _beneficio;
	
	public Subconjunto()
	{
		_objetos = new HashSet<Objeto>();
		_peso = 0;
		_beneficio = 0;
	}
	
	public void agregar(Objeto obj)
	{
		_objetos.add(obj);
		_peso += obj.getPeso();
		_beneficio += obj.getBeneficio();
	}
	
	public void eliminar(Objeto obj)
	{
		_objetos.remove(obj);
		_peso -= obj.getPeso();
		_beneficio -= obj.getBeneficio();
	}
	
	@Override public String toString()
	{
		String ret = "";
		for(Objeto obj: _objetos)
			ret += obj.getNombre() + " ";
		
		return "{" + ret + "}";
	}

	public double peso()
	{
		return _peso;
	}

	public double beneficio()
	{
		return _beneficio;
	}

	public Subconjunto clonar()
	{
		Subconjunto ret = new Subconjunto();
		for(Objeto obj: _objetos)
			ret.agregar(obj);
		
		return ret;
	}
}
