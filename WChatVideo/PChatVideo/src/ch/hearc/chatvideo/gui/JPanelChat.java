
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
import java.rmi.RemoteException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
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
		// TODO Sysexit quand ok appuyé.
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

		jPanelWebcams = new JPanel();
		jPanelWebcams.setPreferredSize(new Dimension(600, 700));

		jPanelVideoChat = new JPanel();
		jPanelVideoChat.setLayout(new BorderLayout());

		jPanelWebcamDist = new JPanelWebcam();
		//jPanelWebcamDist.setPreferredSize(new Dimension(500, 300));
		jPanelWebcamDist.add(new JLabel("Webcam correspondant"));
		jPanelWebcamDist.setBackground(Color.BLACK);

		jPanelWebcamLocal = new JPanelWebcam();
		//jPanelWebcamLocal.setPreferredSize(new Dimension(500, 300));
		jPanelWebcamLocal.add(new JLabel("Ma webcam"));
		jPanelWebcamLocal.setBackground(Color.RED);

		jPanelTextChat = new JPanel();
		jPanelSaisie = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(20);
		jPanelTextChat.setLayout(borderLayout);

		sendButton = new JButton("Envoyer");

		chatHistory = new JTextArea();
		chatHistory.setFocusable(false);
		messageInput = new JTextField();
		messageInput.setPreferredSize(new Dimension(200, 25));

		GridLayout gridLayout = new GridLayout(0, 1);

		jPanelWebcams.setLayout(gridLayout);
		jPanelWebcams.add(jPanelWebcamLocal);
		jPanelWebcams.add(jPanelWebcamDist);

		jPanelControleWebcam = new JPanel();
		jPanelControleWebcam.setLayout(new FlowLayout());

		buttonGriser = new JButton();
		try
			{
			BufferedImage img = ImageIO.read(new File("images\\colorChange.png"));
			buttonGriser.setIcon(new ImageIcon(img));
			}
		catch (Exception ex)
			{
			System.out.println(ex);
			}
		buttonGriser.setBorder(BorderFactory.createEmptyBorder());
		buttonGriser.setContentAreaFilled(false);

		buttonMirroir = new JButton();
		try
			{
			BufferedImage img = ImageIO.read(new File("images\\mirrorBouton.png"));
			buttonMirroir.setIcon(new ImageIcon(img));
			}
		catch (Exception ex)
			{
			System.out.println(ex);
			}

		buttonMirroir.setBorder(BorderFactory.createEmptyBorder());
		buttonMirroir.setContentAreaFilled(false);

		jPanelControleWebcam.add(buttonGriser);
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(buttonMirroir);

		jPanelVideoChat.add(jPanelWebcams, BorderLayout.CENTER);
		jPanelVideoChat.add(jPanelControleWebcam, BorderLayout.SOUTH);

		jPanelSaisie.setLayout(new BorderLayout());
		jPanelSaisie.add(messageInput, BorderLayout.CENTER);
		jPanelSaisie.add(sendButton, BorderLayout.EAST);

		jPanelTextChat.add(chatHistory, BorderLayout.CENTER);
		jPanelTextChat.add(jPanelSaisie, BorderLayout.SOUTH);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanelVideoChat, jPanelTextChat);
		splitPane.setDividerLocation(500);

		// Layout : Specification
			{
			BorderLayout layout = new BorderLayout();
			layout.setHgap(50);
			setLayout(layout);
			}

		// JComponent : add
		add(splitPane, BorderLayout.CENTER);
		//add(jPanelVideoChat, BorderLayout.CENTER);
		//add(jPanelTextChat, BorderLayout.EAST);

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

		messageInput.addKeyListener(new KeyAdapter()
			{

			@Override
			public void keyReleased(KeyEvent e)
				{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
					sendButton.doClick();
					}
				}
			});

		buttonMirroir.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				jPanelWebcamDist.toggleReversed();
				jPanelWebcamLocal.toggleReversed();
				}
			});

		buttonGriser.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				jPanelWebcamDist.toggleGray();
				jPanelWebcamLocal.toggleGray();
				}
			});
		}

	private void appearance()
		{
		setSize(1000, 800);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	// TODO enlever public
	public static String pseudo = null;

	// Tools
	private static JPanelChat INSTANCE = null;
	private JPanel jPanelWebcams;
	private JPanelWebcam jPanelWebcamLocal;
	private JPanelWebcam jPanelWebcamDist;
	private JPanel jPanelVideoChat;
	private JPanel jPanelSaisie;
	private JPanel jPanelTextChat;
	private JPanel jPanelControleWebcam;
	private JTextArea chatHistory;
	private JTextField messageInput;
	private JButton sendButton;
	private JButton buttonMirroir;
	private JButton buttonGriser;
	private JSplitPane splitPane;

	}
