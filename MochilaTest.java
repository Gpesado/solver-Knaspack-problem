package mochila;

public class MochilaTest
{
	public static void main(String[] args)
	{
		for(int peso = 10; peso <= 100; ++peso)
		{
			Instancia instancia = new Instancia(peso);
			for(int i=1; i<=25; ++i)
				instancia.agregarObjeto(new Objeto("xxx", i, i));
			
			Solver solver = new Solver(instancia, Solver.Algoritmo.Backtracking);
			Subconjunto optimo = solver.resolver();
			
			System.out.print("peso = " + peso + "; ");
			System.out.print("fobj = " + optimo.beneficio() + "; ");
			System.out.print(solver.getHojas() + " hojas" + "; ");
			System.out.print(solver.getTiempo() + " sg; ");
			System.out.print(solver.getNodos() + " nodos; ");
			System.out.println(solver.getBoundings() + " bounds");
		}
	}
}
