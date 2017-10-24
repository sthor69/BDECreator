package com.storassa.java.uvax.bdecreator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Creator {

	private JFrame frame;
	private JTextField nameText;
	private JTextField startDateText;
	private JTextField endDateText;
	private JTextField variazTiniText;
	private JTextField variazTfinText;
	private JTextField creationDateText;
	
	private static String path;

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

		ZoneId z = ZoneId.of("Europe/Rome");
		ZonedDateTime zdt = ZonedDateTime.now(z);
		String date = zdt.toString().substring(0, 19).replace("T", " ");

		SimpleDateFormat dtnew = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		SimpleDateFormat dtold = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel nameLabel = new JLabel("Nome UPA/UCA");
		nameLabel.setBounds(10, 11, 169, 14);
		frame.getContentPane().add(nameLabel);

		JLabel startDateLabel = new JLabel("Data Ora Inizo Comando");
		startDateLabel.setBounds(10, 36, 169, 14);
		frame.getContentPane().add(startDateLabel);

		JLabel EndDateLabel = new JLabel("Data Ora Fine Comando");
		EndDateLabel.setBounds(10, 61, 169, 14);
		frame.getContentPane().add(EndDateLabel);

		JLabel variazTiniLabel = new JLabel("Variazione potenza Prog Vinc (TINI)");
		variazTiniLabel.setBounds(10, 86, 245, 14);
		frame.getContentPane().add(variazTiniLabel);

		JLabel variazTfinLabel = new JLabel("Variazione potenza Prog Vinc (TFIN)");
		variazTfinLabel.setBounds(10, 111, 245, 14);
		frame.getContentPane().add(variazTfinLabel);

		JLabel creationDateLabel = new JLabel("Data Creazione Messaggio");
		creationDateLabel.setBounds(10, 136, 169, 14);
		frame.getContentPane().add(creationDateLabel);

		nameText = new JTextField();
		nameText.setText("UP_NAPOLIL_4");
		nameText.setBounds(265, 11, 169, 20);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);

		startDateText = new JTextField();
		try {
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dtold.parse(date));
			cal.add(Calendar.MINUTE, 2);
			startDateText.setText(dtnew.format(cal.getTime()) + " L");
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
		startDateText.setBounds(265, 36, 169, 20);
		frame.getContentPane().add(startDateText);
		startDateText.setColumns(10);

		endDateText = new JTextField();
		try {
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dtold.parse(date));
			cal.add(Calendar.MINUTE, 17);
			endDateText.setText(dtnew.format(cal.getTime()) + " L");
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
		endDateText.setBounds(265, 61, 169, 20);
		frame.getContentPane().add(endDateText);
		endDateText.setColumns(10);

		variazTiniText = new JTextField();
		variazTiniText.setText("0");
		variazTiniText.setBounds(265, 86, 169, 20);
		frame.getContentPane().add(variazTiniText);
		variazTiniText.setColumns(10);

		variazTfinText = new JTextField();
		variazTfinText.setText("1.2");
		variazTfinText.setBounds(265, 111, 169, 20);
		frame.getContentPane().add(variazTfinText);
		variazTfinText.setColumns(10);
		
		try {
			
			creationDateText = new JTextField();
			creationDateText.setText(dtnew.format(dtold.parse(date)) + " L");
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
		creationDateText.setBounds(265, 136, 169, 20);
		frame.getContentPane().add(creationDateText);
		creationDateText.setColumns(10);

		JButton cancelButton = new JButton("Cancel");
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		cancelButton.setBounds(345, 238, 89, 23);
		frame.getContentPane().add(cancelButton);

		JButton okButton = new JButton("OK");
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Created dialog = new Created(path, nameText.getText(), startDateText.getText(), endDateText.getText(),
						variazTfinText.getText(), variazTiniText.getText(), creationDateText.getText());
			}
		});
		
		okButton.setBounds(246, 238, 89, 23);
		frame.getContentPane().add(okButton);
	}
}
