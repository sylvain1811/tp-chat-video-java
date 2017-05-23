
package ch.hearc.cours.gui.layout.mix.component.ongletTest.atom;

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

	public JPanelRemove(JTabbedPane tabbedPane, String titre)
		{
		this.tabbedPane = tabbedPane;
		this.titre = titre;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		labelClose = new JLabel("O");
		labelText = new JLabel(titre);
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
				int idx = tabbedPane.indexOfTabComponent(JPanelRemove.this);
				tabbedPane.remove(idx);
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
	private String titre;

	// Tools
	private JLabel labelClose;
	private JLabel labelText;


	}
