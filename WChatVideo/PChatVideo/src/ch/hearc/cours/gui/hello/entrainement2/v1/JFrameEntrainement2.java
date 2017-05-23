
package ch.hearc.cours.gui.hello.entrainement2.v1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameEntrainement2 extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameEntrainement2()
		{
		compteur = 0;
		geometrie();
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

	private void geometrie()
		{
		bouton = new JButton("click");
		label = new JLabel("0");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		add(bouton);
		add(label);
		}

	private void controle()
		{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //tue jvm quand fenêtre fermée

		bouton.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				compteur++;
				label.setText(RIEN + compteur);
				}
			});
		}

	private void apparence()
		{
		this.setTitle("entrainement2");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //centre fenêtre dans l'écran

		this.setVisible(true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private int compteur;
	private JButton bouton;
	private JLabel label;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final String RIEN = "";

	}
