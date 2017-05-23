
package ch.hearc.cours.gui.layout.atomic.nullLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelNullLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelNullLayout()
		{
		geometrie();
		controle();
		apparence();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometrie()
		{
		button1 = new JButton("FlammenwerferSchnitzel");

		setLayout(null);

		calculeTaillePosition();

		add(button1);
		}

	private void controle()
		{
		//rien
		}

	private void apparence()
		{
		//rien
		}

	private void calculeTaillePosition()
		{
		button1.setSize(100, 20);
		button1.setLocation(20, 200);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JButton button1;

	}
