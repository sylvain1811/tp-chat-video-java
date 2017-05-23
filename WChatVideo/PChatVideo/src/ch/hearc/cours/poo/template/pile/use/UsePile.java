
package ch.hearc.cours.poo.template.pile.use;

import ch.hearc.cours.poo.interfaces.entrainement.implementations.Banane;
import ch.hearc.cours.poo.template.pile.implementations.PileArrayList;
import ch.hearc.cours.poo.template.pile.implementations.PileLinkedList;
import ch.hearc.cours.poo.template.pile.specification.Pile_I;

public class UsePile
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
		usePileLinkedList();
		usePileArrayList();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void usePileArrayList()
		{
		Pile_I<Banane> pile = new PileArrayList<Banane>();
		usePile(pile);
		}

	private static void usePileLinkedList()
		{
		Pile_I<Banane> pile = new PileLinkedList<Banane>();
		usePile(pile);
		}

	private static void usePile(Pile_I<Banane> pile)
		{
		Banane b1 = new Banane("adsd", 12);
		Banane b2 = new Banane("adsd", 2);

		pile.push(b1);
		System.out.println(pile);
		pile.push(b2);
		System.out.println(pile);
		System.out.println(pile.size());
		System.out.println(pile.pop());
		System.out.println(pile.pop());
		System.out.println(pile.size());
		System.out.println(pile.isEmpty());
		}
	}
