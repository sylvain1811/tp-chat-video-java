
package ch.hearc.cours.advanced.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import ch.hearc.cours.advanced.io.file.tools.Tools;

public class UseFileBin
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		try
			{
			main();
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		}

	public static void main() throws IOException
		{
		String filename = "data.bin";
		int n = 10;
		double[] tab = Tools.create(n);

		save(tab, filename);
		double[] tabCopie = load(filename);

		Tools.print(tab);
		Tools.print(tabCopie);

		System.out.println(new File(filename).delete());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void save(double[] tab, String filename) throws IOException
		{
		FileOutputStream fos = new FileOutputStream(filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);

		for(double data:tab)
			{
			dos.writeDouble(data);
			}

		dos.close();
		bos.close();
		fos.close();
		}

	private static double[] load(String filename) throws IOException
		{
		FileInputStream fis = new FileInputStream(filename);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);

		List<Double> list = new LinkedList<Double>();

		try
			{
			while(true)
				{
				double data = dis.readDouble();
				list.add(data);
				}
			}
		catch (EOFException e)
			{
			}

		dis.close();
		bis.close();
		fis.close();

		//Double[] tab = list.toArray(new Double[0]);

		return toTab(list);
		}

	private static double[] toTab(List<Double> list)
		{
		double[] tab = new double[list.size()];
		int i = 0;
		for(double d:list)
			{
			tab[i++] = d;
			}

		return tab;
		}

	}
