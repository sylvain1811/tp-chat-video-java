
package ch.hearc.chatvideo.tools;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class JPanelDecorator extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelDecorator(JComponent component, int marge)
		{
		this.component = component;
		this.marge = marge;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		jPanelEst = new JPanelFixe(marge);
		jPanelOuest = new JPanelFixe(marge);
		jPanelNord = new JPanelFixe(marge);
		jPanelSud = new JPanelFixe(marge);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			borderLayout.setHgap(0);
			borderLayout.setVgap(0);
			}

		// JComponent : add
		add(component, BorderLayout.CENTER);
		add(jPanelEst,BorderLayout.EAST);
		add(jPanelOuest,BorderLayout.WEST);
		add(jPanelNord,BorderLayout.NORTH);
		add(jPanelSud,BorderLayout.SOUTH);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		//rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private JComponent component;
	private int marge;

	// Tools
	private JPanelFixe jPanelNord;
	private JPanelFixe jPanelSud;
	private JPanelFixe jPanelOuest;
	private JPanelFixe jPanelEst;
	}
