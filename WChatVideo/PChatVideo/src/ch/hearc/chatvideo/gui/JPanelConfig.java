
package ch.hearc.chatvideo.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.chatvideo.reseau.Application;
import ch.hearc.chatvideo.video.ImageWorker;

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
		loadProperties();
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

	/**
	 * Charge les properties. Acc�s au disque dans thread s�par� pour une UI charg�e plus vite.
	 */
	private void loadProperties()
		{
		Thread load = new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				Properties properties = new Properties();
				FileInputStream fileInputStream = null;
				try
					{
					fileInputStream = new FileInputStream(new File("configChatVideo.properties"));
					properties.load(fileInputStream);
					JPanelConfig.this.addresseIpDistanteProperty = properties.getProperty("ipdist");
					JPanelConfig.this.pseudoProperty = properties.getProperty("pseudo");
					}
				catch (FileNotFoundException e)
					{
					// TODO File not found
					System.out.println("Pas de fichiers de config trouv�");
					JPanelConfig.this.pseudoProperty = System.getProperty("user.name");
					}
				catch (IOException e)
					{
					// TODO load exception
					e.printStackTrace();
					}
				finally
					{
					if (fileInputStream != null)
						{
						try
							{
							fileInputStream.close();
							}
						catch (IOException e)
							{
							// TODO close exception
							e.printStackTrace();
							}
						}
					}

				// TODO S'assurer que les components soient d�j� cr�er
				JPanelConfig.this.textInputIpAdressDist.setText(addresseIpDistanteProperty);
				JPanelConfig.this.textInputPseudo.setText(pseudoProperty);
				}
			});

		load.start();
		}

	/**
	 * Store les inputs pour la prochaine utilisation.
	 * Non bloquant car thread s�par�.
	 */
	private void storeProperties()
		{
		Thread store = new Thread(new Runnable()
			{

			@Override
			public void run()
				{
				Properties properties = new Properties();
				FileOutputStream fileOutputStream = null;
				try
					{
					fileOutputStream = new FileOutputStream(new File("configChatVideo.properties"));
					properties.setProperty("pseudo", textInputPseudo.getText());
					properties.setProperty("ipdist", textInputIpAdressDist.getText());
					properties.store(fileOutputStream, "Created on " + new Date(System.currentTimeMillis()));
					}
				catch (FileNotFoundException e1)
					{
					// TODO File not found
					e1.printStackTrace();
					}
				catch (IOException e1)
					{
					// TODO Erreur store
					e1.printStackTrace();
					}
				finally
					{
					if (fileOutputStream != null)
						{
						try
							{
							fileOutputStream.close();
							}
						catch (IOException e1)
							{
							// TODO Erreur close()
							e1.printStackTrace();
							}
						}
					}
				}
			});

		store.start();
		}

	private void geometry()
		{
		// JComponent : Instanciation

		// JPanels
		JPanel panelInput = new JPanel();
		GridLayout gridInput = new GridLayout(0, 2);
		gridInput.setHgap(20);
		panelInput.setLayout(gridInput);

		//Labels
		labelIpAdressDist = new JLabel("Adresse IP distante");
		labelIpAdressLocal = new JLabel("Votre adresse IP : " + Application.getIp().substring(1));
		labelPseudo = new JLabel("Votre pseudo");

		//TextField
		textInputIpAdressDist = new JTextField();
		textInputPseudo = new JTextField();

		//Button
		buttonConnexion = new JButton("Connexion");

		// Layout : Specification
			{
			GridLayout gridlayout = new GridLayout(0, 1);
			setLayout(gridlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			gridlayout.setHgap(20);
			}

		// JComponent : add
		panelInput.add(labelIpAdressDist);
		panelInput.add(textInputIpAdressDist);
		panelInput.add(labelPseudo);
		panelInput.add(textInputPseudo);
		add(panelInput);
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
				// Store les donn�es pour prochain lancement
				storeProperties();

				// Remplace le panel config par le panel chat (contenant chat texte et les vid�os)
				jPanelPrincipal.remove(JPanelConfig.this);

				JPanelChat.init(textInputPseudo.getText());

				jPanelPrincipal.add(JPanelChat.getInstance());
				jPanelPrincipal.setSize(JPanelChat.getInstance().getSize());
				jPanelPrincipal.setJFramePrincipaleSize(JPanelChat.getInstance().getSize());
				jPanelPrincipal.repaintJFramePrincipale();

				// Lancement de l'Application (la partie r�seau)
				Application.init(textInputIpAdressDist.getText());
				Thread reseauThread = new Thread(Application.getInstance());
				reseauThread.start();

				// Lancement de la partie webcam
				Thread webcamThread = new Thread(new ImageWorker());
				webcamThread.start();
				}
			});
		}

	private void appearance()
		{
		setSize(350, 180);
		setMinimumSize(new Dimension(350, 180));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JPanelPrincipal jPanelPrincipal;

	// Tools
	private JLabel labelIpAdressDist;
	private JLabel labelPseudo;
	private JLabel labelIpAdressLocal;
	private JTextField textInputIpAdressDist;
	private JTextField textInputPseudo;
	private JButton buttonConnexion;

	// Properties
	private String addresseIpDistanteProperty;
	private String pseudoProperty;

	}
