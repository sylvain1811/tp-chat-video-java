
package ch.hearc.cours.gui.layout.mix.level2;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ch.hearc.cours.gui.layout.mix.level2.atome.JPanelItem;
import ch.hearc.cours.gui.layout.mix.level2.atome.JPanelMain;
import ch.hearc.cours.gui.layout.mix.level2.atome.JPanelMenu;

public class JPanelImbrication extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelImbrication()
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
		jPanelMenu = new JPanelMenu();
		jPanelItem = new JPanelItem();
		jPanelMain = new JPanelMain();

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelMenu, BorderLayout.NORTH);
		add(jPanelItem, BorderLayout.WEST);
		add(jPanelMain, BorderLayout.CENTER);

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
	private JPanelMenu jPanelMenu;
	private JPanelItem jPanelItem;
	private JPanelMain jPanelMain;
	}
