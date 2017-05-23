
package ch.hearc.cours.advanced.io.reseau.rmi.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ch.hearc.cours.advanced.io.reseau.rmi.horloge.Horloge_I;

public class JFrameSecret extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameSecret(Horloge_I horloge)
		{
		this.horloge = horloge;
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
		label = new JLabel();
		button = new JButton("get horloge");
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(label, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		button.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent arg0)
				{
				try
					{
					label.setText("Time : " + horloge.getTime());
					}
				catch (RemoteException e)
					{
					e.printStackTrace();
					}
				}
			});
		}

	private void appearance()
		{
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private Horloge_I horloge;
	// Tools
	private JLabel label;
	private JButton button;
	}
