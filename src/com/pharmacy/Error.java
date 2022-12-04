package com.pharmacy;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Error {
	private JFrame window;
	private JButton OKButton = new JButton("OK");
	
	public void loadErrorView() {
		this.window = this.generateSummaryWindow();
		this.setElementsIntoWindow();
		this.window.setVisible(true);
	}
	
	private void setElementsIntoWindow() {
		this.addAlert();
		this.addConfirmButton();
	}
	
	private void addAlert() {
		JLabel summary = new JLabel("Alguno de los datos es incorrecto");
		this.window.add(summary);
	}
	
	private void addConfirmButton() {
		this.OKButton.setBounds(300,250,100,30);
	    this.window.add(this.OKButton);
	    this.OKButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) { window.dispose(); }
	    });
	}
	
	private JFrame generateSummaryWindow() {
		JFrame window = new JFrame("Error con los datos!");
		window.setLayout(new FlowLayout());
		window.setSize(450, 300);
		return window;
	}
}
