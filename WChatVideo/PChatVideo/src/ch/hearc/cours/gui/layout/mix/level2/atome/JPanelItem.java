
package ch.hearc.cours.gui.layout.mix.level2.atome;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelItem extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelItem()
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
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");

		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(3, 1);
			setLayout(gridLayout);
			gridLayout.setVgap(25);
			}

		// JComponent : add
		add(button1);
		add(button2);
		add(button3);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton button1;
	private JButton button2;
	private JButton button3;

	}
