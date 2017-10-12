package com.storassa.java.uvax.bdecreator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Created extends JDialog {

	String name = "UP_NAPOLIL_4", startDate = "16-09-2011 10:15:00 L", endDate = "16-09-2011 10:28:00 L",
			note = "Messaggio START", reason = "-77.812", creationDate = "16-09-2011 09:15:00 L";

	private final JPanel contentPanel = new JPanel();
	JTextArea BdeMessagetextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Created dialog = new Created();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Created() {
		setResizable(false);
		setBounds(100, 100, 696, 446);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			BdeMessagetextArea = new JTextArea();
			BdeMessagetextArea.setEditable(false);
			BdeMessagetextArea.setFont(new Font("Courier New", Font.PLAIN, 14));
			contentPanel.add(BdeMessagetextArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Create a file chooser
						// final JFileChooser fc = new JFileChooser();
						// int returnVal = fc.showOpenDialog(Created.this);
						// if (returnVal == JFileChooser.APPROVE_OPTION) {
						// File file = fc.getSelectedFile();
						//
						try {

							String path = Created.class.getProtectionDomain().getCodeSource().getLocation().getPath();
							System.out.print(path);
							File file = new File(System.getProperty("user.home") 
									+ File.separator 
									+ "sequenceNumber.txt");
							BufferedReader brSeqNumb = new BufferedReader(new FileReader(file));
							String sequenceNumber = brSeqNumb.readLine();
							int seq = Integer.parseInt(sequenceNumber);
							
							PrintWriter pwBde = new PrintWriter(new File(System.getProperty("user.home") 
									+ File.separator + "MG-" + ++seq + ".doc"));
							pwBde.print(BdeMessagetextArea.getText());
							pwBde.close();
							
							brSeqNumb.close();

							PrintWriter pwSeqNumb = new PrintWriter(file);

							pwSeqNumb.print(seq);
							pwSeqNumb.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						// }
						System.exit(0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Created(String _name, String _startDate, String _endDate, String _note, String _reason,
			String _creationDate) {

		this();

		name = _name;
		startDate = _startDate;
		endDate = _endDate;
		note = _note;
		reason = _reason;
		creationDate = _creationDate;

		BdeMessagetextArea.setText("*************************************************\r\n"
				+ "************** MESSAGGIO DI COMANDO *************\r\n"
				+ "****************** PER UPA/UCA ******************\r\n"
				+ "*************************************************\r\n" + "Nome UPA/UCA                        = "
				+ name + "\r\n" + "Data Ora Inizio                     = " + startDate + "\r\n"
				+ "Data Ora Fine                       = " + endDate + "\r\n" + "Motivazione                         = "
				+ reason + "\r\n" + "Note                                = " + note + "\r\n"
				+ "Data Creazione Msg                  = " + creationDate + "\r\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"
				+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n" + name + ";" + startDate + ";" + endDate
				+ "\n" + reason + "\r\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"
				+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"

		);

		this.setVisible(true);

	}

}
