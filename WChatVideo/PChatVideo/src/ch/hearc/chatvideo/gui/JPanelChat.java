
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JPanelChat extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelChat()
		{
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

		jPanelVideo = new JPanel();
		jPanelVideo.setPreferredSize(new Dimension(900, 500));

		jPanel1 = new JPanel();
		jPanel1.setPreferredSize(new Dimension(400, 500));
		jPanel1.setBackground(Color.RED);

		jPanel2 = new JPanel();
		jPanel2.setPreferredSize(new Dimension(400, 500));
		jPanel2.setBackground(Color.BLACK);

		jPanelSaisie = new JPanel();

		jPanelHistorique = new JPanel();
		jPanelHistorique.setPreferredSize(new Dimension(900,150));

		chatHistory = new JTextArea("TEST");
		chatHistory.setPreferredSize(jPanelHistorique.getPreferredSize());

		messageInput = new JTextField();
		messageInput.setPreferredSize(new Dimension(150, 25));
		sendButton = new JButton("Envoyer");

		FlowLayout flowLayout1 = new FlowLayout();

		jPanelVideo.setLayout(flowLayout1);
		jPanelVideo.add(jPanel1);
		jPanelVideo.add(jPanel2);

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
		add(jPanelVideo, BorderLayout.NORTH);
		add(jPanelHistorique, BorderLayout.CENTER);
		add(jPanelSaisie, BorderLayout.SOUTH);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		setSize(1000, 800);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanel jPanelVideo;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanelSaisie;
	private JPanel jPanelHistorique;
	private JTextArea chatHistory;
	private JTextField messageInput;
	private JButton sendButton;

	}
