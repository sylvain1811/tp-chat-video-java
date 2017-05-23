
package ch.hearc.cours.gui.layout.atomic.flowlayout;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelFlowLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelFlowLayout()
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
		label1 = new JLabel("label1");
		label2 = new JLabel("label2");
		label3 = new JLabel("label3");
		label4 = new JLabel("label4");
		label5 = new JLabel("label5");

		layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);

		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		}

	private void controle()
		{
		//rien
		}

	private void apparence()
		{
		layout.setHgap(20);
		layout.setVgap(20);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;

	private FlowLayout layout;
	}
