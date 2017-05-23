
package ch.hearc.cours.poo.heritage.hello.branchement.explication.privee;

public class B extends A
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/


	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void m() // interdit de mettre Override car on ne peut pas redefinir une methode privée. La méthode m de la classe parente n'ont Aucune relation entre elles.
					 // un refactor-rename ne renomme pas la methode m de la classe parente car il n'y a aucun liens entre ces 2 methodes.
		{
		System.out.println("mb");
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
