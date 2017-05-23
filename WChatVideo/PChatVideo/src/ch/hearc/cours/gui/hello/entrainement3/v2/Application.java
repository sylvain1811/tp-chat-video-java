
package ch.hearc.cours.gui.hello.entrainement3.v2;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JLabel;

import org.junit.Assert;

import ch.hearc.cours.gui.hello.entrainement3.v1.JButtonLabel;

public class Application
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private Application(int n)
		{
		this.n = n;
		create();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized Application getInstance()
		{
		Assert.assertTrue(NBBUTTON != 0);

		if (INSTANCE == null)
			{
			INSTANCE = new Application(NBBUTTON);
			}

		return INSTANCE;
		}

	/**
	 * Contrainte: doit être appelé une seule fois et avant le getInstance()
	 */
	public static synchronized void init(int nbButton)
		{
		Assert.assertTrue(INSTANCE == null);
		NBBUTTON = nbButton;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void create()
		{
		tabJButton = new JButtonLabel[n];
		tabJLabel = new JLabel[n];

		for(int i = 0; i < n; i++)
			{
			JLabel label = new JLabel("0");
			tabJButton[i] = new JButtonLabel(label, "click" + i);
			tabJLabel[i] = label;
			}

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		Point positionButton = new Point(0, 0);
		Point positionLabel = new Point(dim.width / 2, dim.height / 2); // à améliorer !

		this.jFrameButton = new JFrameComponent(tabJButton, positionButton);
		this.jFrameLabel = new JFrameComponent(tabJLabel, positionLabel);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input
	private int n;

	// tools
	private JButtonLabel[] tabJButton;
	private JLabel[] tabJLabel;

	// outputs
	private JFrameComponent jFrameButton;
	private JFrameComponent jFrameLabel;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static Application INSTANCE = null;
	private static int NBBUTTON = 0;
	}
