
package ch.hearc.cours.gui.demo;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import ch.hearc.cours.gui.layout.atomic.borderlayout.JPanelBorderLayout;
import ch.hearc.cours.gui.layout.atomic.boxlayout.JPanelBoxLayout;
import ch.hearc.cours.gui.layout.atomic.flowlayout.JPanelFlowLayout;
import ch.hearc.cours.gui.layout.atomic.gridlayout.JPanelGridLayout;
import ch.hearc.cours.gui.layout.atomic.nullLayout.JPanelNullLayout;
import ch.hearc.cours.gui.tools.JPanelDecorator;

public class JPanelDemoLayoutAtomic extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelDemoLayoutAtomic()
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
		jPanelBorderLayout = new JPanelBorderLayout();
		jPanelBoxLayout = new JPanelBoxLayout();
		jPanelFlowLayout = new JPanelFlowLayout();
		jPanelGridLayout = new JPanelGridLayout();
		jPanelNullLayout = new JPanelNullLayout();

		jpanelDecoratorBorder = new JPanelDecorator(jPanelBorderLayout, MARGE);
		jpanelDecoratorBox = new JPanelDecorator(jPanelBoxLayout, MARGE);
		jpanelDecoratorFlow = new JPanelDecorator(jPanelFlowLayout, MARGE);
		jpanelDecoratorGrid = new JPanelDecorator(jPanelGridLayout, MARGE);
		jpanelDecoratorNull = new JPanelDecorator(jPanelNullLayout, MARGE);

		// Layout : Specification
			{
			GridLayout gridLayout = new GridLayout(0, 3);
			setLayout(gridLayout);

			gridLayout.setHgap(50);
			gridLayout.setVgap(50);

			}

		// JComponent : add
		add(jpanelDecoratorBorder);
		add(jpanelDecoratorBox);
		add(jpanelDecoratorFlow);
		add(jpanelDecoratorGrid);
		add(jpanelDecoratorNull);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		jpanelDecoratorBorder.setBorder(BorderFactory.createTitledBorder("BorderLayout"));
		jpanelDecoratorBox.setBorder(BorderFactory.createTitledBorder("BoxLayout"));
		jpanelDecoratorFlow.setBorder(BorderFactory.createTitledBorder("FlowLayout"));
		jpanelDecoratorGrid.setBorder(BorderFactory.createTitledBorder("GridLayout"));
		jpanelDecoratorNull.setBorder(BorderFactory.createTitledBorder("NullLayout"));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelBorderLayout jPanelBorderLayout;
	private JPanelBoxLayout jPanelBoxLayout;
	private JPanelFlowLayout jPanelFlowLayout;
	private JPanelGridLayout jPanelGridLayout;
	private JPanelNullLayout jPanelNullLayout;

	private JPanelDecorator jpanelDecoratorBorder;
	private JPanelDecorator jpanelDecoratorBox;
	private JPanelDecorator jpanelDecoratorFlow;
	private JPanelDecorator jpanelDecoratorGrid;
	private JPanelDecorator jpanelDecoratorNull;


	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int MARGE = 10;
	}
