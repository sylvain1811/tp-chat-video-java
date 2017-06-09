
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Assert;

import ch.hearc.chatvideo.reseau.Application;
import ch.hearc.chatvideo.tools.StringCrypter;
import ch.hearc.chatvideo.video.JPanelWebcam;

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
		// TODO Afficher un nouveau message (envoyé ou reçu)
		System.out.println("setText called : " + chatHistory.getText() + message);
		chatHistory.setText(chatHistory.getText() + message);
		}

	public synchronized void setImage(BufferedImage bufferedImage)
		{
		// TODO Afficher l'image dans le panel, celui pour la vidéo du user distant.
		this.jPanelWebcamDist.setImage(bufferedImage);
		this.repaint();
		this.revalidate();
		}

	public synchronized void setImageLocal(BufferedImage bufferedImage)
		{
		// TODO Afficher l'image dans le panel, celui pour la webcam local
		this.jPanelWebcamLocal.setImage(bufferedImage);
		this.repaint();
		this.revalidate();
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
			return new JPanelChat();
			}
		else
			{
			return INSTANCE;
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation

		jPanelVideos = new JPanel();
		jPanelVideos.setPreferredSize(new Dimension(1200, 700));

		jPanelWebcamLocal = new JPanelWebcam();
		jPanelWebcamLocal.setPreferredSize(new Dimension(600, 700));
		//jPanelWebcamLocal.setBackground(Color.RED);

		jPanelWebcamDist = new JPanelWebcam();
		jPanelWebcamDist.setPreferredSize(new Dimension(600, 700));
		//jPanelWebcamDist.setBackground(Color.BLACK);

		jPanelSaisie = new JPanel();

		jPanelHistorique = new JPanel();
		jPanelHistorique.setPreferredSize(new Dimension(900, 150));

		chatHistory = new JTextArea("<Empty>");
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
		jPanelSaisie.add(chatHistory);
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
				JPanelChat.this.setText(pseudo + " : " + messageInput.getText() + "\n");
				StringCrypter messageCrypter = new StringCrypter(pseudo + " : " + messageInput.getText() + "\n");
				try
					{
					Application.getInstance().getRemote().setText(messageCrypter);
					}
				catch (RemoteException e1)
					{
					// TODO Traiter erreur remote setText
					e1.printStackTrace();
					}
				finally
					{
					messageInput.setText("");
					}
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
	private JPanelWebcam jPanelWebcamLocal;
	private JPanelWebcam jPanelWebcamDist;
	private JPanel jPanelSaisie;
	private JPanel jPanelHistorique;
	private JTextArea chatHistory;
	private JTextField messageInput;
	private JButton sendButton;

	}
