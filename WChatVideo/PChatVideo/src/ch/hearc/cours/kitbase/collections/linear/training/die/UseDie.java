
package ch.hearc.cours.kitbase.collections.linear.training.die;

public class UseDie
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
		int nbFace=6;
		int nbExperience=Integer.MAX_VALUE/100;

		int nbLancerMoyen=Die.moyenneur(nbFace, nbExperience);
		System.out.println("nbLancerMoyen = "+nbLancerMoyen);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
