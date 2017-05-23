
package ch.hearc.cours.gui.java2D.affineTransformMieu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.junit.Assert;

public class JPanelControl extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelControl(JPanelSalleConf jpanelSalleConf)
		{
		this.jpanelSalleConf = jpanelSalleConf;
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
		this.btnStart = new JButton("Start");
		this.btnStop = new JButton("Stop");

		this.sliderStepAlphaAnimation = new JSlider(SwingConstants.HORIZONTAL, 5, 3000, 100); // min,max,current
		this.jpanelSalleConf.setDAlphaAnimation(2 * Math.PI / this.sliderStepAlphaAnimation.getValue());

		SpinnerModel spinnerModel = new SpinnerNumberModel(50L, 1L, 1000L, 1L); //value,min,max,step
		this.spinnerTimeSelect = new JSpinner(spinnerModel);
		this.jpanelSalleConf.setSleepTime(((Number)this.spinnerTimeSelect.getValue()).longValue());

		this.btnSensH = new JRadioButton("Horaire");
		this.btnSensA = new JRadioButton("Anti-Horaire");

		this.sensChoice = new ButtonGroup();
		this.sensChoice.add(this.btnSensH);
		this.sensChoice.add(this.btnSensA);

		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);
			flowlayout.setHgap(5);
			flowlayout.setVgap(5);
			}

		// JComponent : add
		this.add(this.btnStart);
		this.add(this.btnStop);
		this.add(this.sliderStepAlphaAnimation);
		this.add(this.spinnerTimeSelect);
		this.add(this.btnSensH);
		this.add(this.btnSensA);
		}

	private void control()
		{
		this.btnStart.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				switchState();
				jpanelSalleConf.start();
				}
			});

		this.btnStop.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				switchState();
				jpanelSalleConf.stop();
				}
			});

		this.sliderStepAlphaAnimation.addChangeListener(new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				JSlider slider = (JSlider)e.getSource();
				JPanelControl.this.jpanelSalleConf.setDAlphaAnimation(2 * Math.PI / slider.getValue());
				}
			});

		this.spinnerTimeSelect.addChangeListener(new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				JSpinner spiner = (JSpinner)e.getSource();
				JPanelControl.this.jpanelSalleConf.setSleepTime(((Number)spiner.getValue()).longValue());
				}
			});

		ActionListener sensButton = new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JRadioButton source = (JRadioButton)e.getSource();

				JPanelControl.this.jpanelSalleConf.setRotateSens(rotationSens(source));
				}

			private RotationSens rotationSens(JRadioButton source)
				{
				if (source == btnSensH)
					{
					return RotationSens.HORAIRE;
					}
				else if (source == btnSensA)
					{
					return RotationSens.ANTIHORAIRE;
					}
				else
					{
					Assert.fail();
					return null;
					}
				}
			};

		this.btnSensH.addActionListener(sensButton);
		this.btnSensA.addActionListener(sensButton);
		}

	private void appearance()
		{
		this.btnStart.setEnabled(true);
		this.btnStop.setEnabled(false);
		this.btnSensH.setSelected(true);
		this.btnSensA.setSelected(false);

		// Slider
			{
			Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
			table.put(5, new JLabel("5"));
			table.put(1000, new JLabel("1K"));
			table.put(2000, new JLabel("2K"));
			table.put(3000, new JLabel("3K"));
			this.sliderStepAlphaAnimation.setLabelTable(table);
			this.sliderStepAlphaAnimation.setPaintTicks(true);
			this.sliderStepAlphaAnimation.setPaintLabels(true);
			}
		}

	private void switchState()
		{
		this.btnStart.setEnabled(!this.btnStart.isEnabled());
		this.btnStop.setEnabled(!this.btnStop.isEnabled());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Input
	private JPanelSalleConf jpanelSalleConf;

	// Tools
	private JButton btnStart;
	private JButton btnStop;
	private JSlider sliderStepAlphaAnimation;
	private JSpinner spinnerTimeSelect;
	private JRadioButton btnSensH;
	private JRadioButton btnSensA;
	private ButtonGroup sensChoice;
	}
