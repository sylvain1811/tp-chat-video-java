
package ch.hearc.cours.gui.hello;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameHello extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameHello()
		{
		geometry();
		controle();
		apparence();
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

	private void apparence()
		{
		setTitle("Hello");
		setSize(250, 250);
		setLocationRelativeTo(null);

		label1.setForeground(Color.RED);
		label1.setOpaque(true);
		label1.setBackground(Color.GREEN);
		label1.setToolTipText("notre premier label");

		getContentPane().setBackground(Color.PINK);

		setVisible(true);//forcément être la dernière instruction
		}

	private void controle()
		{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//v1
		//			{
		//			getContentPane().addMouseListener(new MouseAdapterPerso()
		//				{
		//
		//				@Override
		//				public void mouseClicked(MouseEvent e)
		//					{
		//					System.out.println(e.getPoint());
		//					}
		//				});
		//			}

		//v2
			{
			getContentPane().addMouseListener(new MouseAdapter()
				{

				@Override
				public void mouseClicked(MouseEvent e)
					{
					System.out.println(e.getPoint());
					}
				});
			}

		}

	private void geometry()
		{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		label1 = new JLabel("Test xxx yyy zzz ttt colin da costa pedro");
		label2 = new JLabel("Test en allemand parce que c'est long 2");

		//v1 : version full
		//			{
		//			getContentPane().add(label);
		//			}

		//v2 : raccourci sémantique
			{
			add(label1);
			add(label2);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JLabel label1;
	private JLabel label2;

	}
