
package ch.hearc.cours.gui.layout.mix.hello;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMixLayout1 extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelMixLayout1()
		{
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

		// JComponent : Instanciation
		buttonNord1 = new JButton("buttonNord1");
		buttonNord2 = new JButton("buttonNord2");
		buttonCentre1 = new JButton("buttonCentre1");
		buttonCentre2 = new JButton("boutonCentre2");

		panelNord = new JPanel();
		panelNord.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelNord.add(buttonNord1);
		panelNord.add(buttonNord2);

		panelCentre = new JPanel();
		panelCentre.setLayout(new GridLayout(0, 2));
		panelCentre.add(buttonCentre2);
		panelCentre.add(buttonCentre1);

		// Layout : Specification
		layout = new BorderLayout();
		setLayout(layout);

		// JComponent : add
		add(panelNord, BorderLayout.NORTH);
		add(panelCentre, BorderLayout.CENTER);
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

	private JButton buttonNord1;
	private JButton buttonCentre1;
	private JButton buttonNord2;

	private JButton buttonCentre2;

	private JPanel panelNord;
	private JPanel panelCentre;

	private BorderLayout layout;

	}
