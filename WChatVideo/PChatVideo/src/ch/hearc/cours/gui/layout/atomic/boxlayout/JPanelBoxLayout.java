
package ch.hearc.cours.gui.layout.atomic.boxlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBoxLayout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBoxLayout()
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
		Box boxHNord = createBoxNord();
		Box boxHSud = createBoxSud();
		Box boxVOuest = createBoxOuest();
		//Box boxCenter = createBoxCenterV1();
		Box boxCenter = createBoxCenterV2();
		boxVEst = createBoxEst();

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(boxCenter, BorderLayout.CENTER);
		add(boxHNord, BorderLayout.NORTH);
		add(boxHSud, BorderLayout.SOUTH);
		add(boxVOuest, BorderLayout.WEST);
		add(boxVEst, BorderLayout.EAST);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// debug
			{
			boxVEst.setBackground(Color.PINK);
			boxVEst.setOpaque(true);
			}
		}

	private Box createBoxCenterV1()
		{
		Box boxH = Box.createHorizontalBox();
		boxH.add(Box.createHorizontalGlue());
		boxH.add(new JButton("Bouton"));
		boxH.add(Box.createHorizontalGlue());

		Box boxV = Box.createVerticalBox();
		boxV.add(Box.createVerticalGlue());
		boxV.add(boxH);
		boxV.add(Box.createVerticalGlue());

		return boxV;
		}

	private Box createBoxCenterV2()
		{
		JButton button = new JButton("Bouton");

		JPanel panelH = new JPanel();
		panelH.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelH.add(button);

		Box boxV = Box.createVerticalBox();
		boxV.add(Box.createVerticalGlue());
		boxV.add(panelH);
		boxV.add(Box.createVerticalGlue());

		panelH.setMaximumSize(button.getMaximumSize());

		//debug
			{
			panelH.setBackground(Color.GREEN);
			boxV.setBackground(Color.BLUE);
			panelH.setOpaque(true);
			boxV.setOpaque(true);
			}

		return boxV;
		}

	private Box createBoxNord()
		{
		Box boxH = Box.createHorizontalBox();

		boxH.add(Box.createHorizontalGlue());
		boxH.add(new JButton("1"));
		boxH.add(new JButton("2"));
		boxH.add(new JButton("3"));
		boxH.add(Box.createHorizontalGlue());
		boxH.add(Box.createHorizontalGlue());

		return boxH;
		}

	private Box createBoxSud()
		{
		Box boxH = Box.createHorizontalBox();

		boxH.add(Box.createHorizontalStrut(20));
		boxH.add(new JButton("1"));
		boxH.add(Box.createHorizontalGlue());
		boxH.add(new JButton("2"));
		boxH.add(Box.createHorizontalGlue());
		boxH.add(new JButton("3"));
		boxH.add(Box.createHorizontalStrut(20));

		return boxH;
		}

	private Box createBoxOuest()
		{
		Box boxV = Box.createVerticalBox();

		boxV.add(Box.createVerticalGlue());
		boxV.add(new JButton("1"));
		boxV.add(Box.createVerticalStrut(20));
		boxV.add(new JButton("2"));

		return boxV;
		}

	private Box createBoxEst()
		{
		Box boxV = Box.createVerticalBox();

		boxV.add(new JButton("1"));
		boxV.add(Box.createVerticalGlue());
		boxV.add(new JButton("2"));
		boxV.add(Box.createVerticalStrut(20));
		boxV.add(new JButton("1"));
		boxV.add(Box.createVerticalGlue());

		return boxV;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Box boxVEst;

	}
