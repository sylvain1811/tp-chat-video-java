
package ch.hearc.cours.gui.hello;



public class UseJFrameHello
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
		new JFrameHello(); //d�marrage implicite du thread awt-queue-event
		System.out.println("Fin thread main");
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

