package mochila;

// Representa un objeto de una instancia del problema de la mochila
public class Objeto implements Comparable<Objeto>
{
	private String _nombre;
	private double _peso;
	private double _beneficio;
	
	public Objeto(String nombre, double peso, double beneficio)
	{
		_nombre = nombre;
		_peso = peso;
		_beneficio = beneficio;
	}

	public String getNombre()
	{
		return _nombre;
	}

	public double getPeso()
	{
		return _peso;
	}

	public double getBeneficio()
	{
		return _beneficio;
	}

	@Override
	public int compareTo(Objeto otro)
	{
		if( this.getBeneficio() > otro.getBeneficio() )
			return -1;
		
		if( this.getBeneficio() == otro.getBeneficio() )
			return 0;
		
		return 1;
	}
}
