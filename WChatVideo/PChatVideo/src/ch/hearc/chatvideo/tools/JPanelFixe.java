
package ch.hearc.chatvideo.tools;

import java.awt.Dimension;

import javax.swing.JPanel;

public class JPanelFixe extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelFixe(int size)
		{
		this.size = size;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		//rien
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		dimension = new Dimension(size, size);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private int size;

	// Tools
	private Dimension dimension;
	}
