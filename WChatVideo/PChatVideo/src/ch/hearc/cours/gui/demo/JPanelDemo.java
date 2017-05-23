
package ch.hearc.cours.gui.demo;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import ch.hearc.cours.gui.tools.JPanelDecorator;

public class JPanelDemo extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelDemo()
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
		jTabbedPane = new JTabbedPane(SwingConstants.TOP);

		jPanelDemoLayoutAtomic = new JPanelDemoLayoutAtomic();
		jPanelDecoratorDemoLayoutAtomic = new JPanelDecorator(jPanelDemoLayoutAtomic, 40);

		jTabbedPane.addTab("demo atomique layout", jPanelDecoratorDemoLayoutAtomic);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jTabbedPane, BorderLayout.CENTER);
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
	private JTabbedPane jTabbedPane;
	private JPanelDemoLayoutAtomic jPanelDemoLayoutAtomic;
	private JPanelDecorator jPanelDecoratorDemoLayoutAtomic;
	}
