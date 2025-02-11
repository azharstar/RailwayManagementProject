package com.RailwayManagementProject.ServiceImplementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RailwayManagementProject.Entities.Employees;
import com.RailwayManagementProject.Entities.Schedules;
import com.RailwayManagementProject.Entities.Stations;
import com.RailwayManagementProject.Entities.Trains;
import com.RailwayManagementProject.Service.ScheduleService;
public class ScheduleServiceImpl implements ScheduleService {
	Scanner sc=new Scanner(System.in);
	  Session session;

	@Override
	public void insertSchedule(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Schedules sl = new Schedules();
		
		System.out.println("Welcome to Schedules");
		System.out.println("Enter Schedules Id: ");
		int id = sc.nextInt();
		sl.setSchedule_id(id);
		
		//System.out.print("Enter arrival_time (yyyy-MM-dd HH:mm): ");
		//String arrival_time = sc.nextInt() + " " + sc.nextInt();
		//LocalDateTime arrTime = LocalDateTime.parse(arrival_time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		//sl.setArrival_time(sc.nextInt());
		
		System.out.print("Enter arrival_time (yyyy-MM-dd HH:mm): ");
		sc.nextLine(); // Consume newline character left by nextInt()
		String arrivalTimeInput = sc.nextLine();

		try {
		    // Parse the input string into LocalDateTime
		    LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		    sl.setArrival_time(arrivalTime);
		} catch (Exception e) {
		    System.out.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
		}

		System.out.print("Enter departure_time (yyyy-MM-dd HH:mm): ");
		String departureTimeInput = sc.nextLine();

		try {
		    // Parse the input string into LocalDateTime
		    LocalDateTime departureTime = LocalDateTime.parse(departureTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		    sl.setDeparture_time(departureTime);
		} catch (Exception e) {
		    System.out.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
		}

		
	    System.out.println("Enter  train_id :");
		int train_id = sc.nextInt();
		sc.nextLine();
		Trains tr=session.get(Trains.class,train_id);
		if(tr==null) {
			System.out.println("Train not found.Please enter a valid train_id");
			return;
		}
		sl.setTrain(tr);
		
		System.out.println("Enter  station_id :");
		int station_id = sc.nextInt();
		sc.nextLine();
		Stations st=session.get(Stations.class,station_id);
		if(st==null) {
			System.out.println("station not found.Please enter a valid station_id");
			return;
		}
		sl.setStation(st);
		
		
		session.persist(sl);
		tx.commit();
		session.close();
	}

	@Override
	public void updateSchedule(SessionFactory sf) {
	    session = sf.openSession();

	    try {
	        while (true) {
	            System.out.println("Choose an Option for Update:" +
	                               "\n1. Update train_id" +
	                               "\n2. Update station_id" +
	                               "\n3. Update arrival_time" +
	                               "\n4. Update departure_time" +
	                               "\n5. Exit");

	            int option = sc.nextInt();
	            sc.nextLine(); // Consume newline left from nextInt

	            Schedules sl = new Schedules();
	            int scheduleId;
                Transaction tx = session.beginTransaction();

	            switch (option) {
	                case 1:
	                    System.out.println("Enter schedule_id:");
	                    scheduleId = sc.nextInt();
	                    sl = session.get(Schedules.class, scheduleId);

	                    if (sl == null) {
	                        System.out.println("Schedule ID not found.");
	                        break;
	                    }

	                    System.out.println("Enter new train_id:");
	                    int tr_id = sc.nextInt();
	                    Trains tr = session.get(Trains.class, tr_id);

	                    if (tr != null) {
	                        sl.setTrain(tr);
	                        session.update(sl);
	                        tx.commit();
	                        System.out.println("Train ID updated successfully.");
	                    } else {
	                        System.out.println("Train ID not found.");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter schedule_id:");
	                    scheduleId = sc.nextInt();
	                    sl = session.get(Schedules.class, scheduleId);

	                    if (sl == null) {
	                        System.out.println("Schedule ID not found.");
	                        break;
	                    }

	                    System.out.println("Enter new station_id:");
	                    int st_id = sc.nextInt();
	                    Stations st = session.get(Stations.class, st_id);

	                    if (st != null) {
	                        sl.setStation(st);
	                        session.update(sl);
	                        tx.commit();
	                        System.out.println("Station ID updated successfully.");
	                    } else {
	                        System.out.println("Station ID not found.");
	                    }
	                    break;

	                case 3:
	                    System.out.println("Enter schedule_id:");
	                    scheduleId = sc.nextInt();
	                    sc.nextLine(); // Consume newline
	                    sl = session.get(Schedules.class, scheduleId);

	                    if (sl == null) {
	                        System.out.println("Schedule ID not found.");
	                        break;
	                    }

	                    System.out.println("Enter new Arrival Time (yyyy-MM-dd HH:mm):");
	                    String arrivalTimeInput = sc.nextLine();

	                    try {
	                        LocalDateTime arrivalTime = LocalDateTime.parse(arrivalTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	                        sl.setArrival_time(arrivalTime);
	                        session.update(sl);
	                        tx.commit();
	                        System.out.println("Arrival time updated successfully.");
	                    } catch (Exception e) {
	                        System.out.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
	                    }
	                    break;

	                case 4:
	                    System.out.println("Enter schedule_id:");
	                    scheduleId = sc.nextInt();
	                    sc.nextLine(); // Consume newline
	                    sl=session.get(Schedules.class, scheduleId);

	                    if (sl == null) {
	                        System.out.println("Schedule ID not found.");
	                        break;
	                    }

	                    System.out.println("Enter new Departure Time (yyyy-MM-dd HH:mm):");
	                    String departureTimeInput = sc.nextLine();

	                    try {
	                        LocalDateTime departureTime = LocalDateTime.parse(departureTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	                        sl.setDeparture_time(departureTime);
	                        session.update(sl);
	                        tx.commit();
	                        System.out.println("Departure time updated successfully.");
	                    } catch (Exception e) {
	                        System.out.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
	                    }
	                    break;

	                case 5:
	                    System.out.println("Exiting update...");
	                    return;

	                default:
	                    System.out.println("Choose a valid option!");
	            }
	        }
	    } finally {
	        session.close();
	    }
	}
	@Override
	public void deleteSchedule(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter schedule_id:");
		int id = sc.nextInt();

		Schedules emp = session.get(Schedules.class, id);
		try {
			if (emp!= null) {
				session.delete(emp);
				tx.commit();

			} else {
				System.out.println("Please Enter valid schedule_id");

			}
		} finally {
			session.close();

		}
		
	
		}

	@Override
	public void getAllSchedule(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Schedules");
			List<Schedules> resultList = query.getResultList();

			for (Schedules c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();
	   }

	

	@Override
	public void getSchedule(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		System.out.println("Enter schedule_id:");
		int id = sc.nextInt();
		Schedules  c = session.get(Schedules.class, id);
		System.out.println(c);
		session.close();
	}

	

	@Override
	public void getScheduleInformation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();

		Query query = session.createQuery("select count(schedule_id) from Schedules");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Schedules:" + list.get(0));
		session.close();

	}

}
