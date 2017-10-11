package com.storassa.java.uvax.bdecreator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Creator {

	private JFrame frame;
	private JTextField txtUpnapolil;
	private JTextField txtL;
	private JTextField txtL_1;
	private JTextField txtMessaggioStart;
	private JTextField textField_4;
	private JTextField txtL_2;

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
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome UPA/UCA");
		lblNewLabel.setBounds(10, 11, 169, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDataOraInizo = new JLabel("Data Ora Inizo");
		lblDataOraInizo.setBounds(10, 36, 169, 14);
		frame.getContentPane().add(lblDataOraInizo);
		
		JLabel lblDataOraFine = new JLabel("Data Ora Fine");
		lblDataOraFine.setBounds(10, 61, 169, 14);
		frame.getContentPane().add(lblDataOraFine);
		
		JLabel lblMotivazione = new JLabel("Motivazione");
		lblMotivazione.setBounds(10, 86, 169, 14);
		frame.getContentPane().add(lblMotivazione);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(10, 111, 169, 14);
		frame.getContentPane().add(lblNote);
		
		JLabel lblDataCreazioneMessaggio = new JLabel("Data Creazione Messaggio");
		lblDataCreazioneMessaggio.setBounds(10, 136, 169, 14);
		frame.getContentPane().add(lblDataCreazioneMessaggio);
		
		txtUpnapolil = new JTextField();
		txtUpnapolil.setText("UP_NAPOLIL_4");
		txtUpnapolil.setBounds(189, 8, 169, 20);
		frame.getContentPane().add(txtUpnapolil);
		txtUpnapolil.setColumns(10);
		
		txtL = new JTextField();
		txtL.setText("16-09-2011 10:15:00 L");
		txtL.setBounds(189, 33, 169, 20);
		frame.getContentPane().add(txtL);
		txtL.setColumns(10);
		
		txtL_1 = new JTextField();
		txtL_1.setText("16-09-2011 10:28:00 L");
		txtL_1.setBounds(189, 58, 169, 20);
		frame.getContentPane().add(txtL_1);
		txtL_1.setColumns(10);
		
		txtMessaggioStart = new JTextField();
		txtMessaggioStart.setText("Messaggio START");
		txtMessaggioStart.setBounds(189, 83, 169, 20);
		frame.getContentPane().add(txtMessaggioStart);
		txtMessaggioStart.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setText("-77.812");
		textField_4.setBounds(189, 108, 169, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		txtL_2 = new JTextField();
		txtL_2.setText("16-09-2011 09:15:00 L");
		txtL_2.setBounds(189, 133, 169, 20);
		frame.getContentPane().add(txtL_2);
		txtL_2.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(345, 238, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(246, 238, 89, 23);
		frame.getContentPane().add(btnOk);
	}
}
