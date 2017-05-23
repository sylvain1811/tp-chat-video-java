
package ch.hearc.cours.gui.java2D.affineTransformMieu;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JFrameSalleConf extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameSalleConf()
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
		this.jpanelSalleConf = new JPanelSalleConf(6);
		this.jPanelControl = new JPanelControl(this.jpanelSalleConf);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(this.jpanelSalleConf, BorderLayout.CENTER);
		add(this.jPanelControl,BorderLayout.SOUTH);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(1024, 768);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelSalleConf jpanelSalleConf;
	private JPanelControl jPanelControl;

	}
