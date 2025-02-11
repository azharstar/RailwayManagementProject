package com.RailwayManagementProject;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.grammars.hql.HqlParser.LocalDateTimeContext;
import org.hibernate.grammars.hql.HqlParser.LocalDateTimeFunctionContext;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;

import com.RailwayManagementProject.Entities.Employees;
import com.RailwayManagementProject.Entities.Maintenance_Record;
import com.RailwayManagementProject.Entities.Schedules;
import com.RailwayManagementProject.Entities.Seats;
import com.RailwayManagementProject.Entities.Stations;
import com.RailwayManagementProject.Entities.Tickets;
import com.RailwayManagementProject.Entities.Trains;
import com.RailwayManagementProject.ServiceImplementation.EmployeesServiceImpl;
import com.RailwayManagementProject.ServiceImplementation.MaintenanceRecordServiceImpl;
import com.RailwayManagementProject.ServiceImplementation.ScheduleServiceImpl;
import com.RailwayManagementProject.ServiceImplementation.SeatsServiceImpl;
import com.RailwayManagementProject.ServiceImplementation.StationServiceImpl;
import com.RailwayManagementProject.ServiceImplementation.TicketsServiceImpl;
import com.RailwayManagementProject.ServiceImplementation.TrainServiceImpl;
import com.RailwayManagementProject.utility.*;

public class RailwayManagementOperations {

    public static void main(String[] args) throws AvailabilityCriteriaException {
		/*
		 * Configuration cf = new Configuration(); cf.configure("config.xml");
		 */
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Scanner sc = new Scanner(System.in);

        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("---- Welcome to Railway Management System ----");
                System.out.println("Select an option:\n1. Train\n2. Ticket\n3. Employee\n4. Seat\n5. Schedule\n6. Maintenance Record\n7. Station\n8. Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        manageTrain(sc, factory);
                        break;
                    case 2:
                        manageTicket(sc, factory);
                        break;
                    case 3:
                        manageEmployee(sc, factory);
                        break;
                    case 4:
                        manageSeat(sc, factory);
                        break;
                    case 5:
                        manageSchedule(sc, factory);
                        break;
                    case 6:
                        manageMaintenanceRecord(sc, factory);
                        break;
                    case 7:
                        manageStation(sc, factory);
                        break;
                    case 8:
                        isRunning = false;
                        System.out.println("Exiting the application.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } finally {
            sc.close();
            session.close();
            factory.close();
        }
    }

    // Train Management
    private static void manageTrain(Scanner sc, SessionFactory factory) {
        TrainServiceImpl trainService = new TrainServiceImpl();
        while (true) {
            System.out.println("Train Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    trainService.insertTrain(factory);
                    break;
                case 2:
                    trainService.updateTrain(factory);
                    break;
                case 3:
                    trainService.deleteTrain(factory);
                    break;
                case 4:
                    trainService.getAllTrain(factory);
                    break;
                case 5:
                    trainService.getTrain(factory);
                    break;
                case 6:
                    trainService.getTrainInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Ticket Management
    private static void manageTicket(Scanner sc, SessionFactory factory) {
    	TicketsServiceImpl ticketService = new TicketsServiceImpl();
        while (true) {
            System.out.println("Ticket Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ticketService.insertTickets(factory);
                    break;
                case 2:
                    ticketService.updateTickets(factory);
                    break;
                case 3:
                    ticketService.deleteTickets(factory);
                    break;
                case 4:
                    ticketService.getAllTickets(factory);
                    break;
                case 5:
                    ticketService.getTickets(factory);
                    break;
                case 6:
                    ticketService.getTicketsInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Employee Management
 private static void manageEmployee(Scanner sc, SessionFactory factory) {
    	EmployeesServiceImpl employeeService = new EmployeesServiceImpl();
        while (true) {
            System.out.println("Employee Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    employeeService.insertEmployees(factory);
                    break;
                case 2:
                    employeeService.updateEmployees(factory);
                    break;
                case 3:
                    employeeService.deleteEmployees(factory);
                    break;
                case 4:
                    employeeService.getAllEmployees(factory);
                    break;
                case 5:
                    employeeService.getEmployees(factory);
                    break;
                case 6:
                    employeeService.getEmployeesInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Seat Management
    private static void manageSeat(Scanner sc, SessionFactory factory) throws AvailabilityCriteriaException {
    	SeatsServiceImpl seatService = new SeatsServiceImpl();
        while (true) {
            System.out.println("Seat Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    seatService.insertSeats(factory);
                    break;
                case 2:
                    seatService.updateSeats(factory);
                    break;
                case 3:
                    seatService.deleteSeats(factory);
                    break;
                case 4:
                    seatService.getAllSeats(factory);
                    break;
                case 5:
                    seatService.getSeats(factory);
                    break;
                case 6:
                    seatService.getSeatsInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Schedule Management
    private static void manageSchedule(Scanner sc, SessionFactory factory) {
        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
        while (true) {
            System.out.println("Schedule Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    scheduleService.insertSchedule(factory);
                    break;
                case 2:
                    scheduleService.updateSchedule(factory);
                    break;
                case 3:
                    scheduleService.deleteSchedule(factory);
                    break;
                case 4:
                    scheduleService.getAllSchedule(factory);
                    break;
                case 5:
                    scheduleService.getSchedule(factory);
                    break;
                case 6:
                    scheduleService.getScheduleInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    // Maintenance Record Management
    private static void manageMaintenanceRecord(Scanner sc, SessionFactory factory) {
        MaintenanceRecordServiceImpl maintenanceRecordService = new MaintenanceRecordServiceImpl();
        while (true) {
            System.out.println("Maintenance Record Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    maintenanceRecordService.insertMaintenanceRecord(factory);
                    break;
                case 2:
                    maintenanceRecordService.updateMaintenanceRecord(factory);
                    break;
                case 3:
                    maintenanceRecordService.deleteMaintenanceRecord(factory);
                    break;
                case 4:
                    maintenanceRecordService.getAllMaintenanceRecord(factory);
                    break;
                case 5:
                    maintenanceRecordService.getMaintenanceRecord(factory);
                    break;
                case 6:
                    maintenanceRecordService.getMaintenanceRecordInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Station Management
    private static void manageStation(Scanner sc, SessionFactory factory) {
        StationServiceImpl stationService = new StationServiceImpl();
        while (true) {
            System.out.println("Station Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    stationService.insertStation(factory);
                    break;
                case 2:
                    stationService.updateStation(factory);
                    break;
                case 3:
                    stationService.deleteStation(factory);
                    break;
                case 4:
                    stationService.getAllStation(factory);
                    break;
                case 5:
                    stationService.getStation(factory);
                    break;
                case 6:
                    stationService.getStationInformation(factory);
                    break;
		} 
           
		}
}
    }
