
package ch.hearc.cours.gui.listener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameListener extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameListener()
		{

		geometrie();
		controle();
		apparence();

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

	private void geometrie()
		{
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		bouton = new JButton("bouton");
		label = new JLabel("label");

		add(bouton);
		add(label);
		}

	private void controle()
		{
		//setDefaultCloseOperation(EXIT_ON_CLOSE); customisé dans abonnementFermetureFenetre();

		abonnementRedimensionnementFenetre();
		abonnementFermetureFenetre();
		abonnementClick();
		}

	private void apparence()
		{
		setLocationRelativeTo(null);
		setTitle("ListenerTraining");
		setSize(500, 500);

		setVisible(true);
		}

	private void abonnementRedimensionnementFenetre()
		{
		getContentPane().addComponentListener(new ComponentAdapter()
			{

			@Override
			public void componentResized(ComponentEvent e)
				{
				System.out.println(e.getComponent().getSize());
				}

			});

		}

	private void abonnementFermetureFenetre()
		{
		//remplace setDefaultCloseOperation
		this.addWindowListener(new WindowAdapter()
			{

			@Override
			public void windowClosing(WindowEvent e)
				{
				//sauvegarder data,...
				System.exit(0); // 0 normal, -1 anormal
				}
			});

		}

	private void abonnementClick()
		{
		label.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				System.out.println(e.getPoint());
				}
			});

		bouton.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				System.out.println(e.getPoint());
				}
			});

		getContentPane().addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				System.out.println(e.getPoint());
				}
			});

		bouton.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				System.out.println(((JButton)e.getSource()).getText());
				}
			});

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JButton bouton;
	private JLabel label;

	}
