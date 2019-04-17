package com.paulpantea.assignment_2;

import com.paulpantea.assignment_2.controller.LoginController;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;

public class Assignment2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(LoginController.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {
			LoginController ex = ctx.getBean(LoginController.class);
		});
	}

}
