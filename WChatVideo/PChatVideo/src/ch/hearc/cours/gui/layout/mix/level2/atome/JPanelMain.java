
package ch.hearc.cours.gui.layout.mix.level2.atome;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import ch.hearc.cours.gui.layout.mix.level2.atome.main.JPanelControlA;
import ch.hearc.cours.gui.layout.mix.level2.atome.main.JPanelControlB;

public class JPanelMain extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMain()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		jPanelControlA = new JPanelControlA();
		jPanelControlB = new JPanelControlB();
		boxV = createBox();

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			}

		// JComponent : add
		add(boxV, BorderLayout.CENTER);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	private Box createBox()
		{
		Box boxV = Box.createVerticalBox();

		boxV.add(Box.createVerticalGlue());
		boxV.add(jPanelControlA);
		boxV.add(Box.createVerticalGlue());
		boxV.add(jPanelControlB);

		return boxV;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelControlA jPanelControlA;
	private JPanelControlB jPanelControlB;
	private Box boxV;

	}
