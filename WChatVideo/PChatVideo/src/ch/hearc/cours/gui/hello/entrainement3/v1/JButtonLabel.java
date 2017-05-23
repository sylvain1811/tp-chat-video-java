
package ch.hearc.cours.gui.hello.entrainement3.v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class JButtonLabel extends JButton
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JButtonLabel(JLabel label, String titre)
		{
		super(titre);
		this.label = label;

		compteur = 0;

		controle();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void controle()
		{
		addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				compteur++;
				label.setText(RIEN + compteur);
				}
			});

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private JLabel label;

	//tools
	private int compteur;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final String RIEN = "";
	}
