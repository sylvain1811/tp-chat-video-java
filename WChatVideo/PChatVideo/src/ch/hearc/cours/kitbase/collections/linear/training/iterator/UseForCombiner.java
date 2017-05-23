
package ch.hearc.cours.kitbase.collections.linear.training.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class UseForCombiner
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

		// create
		List<Integer> listX = createX(n);
		List<Integer> listY = createY(n);

		// print
			{
			printV1(listX, listY);
			System.out.println();
			printV2(listX, listY);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * hyp : lisX.size()==listY.size()
	 */
	private static void printV1(List<Integer> listX, List<Integer> listY)
		{
		Assert.assertTrue(listX.size()==listY.size());

		Iterator<Integer> itX = listX.iterator();
		Iterator<Integer> itY = listY.iterator();

		while(itX.hasNext())
			{
			int x = itX.next(); // unboxing automatique : Integer to int

			Integer Y = itY.next();
			int y = Y.intValue(); // unboxing manuel

			// v1
				{
				System.out.println("(" + x + "," + y + ")");
				}

			// v2 : optimisation
				{
				//todo
				}
			}
		}

	/**
	 * hyp : lisX.size()==listY.size()
	 */
	private static void printV2(List<Integer> listX, List<Integer> listY)
		{
		Assert.assertTrue(listX.size()==listY.size());

		Iterator<Integer> itX = listX.iterator();

		// v1
			{
			for(Integer y:listY)
				{
				int x = itX.next(); // unboxing automatique : Integer to int

				// v1
					{
					System.out.println("(" + x + "," + y + ")");
					}

				// v2
				//	{
				//	System.out.println("(" + x + "," + y.toString() + ")");
				//	}
				}
			}

		// v2
		//			{
		//			for(int y:listY)
		//				{
		//				int x = itX.next(); // unboxing automatique : Integer to int
		//				System.out.println("(" + x + "," + y + ")");
		//				}
		//			}
		}

	private static List<Integer> createX(int n)
		{
		List<Integer> listX = new ArrayList<Integer>(n);

		for(int i = 0; i < n; i++)
			{
			listX.add(i); // boxing (wrapping automatique) : int to Integer
			}

		return listX;
		}

	private static List<Integer> createY(int n)
		{
		List<Integer> listY = new LinkedList<Integer>();

		for(int i = 0; i < n; i++)
			{
			Integer value = new Integer(i * 10); // boxing (wrapping) manuel : int to Integer

			listY.add(value);
			}

		return listY;
		}

	}
