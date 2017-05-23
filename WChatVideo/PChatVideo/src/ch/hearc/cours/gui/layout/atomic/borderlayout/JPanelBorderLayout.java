
package ch.hearc.cours.gui.layout.atomic.borderlayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBorderLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBorderLayout()
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

		layout = new BorderLayout();
		setLayout(layout);

		add(button1, BorderLayout.NORTH);
		add(button2, BorderLayout.SOUTH);
		add(button3, BorderLayout.EAST);
		add(button4, BorderLayout.WEST);
		add(button5, BorderLayout.CENTER);
		}

	private void controle()
		{
		//rien
		}

	private void apparence()
		{
		layout.setHgap(20);
		layout.setVgap(20);

		button1.setPreferredSize(new Dimension(-1, 200));
		button4.setPreferredSize(new Dimension(200, -1));

		//BorderLayout: centre : ne tient compte d'aucune valeur de taille par défault
			{
			button5.setPreferredSize(new Dimension(-1, -1));
			button5.setMinimumSize(new Dimension(-1, -1));
			button5.setMaximumSize(new Dimension(-1, -1));
			} //aucun effet!
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

	private BorderLayout layout;
	}
