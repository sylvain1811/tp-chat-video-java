
package ch.hearc.cours.gui.hello.entrainement1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameEntrainement extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameEntrainement(int nbBoutons)
		{
		this.nbBoutons = nbBoutons;
		geometry();
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

	private void geometry()
		{
		setLayout(new FlowLayout(FlowLayout.CENTER));

		tabBoutons = new JButton[nbBoutons];
		for(int i = 0; i < nbBoutons; i++)
			{
			tabBoutons[i] = new JButton();
			tabBoutons[i].setText("Bouton" + (i + 1));
			add(tabBoutons[i]);
			}
		}

	private void controle()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ActionListener listener = createActionListener();
		for(JButton bouton:tabBoutons)
			{
			bouton.addActionListener(listener);
			}

		getContentPane().addComponentListener(new ComponentAdapter() //classe interne anonyme qui derive componentAdapter et qui implement indirectement componentListener
			{

			@Override
			public void componentResized(ComponentEvent e)
				{
				JPanel source = (JPanel)e.getSource();
				System.out.println("Hauteur: " + source.getHeight() + " Largeur: " + source.getWidth());
				}

			});

		}

	private void apparence()
		{
		setTitle("Devoirs JFrame");
		setSize(500, 500);
		setLocationRelativeTo(null);
		apparenceBouton();

		setVisible(true);
		}

	private void apparenceBouton()
		{
		for(JButton bouton:tabBoutons)
			{
			bouton.setBackground(Color.GREEN);
			bouton.setForeground(Color.WHITE);
			bouton.setToolTipText(bouton.getText());
			}
		}

	private ActionListener createActionListener()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JButton source = (JButton)e.getSource(); //getSource(), méthode à connaître !!!
				System.out.println(source.getText());
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private int nbBoutons;

	//tools
	private JButton[] tabBoutons;

	}
