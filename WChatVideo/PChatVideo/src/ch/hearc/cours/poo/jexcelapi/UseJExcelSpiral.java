
package ch.hearc.cours.poo.jexcelapi;

import java.io.File;
import java.io.IOException;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class UseJExcelSpiral
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args) throws RowsExceededException, WriteException, IOException
		{
		main();
		}

	public static void main() throws RowsExceededException, WriteException, IOException
		{
		File fileName = new File("spiral.xls");
		int nbPts = 50;
		double deltaMod = 0.2;
		double deltaArg = (Math.PI / 8);
		JExcelSpiral excelSpiral = new JExcelSpiral(fileName, nbPts, deltaMod, deltaArg);
		excelSpiral.addSpiral();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
