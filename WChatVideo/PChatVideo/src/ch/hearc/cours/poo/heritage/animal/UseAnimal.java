
package ch.hearc.cours.poo.heritage.animal;

import ch.hearc.cours.poo.heritage.animal.mammiferes.felins.tigres.Tigre;
import ch.hearc.cours.poo.heritage.animal.oiseaux.rapaces.Rapaces;

public class UseAnimal
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
		//useTigre();
		//useCloneOfDeTigre();
		useRapaces();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useTigre()
		{
		Tigre tigre = new Tigre("tigrou");
		System.out.println(tigre);
		}

	private static void useCloneOfDeTigre()
		{
		//Test du constructeur de recopie
		Tigre tigre1 = new Tigre("tigrou");
		Tigre tigre2 = new Tigre(tigre1);
		System.out.println("tigre1 : " + tigre1);
		System.out.println("tigre2 : " + tigre2);
		//Test de la méthode cloneOf
		Tigre tigre3;
		tigre3 = tigre2.cloneOf();
		tigre2.setNom("Winnie");
		System.out.println("tigre2 : " + tigre2);
		System.out.println("tigre3 : " + tigre3);// DOit afficher tigrou
		}

	private static void useRapaces()
		{
		Rapaces rapace1 = new Rapaces("Crecelle", 2500);
		System.out.println(rapace1);
		Rapaces rapace2 = new Rapaces(rapace1);
		System.out.println(rapace2);
		}

	}
