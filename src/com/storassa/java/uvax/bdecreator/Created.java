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

	String path = "", name = "UP_NAPOLIL_4", startDate = "16-10-2017 10:15:00 L", endDate = "16-10-2017 10:28:00 S",
			initialPower = "Messaggio START", finalPower = "1.2", creationDate = "16-10-2017 09:15:00 S";
	
	private Creator creator;

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

						try {

							String seqNumberPath = Created.class.getProtectionDomain().getCodeSource().getLocation().getPath();
							seqNumberPath = seqNumberPath.substring(0,seqNumberPath.length() - 15) + File.separator;
							System.out.print(path);
							File file = new File(seqNumberPath + "sequenceNumber.txt");
							BufferedReader brSeqNumb = new BufferedReader(new FileReader(file));
							String sequenceNumber = brSeqNumb.readLine();
							int seq = Integer.parseInt(sequenceNumber);
							
							System.out.println(path);
							PrintWriter pwBde = new PrintWriter(new File(path + File.separator + "MG-" + ++seq + ".doc"));
							pwBde.print(BdeMessagetextArea.getText());
							pwBde.close();
							
							brSeqNumb.close();

							PrintWriter pwSeqNumb = new PrintWriter(file);

							pwSeqNumb.print(seq);
							pwSeqNumb.close();
							
						} catch (Exception ex) {
						
							ex.printStackTrace();
						}
						
						creator.updateTimes();
						dispose();
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

	public Created(String _path, String _name, String _startDate, String _endDate, String _initialPower, String _finalPower,
			String _creationDate, Creator _creator) {

		this();

		creator = _creator;
		path = _path;
		name = _name;
		startDate = _startDate;
		endDate = _endDate;
		initialPower = _initialPower;
		finalPower = _finalPower;
		creationDate = _creationDate;

		BdeMessagetextArea.setText("*************************************************\r\n"
				+ "************** MESSAGGIO DI COMANDO *************\r\n"
				+ "****************** PER UPA/UCA ******************\r\n"
				+ "*************************************************\r\n" + "Nome UPA/UCA                        = " + name + "\r\n" 
				+ "Data Ora Inizio Comando             = " + startDate + "\r\n"
				+ "Data Ora Fine Comando               = " + endDate + "\r\n"
				+ "Variazione potenza Prog Vinc (TINI) = " + initialPower + "\r\n"
				+ "Variazione potenza Prog Vinc (TFIN) = " + finalPower + "\r\n"
				+ "Data Creazione Msg                  = " + creationDate + "\r\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"
				+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n" + name + ";" + startDate + ";" + endDate
				+ "\n" + initialPower + finalPower + creationDate + "\r\n"
				+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"
				+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"

		);

		this.setVisible(true);

	}

}
