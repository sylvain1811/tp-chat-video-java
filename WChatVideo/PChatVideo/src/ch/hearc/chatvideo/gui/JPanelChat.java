
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Assert;

import ch.hearc.chatvideo.reseau.Application;
import ch.hearc.chatvideo.tools.StringCrypter;
import ch.hearc.chatvideo.video.CustomWebcam;
import ch.hearc.chatvideo.video.JPanelWebcamDist;
import ch.hearc.chatvideo.video.JPanelWebcamLocal;

/*---------------------------------------------------------------*\
|*							SINGLETON							 *|
\*---------------------------------------------------------------*/

public class JPanelChat extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private JPanelChat()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public synchronized void setText(String message)
		{
		chatHistory.setText(chatHistory.getText() + message);
		}

	public synchronized void setImage(BufferedImage bufferedImage)
		{
		this.jPanelWebcamDist.setImage(bufferedImage);
		}

	public synchronized void setImageLocal(BufferedImage bufferedImage)
		{
		this.jPanelWebcamLocal.setImage(bufferedImage);
		}

	public synchronized void traiterErreurReseau()
		{
		// Affiche un message et indique que la remote est déconnectée
		JOptionPane.showMessageDialog(this, "Une déconnexion est apparue.", "Erreur", JOptionPane.ERROR_MESSAGE);
		Application.getInstance().setConnected(false);
		// TODO Retour au menu de connexion
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized void init(String pseudo)
		{
		JPanelChat.pseudo = pseudo;
		}

	public static synchronized JPanelChat getInstance()
		{
		Assert.assertTrue(pseudo != null);
		if (INSTANCE == null)
			{
			INSTANCE = new JPanelChat();
			}
		return INSTANCE;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation

		jPanelVideos = new JPanel();
		jPanelVideos.setPreferredSize(new Dimension(1200, 700));

		jPanelWebcamLocal = CustomWebcam.createWebcamPanel();
		jPanelWebcamLocal.setPreferredSize(new Dimension(600, 300));
		//jPanelWebcamLocal.setBackground(Color.RED);

		jPanelWebcamDist = new JPanelWebcamDist();
		jPanelWebcamDist.setPreferredSize(new Dimension(600, 300));
		jPanelWebcamDist.setBackground(Color.BLUE);
		//jPanelWebcamDist.setBackground(Color.BLACK);

		jPanelSaisie = new JPanel();

		jPanelHistorique = new JPanel();
		jPanelHistorique.setPreferredSize(new Dimension(900, 150));

		chatHistory = new JTextArea();
		chatHistory.setPreferredSize(jPanelHistorique.getPreferredSize());

		messageInput = new JTextField();
		messageInput.setPreferredSize(new Dimension(150, 25));
		sendButton = new JButton("Envoyer");

		FlowLayout flowLayout1 = new FlowLayout();

		jPanelVideos.setLayout(flowLayout1);
		jPanelVideos.add(jPanelWebcamLocal);
		jPanelVideos.add(jPanelWebcamDist);

		FlowLayout flowLayout2 = new FlowLayout();

		jPanelSaisie.setLayout(flowLayout2);
		jPanelSaisie.add(messageInput);
		jPanelSaisie.add(sendButton);

		FlowLayout flowLayout3 = new FlowLayout();
		jPanelHistorique.setLayout(flowLayout3);
		jPanelHistorique.add(chatHistory);

		// Layout : Specification
			{
			BorderLayout layout = new BorderLayout();
			setLayout(layout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(jPanelVideos, BorderLayout.NORTH);
		add(jPanelHistorique, BorderLayout.CENTER);
		add(jPanelSaisie, BorderLayout.SOUTH);

		}

	private void control()
		{
		sendButton.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				final String newMessage = messageInput.getText();

				JPanelChat.getInstance().setText(pseudo + " : " + newMessage + "\n");
				Thread sendMessage = new Thread(new Runnable()
					{

					@Override
					public void run()
						{
						StringCrypter messageCrypter = new StringCrypter(pseudo + " : " + newMessage + "\n");
						try
							{
							if (Application.getInstance().getRemote() != null)
								{
								Application.getInstance().getRemote().setText(messageCrypter);
								}
							}
						catch (RemoteException e1)
							{
							// TODO Traiter erreur remote setText
							JPanelChat.getInstance().traiterErreurReseau();
							e1.printStackTrace();
							}
						}
					});

				sendMessage.start();
				messageInput.setText("");
				}
			});
		}

	private void appearance()
		{
		setSize(1300, 1000);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	// TODO enlever public
	public static String pseudo = null;

	// Tools
	private static JPanelChat INSTANCE = null;
	private JPanel jPanelVideos;
	private JPanelWebcamLocal jPanelWebcamLocal;
	private JPanelWebcamDist jPanelWebcamDist;
	private JPanel jPanelSaisie;
	private JPanel jPanelHistorique;
	private JTextArea chatHistory;
	private JTextField messageInput;
	private JButton sendButton;

	}
