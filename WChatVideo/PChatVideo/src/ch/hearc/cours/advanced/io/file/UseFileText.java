
package ch.hearc.cours.advanced.io.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ch.hearc.cours.advanced.io.file.tools.Tools;

public class UseFileText
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
		System.out.println("Version texte");
		String filename = "data.txt";
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

	private static double[] load(String filename) throws IOException
		{
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		List<String> list = new LinkedList<String>();

		String line;
		while((line = br.readLine()) != null)
			{
			String[] tab = line.split(SEPARATOR);
			list.addAll(Arrays.asList(tab));
			}

		br.close();
		fr.close();

		return toTabDouble(list);
		}

	private static double[] toTabDouble(List<String> list)
		{
		double[] tab = new double[list.size()];
		int i = 0;
		for(String d:list)
			{
			tab[i++] = Double.valueOf(d);
			}

		return tab;
		}

	private static void save(double[] tab, String filename) throws IOException
		{
		FileWriter fw = new FileWriter(filename);
		BufferedWriter bw = new BufferedWriter(fw);

		for(double d:tab)
			{
			bw.write(d + SEPARATOR);
			}

		bw.close();
		fw.close();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final String SEPARATOR = " ";

	}
