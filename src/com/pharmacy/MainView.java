package com.pharmacy;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
	private JFrame window;
	private JTextField name =  new JTextField(50);
	private String[] medicinesListed = {
					"Analgecico",
					"Aneleptico",
					"Anestetico",
					"Antiacido",
					"Antidepresivo",
					"Antibioticos"
				 };
	private JComboBox<Object> type = new JComboBox<Object>(medicinesListed);
	private JTextField amount = new JTextField(10);
	private ButtonGroup distributors = new ButtonGroup();
	private JCheckBox mainBranchOffice = new JCheckBox("Sucursal principal");
	private JCheckBox secondaryBranchOffice = new JCheckBox("Sucursal secundaria");
	private ButtonGroup offices = new ButtonGroup();
	private JRadioButton cofarma = new JRadioButton("Cofarma");
	private JRadioButton empsephar = new JRadioButton("Empsephar");
	private JRadioButton cemefar = new JRadioButton("Cemefar");
	private JButton confirmButton = new JButton("Confirmar");
	private JButton cancelButton = new JButton("Cancelar");
	
	public void loadView() {
		this.window = this.generateMainWindow();
		this.setElementsIntoWindow();
		this.window.setVisible(true);
	}
	
	private void setElementsIntoWindow() {
		this.addMadicineNameInput();
		this.addMedicineTypeList();
		this.addAmount();
		this.addBranchOfficeCheckBox();
		this.addDistributorSelector();
		this.addCancelButton();
		this.addConfirmButton();
	}
	
	private void addConfirmButton() {
		this.confirmButton.setBounds(300,250,100,30);
	    this.window.add(this.confirmButton);
	    this.confirmButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { checkIfDataIsCorrect(); }
	    });
	}
	
	private void addCancelButton() {
		this.cancelButton.setBounds(300,250,100,30);
	    this.window.add(this.cancelButton);
	    this.cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { clearDataFromFrame(); }
	    });
	}
	
	private void checkIfDataIsCorrect() {
		if (!this.isAlphaNumeric(this.name.getText())) this.addErrorToMainView();
		else if (!isNumeric(this.amount.getText())) this.addErrorToMainView();
		else if (!(Integer.parseInt(this.amount.getText()) > 0)) this.addErrorToMainView();
		else if (!(this.cofarma.isSelected()
				|| this.empsephar.isSelected()
				|| this.cemefar.isSelected())) this.addErrorToMainView();
		else if (!(this.mainBranchOffice.isSelected()
				|| this.secondaryBranchOffice.isSelected())) this.addErrorToMainView();
		else {
			Summary summary = new Summary();
			summary.loadSummaryView(this.distributors.getSelection().toString(), this.amount.getText(),
									this.type.getSelectedItem().toString(), this.name.getText(),
									this.offices.getSelection().toString()
									);
		}
	}
	
	private boolean isNumeric(String number) {
		if (number == null) return false;
	    try {
	        @SuppressWarnings("unused")
			double d = Double.parseDouble(number);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	private void addErrorToMainView() {
		this.displayErrorMessage();
		this.clearDataFromFrame();
	}
	
	private void clearDataFromFrame() {
		this.name.setText(null);
		this.amount.setText(null);
		this.type.setSelectedIndex(0);
		this.distributors.clearSelection();
		this.offices.clearSelection();
	}
	
	private void displayErrorMessage(){
		Error error = new Error();
		error.loadErrorView();
	}
	
	private boolean isAlphaNumeric(String word) {
        return word != null && word.matches("^[a-zA-Z0-9]*$");
    }
	
	private void addMadicineNameInput() {
		JLabel nameLabel = new JLabel("Nombre del medicamento:");
		this.window.add(nameLabel);
		this.window.add(this.name);
	}
	
	private void addDistributorSelector() {
		JLabel nameLabel = new JLabel("Distribuidor:");
		this.distributors.add(this.cofarma);
		this.distributors.add(this.empsephar);
		this.distributors.add(this.cemefar);
		this.window.add(nameLabel);
		this.window.add(this.cofarma);
		this.window.add(this.empsephar);
		this.window.add(this.cemefar);
	}
	
	private void addBranchOfficeCheckBox() {
		JLabel nameLabel = new JLabel("Sucursal:");
		this.mainBranchOffice.setBounds(10,10,150,30);
		this.secondaryBranchOffice.setBounds(10,10,150,30);
		this.offices.add(this.mainBranchOffice);
		this.offices.add(this.secondaryBranchOffice);
		this.window.add(nameLabel);
        this.window.add(this.mainBranchOffice);
        this.window.add(this.secondaryBranchOffice);
	}
	
	private void addMedicineTypeList() {
		JLabel nameLabel = new JLabel("Tipo del medicamento:");
		this.window.add(nameLabel);
		this.window.add(this.type);
	}
	
	private void addAmount() {
		JLabel nameLabel = new JLabel("Cantidad de producto requerida:");
		this.window.add(nameLabel);
		this.window.add(this.amount);
	}
	
	private JFrame generateMainWindow() {
		JFrame window = new JFrame("Amazing Pharmacy!");
		window.setLayout(new FlowLayout());
		window.setSize(850, 800);
		return window;
	}
}
