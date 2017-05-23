
package ch.hearc.cours.kitbase.collections.linear;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UseListes
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
		int n = 5;

		//v1
			{
			System.out.println("\nLinkedList:\n");
			List<Float> list = new LinkedList<Float>();
			work(list, n);
			}

		//v2
			{
			System.out.println("\nArrayList:\n");
			List<Float> list = new ArrayList<Float>(n); // n facultatif optimisation
			work(list, n);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void work(List<Float> list, int n)
		{
		fill(list, n);
		fill(list, n);
		print(list);
		}

	private static void print(List<Float> list)
		{
		//V1:Musée des horreurs si LinkedList (complexite quadratique)
			{
			for(int i = 0; i < list.size(); i++)
				{
				System.out.println(list.get(i));
				}
			}

		System.out.println("");

		//V2:
			{
			for(float element:list) //readable
				{
				System.out.println(element);
				}
			}

		System.out.println("");

		//V3:
		  {
			Iterator<Float> it = list.iterator();
			while(it.hasNext())
				{
				Float element = it.next();
				System.out.println(element);

				}
			}

		System.out.println("");

		//V4:
			{
			System.out.println(list.toString());
			}

		System.out.println("");

		//V5: (Idem v4, toString appeler automatiquement)
			{
			System.out.println(list);
			}
		}

	private static void fill(List<Float> list, int n)
		{
		for(int i = 1; i <= n; i++)
			{
			list.add((float)i);
			}
		}
	}
