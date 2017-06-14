
package ch.hearc.chatvideo.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class JPanelPrincipal extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelPrincipal(JFramePrincipale jFramePrincipale)
		{
		this.jFramePrincipale = jFramePrincipale;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void repaintJFramePrincipale()
		{
		jFramePrincipale.repaint();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setJFramePrincipaleSize(Dimension dimension)
		{
		jFramePrincipale.setSize(dimension);

		// On profite de recentrer la Frame
		jFramePrincipale.setLocationRelativeTo(null);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		jPanelConfig = new JPanelConfig(this);

		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelConfig);
		}

	private void control()
		{
		// Rien
		}

	private void appearance()
		{
		setSize(jPanelConfig.getSize());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private JFramePrincipale jFramePrincipale;

	// Tools
	private JPanelConfig jPanelConfig;

	}
