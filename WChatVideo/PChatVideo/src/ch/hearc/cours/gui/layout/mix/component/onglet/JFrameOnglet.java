
package ch.hearc.cours.gui.layout.mix.component.onglet;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import ch.hearc.cours.gui.tools.JPanelDecorator;

public class JFrameOnglet extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameOnglet()
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
		panelOnglet = new JPanelOnglet();
		panelDecorator = new JPanelDecorator(panelOnglet, 50);
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(panelDecorator, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelOnglet panelOnglet;
	private JPanelDecorator panelDecorator;
	}
