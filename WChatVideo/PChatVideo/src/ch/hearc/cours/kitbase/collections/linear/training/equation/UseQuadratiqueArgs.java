
package ch.hearc.cours.kitbase.collections.linear.training.equation;

public class UseQuadratiqueArgs
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/**
	 * args : a=1 b=2 c=3
	 * Separateur ESPACE
	 * axx+bx+c=0
	 */
	public static void main(String[] args)
		{
		double[] tabABC = toABC(args);
		double[] tabSol = Quadratique.solve(tabABC);
		Quadratique.printSolution(tabABC, tabSol);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static double[] toABC(String[] args)
		{
		int n = args.length;
		if (n != 3)
			{
			System.err.println("Nombre d'arguments invalide");
			System.exit(-1); // 0 normal, -1 anormal
			return null;
			}
		else
			{
			double[] tabABC = new double[3];
			for(int i = 0; i < n; i++)
				{
				String[] tab = args[i].split("="); // on pourrait faire ici aussi ici un try catch pour checker la forme X=Y
				double value = toDouble(tab[1]);
				tabABC[i] = value;
				}
			return tabABC;
			}
		}

	private static double toDouble(String string)
		{
		try
			{
			return Double.valueOf(string);
			}
		catch (NumberFormatException e)
			{
			//e.printStackTrace();
			System.err.println("La variable n'est pas un nombre");
			System.exit(-1); // 0 normal, -1 anormal
			return -1;
			}
		}
	}
