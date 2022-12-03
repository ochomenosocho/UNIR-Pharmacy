package com.pharmacy;
import javax.swing.*;
import java.awt.FlowLayout;


public class MainView {
	private JFrame window;
	
	public void loadView() {
		this.setElementsIntoWindow();
		return;
	}
	
	private void setElementsIntoWindow() {
		JTextField medicineNameInput = this.getMedicineNameInput();
		JLabel medicineNameLabel = this.getMadicineNameLabel();
		JLabel medicineTypesLabel = this.getMedicineTypesLabel();
		JComboBox<Object> medicineTypesInput = this.getMedicineTypeList();
		JLabel amountOfMedicineLabel = this.getAmountOfMedicineLabel();
		JTextField amountOfMedicineInput = this.getAmountOfMedicineInput();
		this.window = this.generateWindow();
		this.window.add(medicineNameLabel);
		this.window.add(medicineNameInput);
		this.window.add(medicineTypesLabel);
		this.window.add(medicineTypesInput);
		this.window.add(amountOfMedicineLabel);
		this.window.add(amountOfMedicineInput);
		//aqui falta agregar los radio button xd
		return;
	}
	
	private JLabel getMadicineNameLabel() {
		return new JLabel("Nombre del medicamento:");
	}
	
	private JTextField getMedicineNameInput() {
		return new JTextField(50);
	}
	
	private JLabel getMedicineTypesLabel() {
		return new JLabel("Tipo del medicamento:");
	}
	
	private JComboBox<Object> getMedicineTypeList() {
		String[] medicinesListed = {"Analgecico",
									"Aneleptico",
									"Anestetico",
									"Antiacido",
									"Antidepresivo",
									"Antibioticos"
								 };
		return new JComboBox<Object>(medicinesListed);
	}
	
	private JLabel getAmountOfMedicineLabel() {
		return new JLabel("Cantidad de producto requerida:");
	}
	
	private JTextField getAmountOfMedicineInput() {
		return new JTextField(10);
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
