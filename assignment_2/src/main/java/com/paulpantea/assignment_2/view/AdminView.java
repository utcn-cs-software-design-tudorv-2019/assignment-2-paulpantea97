package com.paulpantea.assignment_2.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAddress;
	private JTextField textFieldPnc;
	private JTextField textFieldName;
	private JTextField textFieldId;
	private JTable table;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnView;
	private JTextField textFieldClient;

	public AdminView(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panelText = new JPanel();
		contentPane.add(panelText);

		textFieldId = new JTextField();
		panelText.add(textFieldId);
		textFieldId.setColumns(10);

		textFieldName = new JTextField();
		panelText.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldAddress = new JTextField();
		panelText.add(textFieldAddress);
		textFieldAddress.setColumns(10);

		textFieldPnc = new JTextField();
		panelText.add(textFieldPnc);
		textFieldPnc.setColumns(10);

		textFieldClient = new JTextField();
		panelText.add(textFieldClient);
		textFieldClient.setColumns(10);

		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);

		btnAdd = new JButton("Add");
		panelButtons.add(btnAdd);

		btnUpdate = new JButton("Update");
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Delete");
		panelButtons.add(btnDelete);

		btnView = new JButton("View");
		panelButtons.add(btnView);

		table = new JTable();
		contentPane.add(table);
		this.show();
	}

	public String getAddress() {
		return textFieldAddress.getText();
	}
	
	public String getName() {
		return textFieldName.getText();
	}
	
	public String getPnc() {
		return textFieldPnc.getText();
	}
	
	public int getId() {
		return Integer.parseInt(textFieldId.getText());
	}
	
	public int getClientId() {
		return Integer.parseInt(textFieldClient.getText());
	}
	
	public void addTable(JTable table) {
		if(this.table != null) {
			this.remove(this.table);
		}
		
		this.table = table;
		this.add(this.table);
		
		this.revalidate();
	}
	
	public void addBtnAddListener(ActionListener a) {
		btnAdd.addActionListener(a);
	}
	
	public void addBtnViewListener(ActionListener a) {
		btnView.addActionListener(a);
	}
	
	public void addBtnUpdateListener(ActionListener a) {
		btnUpdate.addActionListener(a);
	}
	
	public void addBtnDeleteListener(ActionListener a) {
		btnDelete.addActionListener(a);
	}
}
