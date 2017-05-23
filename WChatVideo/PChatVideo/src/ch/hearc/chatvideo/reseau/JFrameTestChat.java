
package ch.hearc.chatvideo.reseau;

import java.awt.BorderLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class JFrameTestChat extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameTestChat()
		{

		geometry();
		control();
		appearance();
		// TODO Choisir server name
		try
			{
			PcUser.init(InetAddress.getLocalHost().getHostName());
			}
		catch (UnknownHostException e)
			{
			System.err.println("erreur server name");
			e.printStackTrace();
			}

		this.pcUser = PcUser.getInstance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		new JFrameTestChat();
		}

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
		chat = new JPanelChat();
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		add(chat, BorderLayout.CENTER);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelChat chat;
	private PcUser pcUser;
	}
