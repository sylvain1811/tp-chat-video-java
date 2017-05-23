
package ch.hearc.cours.poo.jexcelapi;

import java.io.File;
import java.io.IOException;

import ch.hearc.cours.poo.doublerepresentation.Complex;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class JExcelSpiral
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JExcelSpiral(File fileName, int nbPts, double deltaMod, double deltaArg) throws IOException, RowsExceededException, WriteException
		{
		this.fileName = fileName;
		this.nbPts = nbPts;
		this.deltaMod = deltaMod;
		this.deltaArg = deltaArg;
		this.tabComplex = new Complex[nbPts];
		this.workbook = Workbook.createWorkbook(fileName);
		this.sheet = workbook.createSheet("Spiral", 0);
		this.createHeader();

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addSpiral() throws RowsExceededException, WriteException, IOException
		{
		createSpiral();
		for(int i = 0; i < tabComplex.length; i++)
			{
			Number real = new Number(1, i + 2, tabComplex[i].getRe());
			Number imaginary = new Number(2, i + 2, tabComplex[i].getIm());
			sheet.addCell(real);
			sheet.addCell(imaginary);
			}
		workbook.write();
		workbook.close();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void createHeader() throws RowsExceededException, WriteException
		{
		labelRe = new Label(1, 1, "Real");
		labelIm = new Label(2, 1, "Imaginary");
		sheet.addCell(labelRe);
		sheet.addCell(labelIm);
		}

	private void createSpiral()
		{
		for(int i = 0; i < nbPts; i++)
			{
			tabComplex[i] = Complex.createPolaire((i * deltaMod), (i * deltaArg));
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	File fileName;
	int nbPts;
	double deltaMod;
	double deltaArg;

	//tools
	Complex[] tabComplex;
	WritableWorkbook workbook;
	WritableSheet sheet;
	Label labelRe;
	Label labelIm;
	}
