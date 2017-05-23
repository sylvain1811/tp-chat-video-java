
package ch.hearc.cours.kitbase.collections.linear.training.equation;



public class UseQuadratique
	{
		/*------------------------------------------------------------------*\
		|*							Methodes Public							*|
		\*------------------------------------------------------------------*/

		public static void main(String[] args)
			{
			main();
			}

		public static void main()
			{
			useSolution1();
			useSolution2();
			useSolution0();
			}



		/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

		private static void useSolution0()
			{
			double a=1;
			double b=1;
			double c=1;
			double[] tabSol=Quadratique.solve(a, b, c);
			Quadratique.printSolution(a,b,c,tabSol);
			}

		private static void useSolution2()
			{
			double a=3;
			double b=-9;
			double c=6;
			double[] tabSol=Quadratique.solve(a, b, c);
			Quadratique.printSolution(a,b,c,tabSol);
			}

		private static void useSolution1()
			{
			double a=3;
			double b=-6;
			double c=3;
			double[] tabSol=Quadratique.solve(a, b, c);
			Quadratique.printSolution(a,b,c,tabSol);
			}

	}

