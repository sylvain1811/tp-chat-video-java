
package ch.hearc.cours.kitbase.collections.linear.tab2d;

public class UseTab2D
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
		useV1();
		useV2();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useV2()
		{
		work(Tab2D.createRectangulaireManuel(2, 3));

		work(Tab2D.create(2, 3));

		work(Tab2D.createTriangulaire(5));

		int[] tabCologneParLigne = { 3, 6, 8, 2, 4 };
		work(Tab2D.createHeterogene(tabCologneParLigne));
		}

	private static void useV1()
		{
		//rectangulaire manuel
			{
			double[][] tab = Tab2D.createRectangulaireManuel(2, 3);
			work(tab);
			}

		//rectangulaire automatique
			{
			double[][] tab = Tab2D.create(2, 3);
			work(tab);
			}

		//triangulaire
			{
			double[][] tab = Tab2D.createTriangulaire(5);
			work(tab);
			}

		//hétérogène
			{
			int[] tabCologneParLigne = { 3, 6, 8, 2, 4 };
			double[][] tab = Tab2D.createHeterogene(tabCologneParLigne);
			work(tab);
			}
		}

	private static void work(double[][] tab)
		{
		Tab2D.fill(tab);
		System.out.println("\n");
		Tab2D.printV1(tab);
		System.out.println("\n");
		Tab2D.printV2(tab);
		}
	}
