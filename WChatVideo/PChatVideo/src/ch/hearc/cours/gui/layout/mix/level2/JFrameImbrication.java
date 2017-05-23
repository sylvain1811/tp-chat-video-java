package ch.hearc.cours.gui.layout.mix.level2;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameImbrication extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameImbrication()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		jPanelImbrication =  new JPanelImbrication();
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelImbrication,BorderLayout.CENTER);
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
	private JPanelImbrication jPanelImbrication;

	}
