
package ch.hearc.chatvideo.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.chatvideo.reseau.Application;

public class JPanelConfig extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelConfig(JPanelPrincipal jPanelPrincipal)
		{
		this.jPanelPrincipal = jPanelPrincipal;
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

		//Labels
		labelIpAdressDist = new JLabel("Adresse IP distante");
		labelIpAdressLocal = new JLabel("Votre adresse IP : ");
		labelPseudo = new JLabel("Votre pseudo");

		//TextField
		textInputIpAdressDist = new JTextField();
		textInputPseudo = new JTextField();

		// TODO Enlever les temp
		textInputIpAdressDist.setText("127.0.0.1");
		textInputPseudo.setText("sylvain");

		//Button
		buttonConnexion = new JButton("Connexion");

		// Layout : Specification
			{
			GridLayout gridlayout = new GridLayout(0, 2);
			setLayout(gridlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(labelIpAdressDist);
		add(textInputIpAdressDist);
		add(labelPseudo);
		add(textInputPseudo);
		add(labelIpAdressLocal);
		add(buttonConnexion);
		}

	private void control()
		{
		buttonConnexion.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// Remplace le panel config par le panel chat (contenant chat texte et les vidéos)
				jPanelPrincipal.remove(JPanelConfig.this);

				JPanelChat.init(textInputPseudo.getText());

				jPanelPrincipal.add(JPanelChat.getInstance());
				jPanelPrincipal.setSize(JPanelChat.getInstance().getSize());
				jPanelPrincipal.setJFramePrincipaleSize(JPanelChat.getInstance().getSize());
				jPanelPrincipal.repaintJFramePrincipale();

				// Lancement de l'Application (la partie réseau)
				Application.init(textInputIpAdressDist.getText());
				new Thread(Application.getInstance()).start();

				// Lancement de la partie webcam
				// new Thread(new ImageWorker()).start();
				}
			});
		}

	private void appearance()
		{
		setSize(350, 150);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private JPanelPrincipal jPanelPrincipal;

	// Tools
	private JLabel labelIpAdressDist;
	private JLabel labelPseudo;
	private JLabel labelIpAdressLocal;
	private JTextField textInputIpAdressDist;
	private JTextField textInputPseudo;
	private JButton buttonConnexion;

	}
