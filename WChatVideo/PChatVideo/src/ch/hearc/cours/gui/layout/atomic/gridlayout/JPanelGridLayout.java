
package ch.hearc.cours.gui.layout.atomic.gridlayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelGridLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelGridLayout()
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
		button1 = new JButton("bouton1");
		button2 = new JButton("bouton2");
		button3 = new JButton("bouton3");
		button4 = new JButton("bouton4");
		button5 = new JButton("bouton5");

		layout = new GridLayout(0,2); //2 colonnes, nb de lignes calculés automatiquement, ici 3
		setLayout(layout);

		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		}

	private void controle()
		{
		//rien
		}

	private void apparence()
		{
		layout.setHgap(50);
		layout.setVgap(20);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;

	private GridLayout layout;
	}
