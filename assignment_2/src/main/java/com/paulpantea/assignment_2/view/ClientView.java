package com.paulpantea.assignment_2.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ClientView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldName;
	private JTextField textFieldPnc;
	private JTextField textFieldAddress;
	private JButton btnAdd;
	private JButton btnView;
	private JTable table;
	private JButton btnUpdate;
	
	public ClientView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 0, 0, 0));
		
		textFieldId = new JTextField();
		textFieldId.setText("");
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldName = new JTextField();
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPnc = new JTextField();
		contentPane.add(textFieldPnc);
		textFieldPnc.setColumns(10);
		
		textFieldAddress = new JTextField();
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		btnAdd = new JButton("Adaugare Student");
		contentPane.add(btnAdd);
		
		btnView = new JButton("View");
		contentPane.add(btnView);
		
		btnUpdate = new JButton("Update");
		contentPane.add(btnUpdate);
		
		table = new JTable();
		contentPane.add(table);
		this.show();
	}
	
	public void addTable(JTable table) {
		if(this.table != null) {
			this.remove(this.table);
		}
		
		this.table = table;
		getContentPane().add(this.table);
		
		this.revalidate();
	}
	
	public void addViewListener(ActionListener a) {
		btnView.addActionListener(a);
	}
	
	public void addAddListener(ActionListener a) {
		btnAdd.addActionListener(a);
	}
	
	public void addUpdateListener(ActionListener a) {
		btnUpdate.addActionListener(a);
	}
	
	public int getId() {
		return Integer.parseInt(textFieldId.getText());
	}
	
	public String getName() {
		return textFieldName.getText();
	}
	
	public String getPnc() {
		return textFieldPnc.getText();
	}
	
	public String getAddress() {
		return textFieldAddress.getText();
	}

}
