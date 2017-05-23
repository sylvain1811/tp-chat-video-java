
package ch.hearc.cours.gui.hello.entrainement3.v2;

import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class JFrameComponent extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameComponent(JComponent[] tabJComponent, Point location)
		{
		this.tabJComponent = tabJComponent;
		this.location = location;

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
		// Layout : Specification
			{
			FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowLayout);
			}

		// JComponent : add
		for(JComponent jComponent:tabJComponent)
			{
			add(jComponent);
			}
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 400);
		setLocation(location);
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private JComponent[] tabJComponent;
	private Point location;
	}
