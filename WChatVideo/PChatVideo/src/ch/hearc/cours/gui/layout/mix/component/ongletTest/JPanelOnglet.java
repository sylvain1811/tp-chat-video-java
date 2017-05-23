
package ch.hearc.cours.gui.layout.mix.component.ongletTest;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import ch.hearc.cours.gui.layout.mix.component.ongletTest.atom.JPanelOnglet1;
import ch.hearc.cours.gui.layout.mix.component.ongletTest.atom.JPanelOnglet2;
import ch.hearc.cours.gui.layout.mix.component.ongletTest.atom.JPanelRemove;

public class JPanelOnglet extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelOnglet()
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
		jPanelOnglet1 = new JPanelOnglet1();
		jPanelOnglet2 = new JPanelOnglet2();

		jTabbedPane = new JTabbedPane(SwingConstants.BOTTOM);
		jTabbedPane.addTab("onglet1", jPanelOnglet1);
		jTabbedPane.addTab("onglet2", jPanelOnglet2);

		this.jPanelRemove1 =  new JPanelRemove(jTabbedPane,"Onglet1");
		this.jPanelRemove2 =  new JPanelRemove(jTabbedPane,"Onglet2");

		jTabbedPane.setTabComponentAt(0, jPanelRemove1);
		jTabbedPane.setTabComponentAt(1, jPanelRemove2);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			}

		// JComponent : add
		add(jTabbedPane, BorderLayout.CENTER);
		}

	private void control()
		{
		//rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JTabbedPane jTabbedPane;
	private JPanelOnglet1 jPanelOnglet1;
	private JPanelOnglet2 jPanelOnglet2;
	private JPanelRemove jPanelRemove1;
	private JPanelRemove jPanelRemove2;
	}
