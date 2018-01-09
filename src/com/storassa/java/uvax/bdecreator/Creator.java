package com.storassa.java.uvax.bdecreator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Creator {

	private JFrame frame;
	private JTextField startDateText;
	private JTextField endDateText;
	private JTextField creationDateText;

	private static String path;
	private JTextField powerTextField;

	private ButtonGroup buttonGroup;

	private final static String[] UVAC = new String[] { "UP_NAPOLIL_4", "UP_GENOVAL_4", "UP_TERNIL_4", "UP_ROMAL_4",
			"UP_TORINOL_4", "UP_MILANO_4", "Selesoft" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		path = args[0];

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creator window = new Creator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Creator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		buttonGroup = new ButtonGroup();

		ZoneId z = ZoneId.of("Europe/Rome");
		ZonedDateTime zdt = ZonedDateTime.now(z);
		String date = zdt.toString().substring(0, 19).replace("T", " ");

		SimpleDateFormat dtnew = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat dtold = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 609, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel nameLabel = new JLabel("Nome UPA/UCA");
		nameLabel.setBounds(10, 23, 404, 14);
		frame.getContentPane().add(nameLabel);

		JLabel startDateLabel = new JLabel("Data Ora Inizo Comando");
		startDateLabel.setBounds(9, 67, 404, 14);
		frame.getContentPane().add(startDateLabel);

		JLabel EndDateLabel = new JLabel("Data Ora Fine Comando");
		EndDateLabel.setBounds(9, 105, 404, 14);
		frame.getContentPane().add(EndDateLabel);

		JLabel creationDateLabel = new JLabel("Data Creazione Messaggio");
		creationDateLabel.setBounds(10, 136, 404, 14);
		frame.getContentPane().add(creationDateLabel);

		startDateText = new JTextField();
		try {

			Calendar cal = Calendar.getInstance();
			cal.setTime(dtold.parse(date));
			cal.add(Calendar.SECOND, 10);
			startDateText.setText(dtnew.format(cal.getTime()) + " S");

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

		startDateText.setBounds(423, 64, 169, 20);
		frame.getContentPane().add(startDateText);
		startDateText.setColumns(10);

		endDateText = new JTextField();
		try {

			Calendar cal = Calendar.getInstance();
			cal.setTime(dtold.parse(date));
			cal.add(Calendar.SECOND, 20);
			endDateText.setText(dtnew.format(cal.getTime()) + " S");

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

		endDateText.setBounds(423, 102, 169, 20);
		frame.getContentPane().add(endDateText);
		endDateText.setColumns(10);

		try {

			creationDateText = new JTextField();
			creationDateText.setText(dtnew.format(dtold.parse(date)) + " S");

		} catch (Exception e) {

			throw new RuntimeException(e);
		}

		creationDateText.setBounds(424, 133, 169, 20);
		frame.getContentPane().add(creationDateText);
		creationDateText.setColumns(10);

		JRadioButton startMsgRadioButton = new JRadioButton("Messaggio START");
		startMsgRadioButton.setBounds(32, 185, 148, 23);
		startMsgRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				powerTextField.setEditable(true);
			}
		});
		startMsgRadioButton.setSelected(true);
		frame.getContentPane().add(startMsgRadioButton);

		powerTextField = new JTextField();
		powerTextField.setBounds(186, 186, 136, 20);
		frame.getContentPane().add(powerTextField);
		powerTextField.setColumns(10);

		JRadioButton stopMsgRadioButton = new JRadioButton("Messaggio STOP");
		stopMsgRadioButton.setBounds(32, 238, 148, 23);
		stopMsgRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				powerTextField.setText("");
				powerTextField.setEditable(false);
			}
		});
		frame.getContentPane().add(stopMsgRadioButton);

		buttonGroup.add(stopMsgRadioButton);
		buttonGroup.add(startMsgRadioButton);

		JComboBox nameComboBox = new JComboBox(UVAC);
		nameComboBox.setBounds(421, 19, 168, 20);
		frame.getContentPane().add(nameComboBox);

		JButton cancelButton = new JButton("Cancel");

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		cancelButton.setBounds(504, 280, 89, 23);
		frame.getContentPane().add(cancelButton);

		JButton okButton = new JButton("OK");

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String variazTini = startMsgRadioButton.isSelected()
						? "0" : String.valueOf(Double.parseDouble(powerTextField.getText()) / 1000000);
				String variazTfin = startMsgRadioButton.isSelected() ? "3" : "0";
				Created dialog = new Created(path, nameComboBox.getSelectedItem().toString(), startDateText.getText(),
						endDateText.getText(), variazTini, variazTfin, creationDateText.getText(), Creator.this);
			}
		});

		okButton.setBounds(303, 280, 89, 23);
		frame.getContentPane().add(okButton);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateTimes();
			}
		});
		btnRefresh.setBounds(405, 280, 89, 23);
		frame.getContentPane().add(btnRefresh);

	}

	protected void updateTimes() {
		
		ZoneId z = ZoneId.of("Europe/Rome");
		ZonedDateTime zdt = ZonedDateTime.now(z);
		String date = zdt.toString().substring(0, 19).replace("T", " ");

		SimpleDateFormat dtnew = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat dtold = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		try {

			Calendar cal = Calendar.getInstance();
			cal.setTime(dtold.parse(date));
			cal.add(Calendar.SECOND, 10);
			startDateText.setText(dtnew.format(cal.getTime()) + " S");
			
			cal.setTime(dtold.parse(date));
			cal.add(Calendar.SECOND, 20);
			endDateText.setText(dtnew.format(cal.getTime()) + " S");
			
			creationDateText.setText(dtnew.format(dtold.parse(date)) + " S");

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}
}
