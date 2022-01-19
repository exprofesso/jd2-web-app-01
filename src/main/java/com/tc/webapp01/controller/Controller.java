package com.tc.webapp01.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Hello, world!");
		String name;
		String surname;
		String login;
		String password;
		String address;
		String contact;


		name = request.getParameter("name");
		surname = request.getParameter("surname");
		login = request.getParameter("login");
		password = request.getParameter("password");
		address = request.getParameter("address");
		contact = request.getParameter("contact");



		System.out.println(name + " " + surname);
		System.out.println(login + " " + password);
		System.out.println(address + " " + contact);
	}

}
