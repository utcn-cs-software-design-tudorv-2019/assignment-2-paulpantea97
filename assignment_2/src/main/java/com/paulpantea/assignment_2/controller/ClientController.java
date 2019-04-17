package com.paulpantea.assignment_2.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import com.paulpantea.assignment_2.model.entities.Student;
import com.paulpantea.assignment_2.model.service.ClientService;
import com.paulpantea.assignment_2.model.service.StudentService;
import com.paulpantea.assignment_2.view.ClientView;
import lombok.RequiredArgsConstructor;

public class ClientController {
	
	private final ClientView clientView;
	private final ClientService clientBll;
	private final StudentService studentBll;
	
	public ClientController(ClientView cv, ClientService clientBll, StudentService studentBll) {
		this.clientView = cv;
		this.clientBll = clientBll;
		this.studentBll = studentBll;
		
		clientView.addAddListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = clientView.getId();
				String name = clientView.getName();
				String pnc = clientView.getPnc();
				String address = clientView.getAddress();
				
				studentBll.addStudent(name, pnc, address);
				ArrayList<Student> student = new ArrayList<Student>();
				student.add(studentBll.findById(id));
				JTable table = studentBll.createTable(student);
				clientView.addTable(table);
			}
		});
		
		clientView.addViewListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Student> student = new ArrayList<Student>();
				student.add(studentBll.findByLoggedUser());
				JTable table = studentBll.createTable(student);
				clientView.addTable(table);
			}
		});
		
		clientView.addUpdateListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = clientView.getId();
				String name = clientView.getName();
				String pnc = clientView.getPnc();
				String address = clientView.getAddress();
				
				studentBll.editStudent(id, name, pnc, address);
				
				ArrayList<Student> student = new ArrayList<Student>();
				student.add(studentBll.findById(id));
				JTable table = studentBll.createTable(student);
				clientView.addTable(table);
			}
		});
		
		
	}
}
