package ch.hearc.chatvideo.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

		//Panel du Chat
		jPanelChat = new JPanelChat();

		//Labels
		labelIpAdressDist = new JLabel("Adresse IP distante");
		labelIpAdressLocal = new JLabel("Votre adresse IP : ");
		labelPseudo = new JLabel("Votre pseudo");

		//TextField
		textInputIpAdressDist = new JTextField();
		textInputPseudo = new JTextField();

		//Button
		buttonConnexion = new JButton("Connexion");


		// Layout : Specification
			{
			GridLayout gridlayout =  new GridLayout(0,2);
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
				jPanelPrincipal.remove(JPanelConfig.this);
				jPanelPrincipal.add(jPanelChat);
				jPanelPrincipal.setSize(jPanelChat.getSize());
				jPanelPrincipal.setJFramePrincipaleSize(jPanelChat.getSize());
				jPanelPrincipal.repaintJFramePrincipale();
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
	private JPanelChat jPanelChat;
	private JLabel labelIpAdressDist;
	private JLabel labelPseudo;
	private JLabel labelIpAdressLocal;
	private JTextField textInputIpAdressDist;
	private JTextField textInputPseudo;
	private JButton buttonConnexion;

	}
