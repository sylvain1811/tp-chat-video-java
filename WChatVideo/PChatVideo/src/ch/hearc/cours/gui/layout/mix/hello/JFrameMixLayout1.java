
package ch.hearc.cours.gui.layout.mix.hello;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameMixLayout1 extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameMixLayout1()
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
			// JComponent : Instanciation
			PanelMixLayout = new JPanelMixLayout1();

			// Layout : Specification
				{
				BorderLayout borderLayout = new BorderLayout();
				setLayout(borderLayout);

				// borderLayout.setHgap(20);
				// borderLayout.setVgap(20);
				}

			// JComponent : add
			add(PanelMixLayout, BorderLayout.CENTER);
		}

	private void controle()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void apparence()
		{
		setSize(500, 500);
		setTitle("MixLayout1");
		setLocationRelativeTo(null);

		setVisible(true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JPanelMixLayout1 PanelMixLayout;
	}
