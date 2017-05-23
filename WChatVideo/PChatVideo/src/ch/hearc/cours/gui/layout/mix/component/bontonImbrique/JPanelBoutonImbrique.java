
package ch.hearc.cours.gui.layout.mix.component.bontonImbrique;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelBoutonImbrique extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBoutonImbrique()
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
		boutonExtern = new JButton("extern");
		boutonIntern = new JButton("intern");

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		// JComponent : add
		boutonExtern.add(boutonIntern);//Va au centre et gonfle car le borderLayout est le layout par défault d'une JFrame, et par défault ça va au centre.
		add(boutonExtern);
		}

	private void control()
		{
		ActionListener actionListener = new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JButton source = (JButton)e.getSource();
				System.out.println(source.getText());
				}
			};

		boutonExtern.addActionListener(actionListener);
		boutonIntern.addActionListener(actionListener);
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton boutonIntern;
	private JButton boutonExtern;
	}
