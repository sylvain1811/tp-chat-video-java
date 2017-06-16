
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Assert;

import ch.hearc.chatvideo.reseau.Application;
import ch.hearc.chatvideo.tools.StringCrypter;
import ch.hearc.chatvideo.video.JPanelWebcam;
import ch.hearc.chatvideo.video.WebcamWorker;

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
		System.exit(0); // 0 normal, -1 anormal
		// TODO Sysexit quand ok appuyé.
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized void init(String pseudo, WebcamWorker webcamWorker)
		{
		JPanelChat.pseudo = pseudo;
		JPanelChat.webcamWorker = webcamWorker;
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
		jPanelWebcams.setBackground(Color.WHITE);

		jPanelVideoChat = new JPanel();
		jPanelVideoChat.setBackground(Color.WHITE);
		jPanelVideoChat.setLayout(new BorderLayout());

		jPanelWebcamDist = new JPanelWebcam();
		//jPanelWebcamDist.setPreferredSize(new Dimension(500, 300));
		jPanelWebcamDist.add(new JLabel("Webcam correspondant"));
		jPanelWebcamDist.setBackground(Color.WHITE);

		jPanelWebcamLocal = new JPanelWebcam();
		//jPanelWebcamLocal.setPreferredSize(new Dimension(500, 300));
		jPanelWebcamLocal.add(new JLabel("Ma webcam"));
		jPanelWebcamLocal.setBackground(Color.WHITE);

		jPanelTextChat = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(20);
		jPanelTextChat.setLayout(borderLayout);
		jPanelTextChat.setBackground(Color.WHITE);

		sendButton = new JButton();
		URL url = JPanelChat.class.getResource("/sendButton.png");
		sendButton.setIcon(new ImageIcon(url));

		sendButton.setBorder(BorderFactory.createEmptyBorder());
		sendButton.setContentAreaFilled(false);

		chatHistory = new JTextArea();
		chatHistory.setFocusable(false);
		//chatHistory.setLineWrap(true); bonne idée mais bloque la taille du textarea
		chatHistory.setWrapStyleWord(true);
		chatHistory.setFont(chatHistory.getFont().deriveFont(18f));
		messageInput = new JTextField();
		messageInput.setFont(messageInput.getFont().deriveFont(18f));

		GridLayout gridLayout = new GridLayout(0, 1);

		jPanelWebcams.setLayout(gridLayout);
		jPanelWebcams.add(jPanelWebcamLocal);
		jPanelWebcams.add(jPanelWebcamDist);

		jPanelControleWebcam = new JPanel();
		jPanelControleWebcam.setLayout(new FlowLayout());

		buttonGriser = new JButton();
		url = JPanelChat.class.getResource("/colorChange.png");
		buttonGriser.setIcon(new ImageIcon(url));
		buttonGriser.setBorder(BorderFactory.createEmptyBorder());
		buttonGriser.setContentAreaFilled(false);

		buttonMirroir = new JButton();
		url = JPanelChat.class.getResource("/mirrorBouton.png");
		buttonMirroir.setIcon(new ImageIcon(url));

		buttonMirroir.setBorder(BorderFactory.createEmptyBorder());
		buttonMirroir.setContentAreaFilled(false);

		buttonSnapShot = new JButton();
		url = JPanelChat.class.getResource("/boutonSnapShot.png");
		buttonSnapShot.setIcon(new ImageIcon(url));

		buttonSnapShot.setBorder(BorderFactory.createEmptyBorder());
		buttonSnapShot.setContentAreaFilled(false);

		buttonToggleVideo = new JButton();
		url = JPanelChat.class.getResource("/boutonToggleVideo.png");
		buttonToggleVideo.setIcon(new ImageIcon(url));

		buttonToggleVideo.setBorder(BorderFactory.createEmptyBorder());
		buttonToggleVideo.setContentAreaFilled(false);

		jPanelControleWebcam.add(buttonGriser);
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(buttonMirroir);
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(buttonSnapShot);
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(Box.createHorizontalGlue());
		jPanelControleWebcam.add(buttonToggleVideo);
		jPanelControleWebcam.setBackground(Color.WHITE);

		jPanelVideoChat.add(jPanelWebcams, BorderLayout.CENTER);
		jPanelVideoChat.add(jPanelControleWebcam, BorderLayout.SOUTH);

		jPanelSaisie = new JPanel();
		jPanelSaisie.setLayout(new BorderLayout());
		jPanelSaisie.add(messageInput, BorderLayout.CENTER);
		jPanelSaisie.add(sendButton, BorderLayout.EAST);
		jPanelSaisie.setBackground(Color.WHITE);

		JScrollPane jScrollPane = new JScrollPane(chatHistory);
		jScrollPane.setBorder(null);

		jPanelTextChat.add(jScrollPane, BorderLayout.CENTER);
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

		buttonGriser.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				isBlack = !isBlack;
				URL url = null;
				if (isBlack)
					{
					url = JPanelChat.class.getResource("/colorChangeHover.png");
					}
				else
					{
					url = JPanelChat.class.getResource("/colorChange.png");
					}
				buttonGriser.setIcon(new ImageIcon(url));
				}
			});

		buttonMirroir.addMouseListener(new MouseAdapter()
			{

			URL url = null;

			@Override
			public void mouseEntered(MouseEvent evt)
				{
				url = JPanelConfig.class.getResource("/mirrorBoutonHover.png");
				buttonMirroir.setIcon(new ImageIcon(url));
				}

			@Override
			public void mouseExited(MouseEvent evt)
				{
				url = JPanelConfig.class.getResource("/mirrorBouton.png");
				buttonMirroir.setIcon(new ImageIcon(url));
				}
			});

		buttonToggleVideo.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				isVideo = !isVideo;
				URL url = null;
				if (isVideo)
					{
					url = JPanelChat.class.getResource("/boutonToggleVideo.png");
					}
				else
					{
					url = JPanelChat.class.getResource("/boutonToggleVideoHover.png");
					}
				buttonToggleVideo.setIcon(new ImageIcon(url));
				}
			});

		buttonSnapShot.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				webcamWorker.setRequestImageTrue();
				}
			});

		buttonToggleVideo.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				webcamWorker.changeWebcamStatus();
				}
			});

		buttonSnapShot.addMouseListener(new MouseAdapter()
			{

			URL url = null;

			@Override
			public void mouseEntered(MouseEvent evt)
				{
				url = JPanelConfig.class.getResource("/boutonSnapShotHover.png");
				buttonSnapShot.setIcon(new ImageIcon(url));
				}

			@Override
			public void mouseExited(MouseEvent evt)
				{
				url = JPanelConfig.class.getResource("/boutonSnapShot.png");
				buttonSnapShot.setIcon(new ImageIcon(url));
				}
			});
		}

	private void appearance()
		{
		setSize(1000, 800);
		setBackground(Color.WHITE);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	public static String pseudo = null;
	private static WebcamWorker webcamWorker = null;

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
	private JButton buttonSnapShot;
	private JButton buttonToggleVideo;
	private JSplitPane splitPane;
	private boolean isBlack = false;
	private boolean isVideo = true;

	}
