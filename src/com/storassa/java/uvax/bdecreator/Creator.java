package com.storassa.java.uvax.bdecreator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Creator {

	private JFrame frame;
	private JTextField nameText;
	private JTextField startDateText;
	private JTextField endDateText;
	private JTextField reasonText;
	private JTextField noteText;
	private JTextField creationDateText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		ZoneId z = ZoneId.of( "Europe/Rome" );
		ZonedDateTime zdt = ZonedDateTime.now( z );
		String date = zdt.toString().substring(0,19).replace("T", " ") + " L";

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel nameLabel = new JLabel("Nome UPA/UCA");
		nameLabel.setBounds(10, 11, 169, 14);
		frame.getContentPane().add(nameLabel);
		
		JLabel startDateLabel = new JLabel("Data Ora Inizo");
		startDateLabel.setBounds(10, 36, 169, 14);
		frame.getContentPane().add(startDateLabel);
		
		JLabel EndDateLabel = new JLabel("Data Ora Fine");
		EndDateLabel.setBounds(10, 61, 169, 14);
		frame.getContentPane().add(EndDateLabel);
		
		JLabel reasonLabel = new JLabel("Motivazione");
		reasonLabel.setBounds(10, 86, 169, 14);
		frame.getContentPane().add(reasonLabel);
		
		JLabel noteLabel = new JLabel("Note");
		noteLabel.setBounds(10, 111, 169, 14);
		frame.getContentPane().add(noteLabel);
		
		JLabel creationDateLabel = new JLabel("Data Creazione Messaggio");
		creationDateLabel.setBounds(10, 136, 169, 14);
		frame.getContentPane().add(creationDateLabel);
		
		nameText = new JTextField();
		nameText.setText("UP_NAPOLIL_4");
		nameText.setBounds(189, 8, 169, 20);
		frame.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		startDateText = new JTextField();
		startDateText.setText(date);
		startDateText.setBounds(189, 33, 169, 20);
		frame.getContentPane().add(startDateText);
		startDateText.setColumns(10);
		
		endDateText = new JTextField();
		endDateText.setText(date);
		endDateText.setBounds(189, 58, 169, 20);
		frame.getContentPane().add(endDateText);
		endDateText.setColumns(10);
		
		reasonText = new JTextField();
		reasonText.setText("Messaggio START");
		reasonText.setBounds(189, 83, 169, 20);
		frame.getContentPane().add(reasonText);
		reasonText.setColumns(10);
		
		noteText = new JTextField();
		noteText.setText("1.2");
		noteText.setBounds(189, 108, 169, 20);
		frame.getContentPane().add(noteText);
		noteText.setColumns(10);
		
		creationDateText = new JTextField();
		creationDateText.setText(date);
		creationDateText.setBounds(189, 133, 169, 20);
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
				Created dialog = new Created(nameText.getText(),
						startDateText.getText(),
						endDateText.getText(),
						noteText.getText(),
						reasonText.getText(),
						creationDateText.getText());
			}
		});
		okButton.setBounds(246, 238, 89, 23);
		frame.getContentPane().add(okButton);
	}
}
