
package ch.hearc.cours.gui.dynamique;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameDynamique extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameDynamique()
		{
		isLabelAdded = true;

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
		button = new JButton("Remove/add label");
		label = new JLabel("label");

		// Layout : Specification
			{
			FlowLayout flowLayout = new FlowLayout();
			setLayout(flowLayout);
			}

		// JComponent : add
		add(button);
		add(label);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		button.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				switchState();
				}

			});
		}

	private void appearance()
		{
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	private void switchState()
		{
		if (isLabelAdded)
			{
			remove(label);
			}
		else
			{
			add(label);
			}

		validate(); // Redemande au layout de tout recalculer taille et position
		revalidate();
		repaint(); // redessine la fenetre

		isLabelAdded = !isLabelAdded;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton button;
	private JLabel label;
	private boolean isLabelAdded;
	}
