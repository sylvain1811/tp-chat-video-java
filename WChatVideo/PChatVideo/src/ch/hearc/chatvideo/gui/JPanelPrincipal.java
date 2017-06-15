
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import ch.hearc.chatvideo.tools.JPanelDecorator;

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
		jFramePrincipale.setResizable(true);
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
		JPanelDecorator jPanelDecorator = new JPanelDecorator(jPanelConfig, 50);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelDecorator, BorderLayout.CENTER);
		}

	private void control()
		{
		// Rien
		}

	private void appearance()
		{
		setSize(jPanelConfig.getSize());
		setBackground(Color.WHITE);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private JFramePrincipale jFramePrincipale;

	// Tools
	private JPanelConfig jPanelConfig;

	}
