
package ch.hearc.cours.gui.layout.mix.component.split;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import ch.hearc.cours.gui.layout.mix.component.split.atom.JPanelBas;
import ch.hearc.cours.gui.layout.mix.component.split.atom.JPanelHaut;

public class JPanelSplit extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelSplit()
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
		jPanelHaut = new JPanelHaut();
		jPanelBas = new JPanelBas();

		jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jSplitPane.setDividerLocation(100);
		jSplitPane.setOneTouchExpandable(true);
		jSplitPane.setTopComponent(jPanelHaut);
		jSplitPane.setBottomComponent(jPanelBas);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);
			}

		// JComponent : add
		add(jSplitPane, BorderLayout.CENTER);
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
	private JSplitPane jSplitPane;
	private JPanelHaut jPanelHaut;
	private JPanelBas jPanelBas;

	}
