
package ch.hearc.cours.kitbase.collections.linear;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * set = unicité
 */
public class UseSet
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
			System.out.println("\nHashSet:\n");
			Set<Float> set = new HashSet<Float>(n); // n facultatif optimisation
			work(set, n);
			}

		//v2
			{
			System.out.println("\nTreeset:\n");
			Set<Float> set = new TreeSet<Float>(); // relation d'ordre
			work(set, n);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void work(Set<Float> set, int n)
		{
		fill(set, n);
		fill(set, n);
		print(set);
		}

	private static void fill(Set<Float> set, int n)
		{
		for(int i = 1; i <= n; i++)
			{
			set.add((float)i);
			}
		}

	private static void print(Set<Float> set)
		{
		//v1
			{
			Iterator<Float> it = set.iterator();
			while(it.hasNext())
				{
				Float element = it.next();
				System.out.println(element);
				}
			}

		System.out.println();

		//v2
			{
			for(Float element:set)
				{
				System.out.println(element);
				}
			}

		System.out.println();

		//v3
			{
			System.out.println(set.toString());
			}

		System.out.println();

		//v4
			{
			System.out.println(set);
			}

		System.out.println();
		}

	}
