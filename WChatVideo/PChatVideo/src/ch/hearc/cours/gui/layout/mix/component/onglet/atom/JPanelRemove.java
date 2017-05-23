
package ch.hearc.cours.gui.layout.mix.component.onglet.atom;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class JPanelRemove extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelRemove(JTabbedPane tabbedPane, int indexPanel)
		{
		this.tabbedPane = tabbedPane;
		this.indexPanel = indexPanel;
		geometry();
		control();
		appearance();
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void updateIndex(int indiceRemove)
	{
	//parcourir tous les panels removes si leur index est plus petit que indiceRemove, rien faire si il est plus grand décrementer de 1
	//Appeler cette méthode depuis JPanelRemove
	//Récupérer l'adresse avec getSelectedIndex
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
		labelClose = new JLabel("X");
		labelText = new JLabel("Onglet" + indexPanel);
		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(labelText);
		add(labelClose);
		}

	private void control()
		{
		labelClose.addMouseListener(new MouseAdapter()
			{

			@Override
			public void mouseClicked(MouseEvent e)
				{
				tabbedPane.remove(indexPanel);

				}
			});
		}

	private void appearance()
		{
		labelClose.setOpaque(true);
		labelClose.setBackground(Color.PINK);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input
	private JTabbedPane tabbedPane;
	private int indexPanel;

	// Tools
	private JLabel labelClose;
	private JLabel labelText;



	}
