
package ch.hearc.cours.gui.hello.entrainement3.v2;

public class UseApplication
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
		int nbButton = 10;
		Application.init(nbButton);
		Application.getInstance();

		// : Plus aucune fen�tre ne sont cr�es ici dessous
			{
			Application.getInstance();
			Application.getInstance();
			Application.getInstance();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
