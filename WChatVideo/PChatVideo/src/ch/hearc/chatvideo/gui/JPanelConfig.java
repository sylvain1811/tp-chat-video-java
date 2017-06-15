
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.hearc.chatvideo.reseau.Application;
import ch.hearc.chatvideo.tools.JPanelDecorator;
import ch.hearc.chatvideo.video.WebcamCustomDiscoveryListener;
import ch.hearc.chatvideo.video.WebcamWorker;

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
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Charge les properties. Accès au disque dans thread séparé pour une UI chargée plus vite.
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
					System.out.println("Pas de fichiers de config trouvé");
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

				// TODO S'assurer que les components soient déjà créer
				JPanelConfig.this.textInputIpAdressDist.setText(addresseIpDistanteProperty);
				JPanelConfig.this.textInputPseudo.setText(pseudoProperty);
				}
			});

		load.start();
		}

	/**
	 * Store les inputs pour la prochaine utilisation.
	 * Non bloquant car thread séparé.
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
		panelInput.setBackground(Color.WHITE);
		GridLayout gridInput = new GridLayout(0, 2);
		gridInput.setVgap(20);
		panelInput.setLayout(gridInput);

		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(Color.WHITE);
		FlowLayout flowLayout = new FlowLayout();
		panelLogo.setLayout(flowLayout);

		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(Color.WHITE);
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(20);
		panelBottom.setLayout(borderLayout);

		//Labels
		labelIpAdressDist = new JLabel("Adresse IP distante");
		labelIpAdressLocal = new JLabel("Votre adresse IP : " + Application.getIp());
		labelPseudo = new JLabel("Votre pseudo");
		logo = new JLabel();

		//TextField
		textInputIpAdressDist = new JTextField();
		textInputPseudo = new JTextField();

		//Image
		try
			{
			BufferedImage img = ImageIO.read(new File("images\\videoIcon.png"));
			logo.setIcon(new ImageIcon(img));
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}

		//Button
		buttonConnexion = new JButton();
		try
			{
			BufferedImage img = ImageIO.read(new File("images\\boutonConnexion.png"));
			buttonConnexion.setIcon(new ImageIcon(img));
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		buttonConnexion.setBorder(BorderFactory.createEmptyBorder());
		buttonConnexion.setContentAreaFilled(false);

		// Layout : Specification
			{
			BorderLayout borderlayout = new BorderLayout(0, 1);
			setLayout(borderlayout);

			borderlayout.setVgap(20);
			}

		panelLogo.add(logo);

		panelBottom.add(labelIpAdressLocal, BorderLayout.NORTH);
		panelBottom.add(buttonConnexion, BorderLayout.CENTER);

		panelInput.add(labelIpAdressDist);
		panelInput.add(textInputIpAdressDist);
		panelInput.add(labelPseudo);
		panelInput.add(textInputPseudo);

		// JComponent : add
		add(panelLogo, BorderLayout.NORTH);
		add(panelInput, BorderLayout.CENTER);
		add(panelBottom, BorderLayout.SOUTH);
		}

	private void control()
		{
		buttonConnexion.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				// Store les données pour prochain lancement
				storeProperties();

				// Remplace le panel config par le panel chat (contenant chat texte et les vidéos)
				jPanelPrincipal.removeAll();

				JPanelChat.init(textInputPseudo.getText());

				JPanelDecorator jPanelDecorator = new JPanelDecorator(JPanelChat.getInstance(), 30);

				jPanelPrincipal.add(jPanelDecorator, BorderLayout.CENTER);
				jPanelPrincipal.setSize(JPanelChat.getInstance().getSize());
				jPanelPrincipal.setJFramePrincipaleSize(JPanelChat.getInstance().getSize());
				jPanelPrincipal.repaintJFramePrincipale();

				// Lancement de l'Application (la partie réseau)
				Application.init(textInputIpAdressDist.getText());
				Thread reseauThread = new Thread(Application.getInstance());
				reseauThread.start();

				// Lancement de la partie webcam
				WebcamWorker worker = new WebcamWorker();
				Thread webcamThread = new Thread(worker);
				webcamThread.start();
				new WebcamCustomDiscoveryListener(worker);
				}
			});

		KeyAdapter keyAdapter = new KeyAdapter()
			{

			@Override
			public void keyReleased(KeyEvent e)
				{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
					buttonConnexion.doClick();
					}
				}

			};

		textInputIpAdressDist.addKeyListener(keyAdapter);
		textInputPseudo.addKeyListener(keyAdapter);

		}

	private void appearance()
		{
		setSize(400, 450);
		setMinimumSize(new Dimension(400, 450));
		setBackground(Color.WHITE);
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
	private JLabel logo;
	private JTextField textInputIpAdressDist;
	private JTextField textInputPseudo;
	private JButton buttonConnexion;

	// Properties
	private String addresseIpDistanteProperty;
	private String pseudoProperty;

	}
