package com.pharmacy;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainView {
	private JFrame window;
	
	public MainView() {
		this.window = this.generateWindow();
		this.setElementsIntoWindow();
		this.window.setVisible(true);
	}
	
	public void setElementsIntoWindow() {
		this.addMadicineNameInput();
		this.addMedicineTypeList();
		this.addAmountInput();
		this.addBranchOfficeCheckBox();
		this.setDistributorSelector();
		this.addCancelButton();
		this.addConfirmButton();
	}
	
	private void addConfirmButton() {
		JButton confirmButton = new JButton("Confirmar");
		confirmButton.setBounds(300,250,100,30);
	    this.window.add(confirmButton);
	    confirmButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				getAllDataFromFrame();
			}
	    });
	}
	
	private void addCancelButton() {
		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(300,250,100,30);
	    this.window.add(cancelButton);
	    cancelButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteDataFromFrame();
			}
	    });
	}
	
	private void getAllDataFromFrame() {
		System.out.println("XD");
	}
	
	private void deleteDataFromFrame() {
		System.out.println("No XD");
	}
	
	private void addMadicineNameInput() {
		JLabel nameLabel = new JLabel("Nombre del medicamento:");
		JTextField medicineNameField =  new JTextField(50);
		this.window.add(nameLabel);
		this.window.add(medicineNameField);
	}
	
	private void setDistributorSelector() {
		JLabel nameLabel = new JLabel("Distribuidor:");
		JRadioButton cofarma = new JRadioButton("Cofarma");
		JRadioButton empsephar = new JRadioButton("Empsephar");
		JRadioButton cemefar = new JRadioButton("Cemefar");
		ButtonGroup distributors = new ButtonGroup();
		distributors.add(cofarma);
		distributors.add(empsephar);
		distributors.add(cemefar);
		this.window.add(nameLabel);
		this.window.add(cofarma);
		this.window.add(empsephar);
		this.window.add(cemefar);
	}
	
	private void addBranchOfficeCheckBox() {
		JLabel nameLabel = new JLabel("Sucursal:");
		JCheckBox mainBranchOffice = new JCheckBox("Sucursal principal");
		mainBranchOffice.setBounds(10,10,150,30);
		JCheckBox secondaryBranchOffice = new JCheckBox("Sucursal secundaria");
		secondaryBranchOffice.setBounds(10,10,150,30);
		ButtonGroup offices = new ButtonGroup();
		offices.add(mainBranchOffice);
		offices.add(secondaryBranchOffice);
		this.window.add(nameLabel);
        this.window.add(mainBranchOffice);
        this.window.add(secondaryBranchOffice);
	}
	
	private void addMedicineTypeList() {
		JLabel nameLabel = new JLabel("Tipo del medicamento:");
		String[] medicinesListed = {"Analgecico",
									"Aneleptico",
									"Anestetico",
									"Antiacido",
									"Antidepresivo",
									"Antibioticos"
								 };
		JComboBox<Object> medicines = new JComboBox<Object>(medicinesListed);
		this.window.add(nameLabel);
		this.window.add(medicines);
	}
	
	private void addAmountInput() {
		JLabel nameLabel = new JLabel("Cantidad de producto requerida:");
		JTextField amountInput = new JTextField(10);
		this.window.add(nameLabel);
		this.window.add(amountInput);
	}
	
	private JFrame generateWindow() {
		JFrame window = new JFrame("Amazing Pharmacy!");
		window.setLayout(new FlowLayout());
		window.setSize(850, 800);
		window.setVisible(true);
		return window;
	}
	
	public void testPrint() {
		System.out.println("Loading !");
	}
}
