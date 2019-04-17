package com.paulpantea.assignment_2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.paulpantea.assignment_2.model.entities.Client;
import com.paulpantea.assignment_2.model.service.ClientService;
import com.paulpantea.assignment_2.model.service.StudentService;
import com.paulpantea.assignment_2.view.AdminView;
import com.paulpantea.assignment_2.view.ClientView;
import com.paulpantea.assignment_2.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.paulpantea.assignment_2"})
@EntityScan( basePackages = {"com.paulpantea.assignment_2"})
@ComponentScan(basePackages = {"com.paulpantea.assignment_2", "com.paulpantea.assignment_2.model.repository", "com.paulpantea.assignment_2.model.service"})
public class LoginController {
	
	private LoginView loginView = new LoginView();

	@Autowired
	ClientService clientBll;

	@Autowired
	StudentService studentService;
	
	public LoginController() {
		
		loginView.addLoginListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = loginView.getUsername();
				String password = loginView.getPassword();
								
				Client client = clientBll.login(username, password);
				System.out.println(client);
				if(client == null) {
					System.out.println("Eroare la logare");
				} else {
					clientBll.setLoggedIn(client);
					if(client.getIsAdmin() == true) {
						new AdminController(new AdminView(), studentService);
					} else {
						new ClientController(new ClientView(), clientBll, studentService);
					}
				}
			}
		});
		
		loginView.addClientListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = loginView.getUsername();
				String password = loginView.getPassword();
				
				Client newClient = new Client(username, password, false, true);
				clientBll.addClient(newClient);
				clientBll.setLoggedIn(newClient);
			}
		});
	}
}
