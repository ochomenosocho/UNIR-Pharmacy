package com.pharmacy;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Summary {
	private JFrame window;
	private JButton confirmButton = new JButton("Confirmar");
	private JButton cancelButton = new JButton("Cancelar");
	private String distributor;
	private String amount;
	private String type;
	private String name;
	private String branchOffice;
	private String mainOfficeAddress = "De la Rosa n.28";
	private String secondaryOfficeAddress = " Alcazabilla n.3";
	
	public void loadSummaryView(String medicineDistributor, String medicineAmount, String medicineType,
								String medicineName, String office) {
		this.distributor = medicineDistributor;
		this.amount = medicineAmount;
		this.type = medicineType;
		this.name = medicineName;
		this.branchOffice = office;
		this.window = this.generateSummaryWindow(distributor);
		this.setElementsIntoWindow();
		this.window.setVisible(true);
	}

	private void setElementsIntoWindow() {
		this.addSummary();
		this.addCancelButton();
		this.addConfirmButton();
	}
	
	private void addSummary() {
		JLabel amount = new JLabel(this.amount);
		JLabel text1 = new JLabel(" unidades del ");
		JLabel type = new JLabel(this.type.concat(" "));
		JLabel name = new JLabel(this.name);
		JLabel text2 = new JLabel(" para la farmacia situada en la calle ");
		String address;
		if (this.branchOffice == "Sucursal principal") {
			address = this.mainOfficeAddress;
		} else {
			address = this.secondaryOfficeAddress;
		}
		JLabel OfficeAddress = new JLabel(address);
		this.window.add(amount);
		this.window.add(text1);
		this.window.add(type);
		this.window.add(name);		
		this.window.add(text2);
		this.window.add(OfficeAddress);
	}
	
	private void addConfirmButton() {
		this.confirmButton.setBounds(300,250,100,30);
	    this.window.add(this.confirmButton);
	    this.confirmButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Pedido enviado");
				window.dispose();
			}
	    });
	}
	
	private void addCancelButton() {
		this.cancelButton.setBounds(300,250,100,30);
	    this.window.add(this.cancelButton);
	    this.cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { window.dispose(); }
	    });
	}
	
	
	
	private JFrame generateSummaryWindow(String distributor) {
		JFrame window = new JFrame("Pedido al distribuidor ".concat(distributor));
		window.setLayout(new FlowLayout());
		window.setSize(450, 400);
		return window;
	}
}
