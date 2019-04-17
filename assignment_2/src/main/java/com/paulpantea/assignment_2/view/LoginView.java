package com.paulpantea.assignment_2.view;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField passwordTextField;
	private JTextField usernameTextField;
	private JButton btnLogin;
	private JButton btnClient;

	public LoginView(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		usernameTextField = new JTextField();
		contentPane.add(usernameTextField);
		usernameTextField.setColumns(10);

		passwordTextField = new JTextField();
		contentPane.add(passwordTextField);
		passwordTextField.setColumns(10);

		btnLogin = new JButton("Login");
		contentPane.add(btnLogin);

		btnClient = new JButton("Create");
		contentPane.add(btnClient);
		this.show();
	}

	public void addLoginListener(ActionListener a) {
		btnLogin.addActionListener(a);
	}
	
	public void addClientListener(ActionListener a) {
		btnClient.addActionListener(a);
	}
	
	public String getUsername() {
		return usernameTextField.getText();
	}
	
	public String getPassword() {
		return passwordTextField.getText();
	}
}
