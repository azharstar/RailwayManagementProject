package com.RailwayManagementProject.Service;

import org.hibernate.SessionFactory;

public interface EmployeesService {
	void insertEmployees(SessionFactory sf);
	void updateEmployees(SessionFactory sf);
	void deleteEmployees(SessionFactory sf);
	void getAllEmployees(SessionFactory sf);
	void getEmployees(SessionFactory sf);
	void getEmployeesInformation(SessionFactory sf);

}
