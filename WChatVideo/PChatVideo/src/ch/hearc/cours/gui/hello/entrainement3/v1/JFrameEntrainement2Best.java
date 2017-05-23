
package ch.hearc.cours.gui.hello.entrainement3.v1;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameEntrainement2Best extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameEntrainement2Best(int n)
		{
		this.n = n;
		frameButton = new JFrame("frameButton");
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
		for(int i = 0; i < n; i++)
			{
			JLabel label = new JLabel("0");
			JButtonLabel bouton = new JButtonLabel(label, "click");
			frameButton.add(bouton);
			add(label);
			}

		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		frameButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		}

	private void controle()
		{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //tue jvm quand fenêtre fermée
		frameButton.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void apparence()
		{
		this.setTitle("entrainement2");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null); //centre fenêtre dans l'écran

		frameButton.setTitle("frameButton");
		frameButton.setSize(500, 500);
		frameButton.setLocation(this.getLocation().x - 500, this.getLocation().y);

		frameButton.setVisible(true);
		this.setVisible(true);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//inputs
	private int n;

	//tools
	private JFrame frameButton;
	}
