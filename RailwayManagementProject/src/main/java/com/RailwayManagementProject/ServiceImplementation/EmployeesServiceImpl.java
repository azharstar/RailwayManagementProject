package com.RailwayManagementProject.ServiceImplementation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RailwayManagementProject.Entities.Employees;
import com.RailwayManagementProject.Entities.Stations;
import com.RailwayManagementProject.Service.EmployeesService;

public class EmployeesServiceImpl implements EmployeesService {
    Scanner sc = new Scanner(System.in);
    Session session;

    public void insertEmployees(SessionFactory sf) {
        session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Employees emp = new Employees();
        
        try {
            System.out.println("Welcome to Employees");
            
            // Employee ID validation
            int id = getValidIntInput("Enter Employee_id: ");
            emp.setEmployee_id(id);

            System.out.println("Enter Employee's name:");
            String name = sc.next();
            emp.setName(name);

            System.out.println("Enter Employee position :");
            String position = sc.next();
            emp.setPosition(position);

            System.out.println("Enter station_id :");
            int station_id = getValidIntInput("Enter station_id: ");
            Stations st = session.get(Stations.class, station_id);
            if (st == null) {
                System.out.println("Station not found. Please enter a valid station_id");
                return;
            }

            emp.setStation_id(st);
            session.persist(emp);
            tx.commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    // Helper method to get valid integer input
    private int getValidIntInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return sc.nextInt();  // Try to read an integer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine();  // Consume the invalid input
            }
        }
    }

    @Override
    public void updateEmployees(SessionFactory sf) {
        session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Employees emp;

        try {
            while (true) {
                System.out.println("Choose an Option for Update " +
                        "\n1. Update Employee's name\n2. Update Employee position\n3. Update station_id\n4. Exit");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter Employee_id :");
                        int empId = sc.nextInt();
                        emp = session.get(Employees.class, empId);

                        if (emp != null) {
                            System.out.println("Update Employee's name:");
                            emp.setName(sc.next());

                            session.saveOrUpdate(emp);
                            tx.commit();
                            System.out.println("Employee's name updated successfully");
                        } else {
                            System.out.println("Employee not found for the given ID");
                        }
                        break;
                    case 2:
                        System.out.println("Enter Employee_id :");
                        empId = sc.nextInt();
                        emp = session.get(Employees.class, empId);

                        if (emp != null) {
                            System.out.println("Update Employee position:");
                            emp.setPosition(sc.next());

                            session.saveOrUpdate(emp);
                            tx.commit();
                            System.out.println("Employee position updated successfully");
                        } else {
                            System.out.println("Employee not found for the given ID");
                        }
                        break;

                    case 3:
                        System.out.println("Enter Employee_id:");
                        empId = sc.nextInt();
                        emp = session.get(Employees.class, empId);
                        if (emp != null) {
                            System.out.println("Update station_id:");
                            int st_id = sc.nextInt();
                            Stations st = session.get(Stations.class, st_id);

                            if (st != null) {
                                emp.setStation_id(st);  // Correctly update the employee's station
                                session.saveOrUpdate(emp);
                                tx.commit();
                                System.out.println("Employee's station updated successfully");
                            } else {
                                System.out.println("Station not found for the given ID");
                            }
                        } else {
                            System.out.println("Employee not found for the given ID");
                        }
                        break;

                    case 4:
                        System.out.println("Exit");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Choose correct option!");
                }
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteEmployees(SessionFactory sf) {
        session = sf.openSession();
        Transaction tx = session.beginTransaction();

        System.out.println("Enter Employee_id:");
        int id = sc.nextInt();

        Employees emp = session.get(Employees.class, id);
        try {
            if (emp != null) {
                session.delete(emp);
                tx.commit();
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Please Enter a valid Employee_id");
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void getAllEmployees(SessionFactory sf) {
        session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Employees");
        List<Employees> resultList = query.getResultList();

        for (Employees c : resultList) {
            System.out.println(c);
        }
        tx.commit();
        session.close();
    }

    @Override
    public void getEmployees(SessionFactory sf) {
        session = sf.openSession();
        System.out.println("Enter Employee_id:");
        int id = sc.nextInt(); // Changed to int as per the entity type
        Employees emp = session.get(Employees.class, id);
        System.out.println(emp);
        session.close();
    }

    @Override
    public void getEmployeesInformation(SessionFactory sf) {
        session = sf.openSession();

        Query query = session.createQuery("select count(employee_id) from Employees");
        List<Long> list = query.getResultList(); // Use Long as the result of count is a number

        System.out.println("Total number of Employees: " + list.get(0));
        session.close();
    }
}
