package com.RailwayManagementProject.ServiceImplementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RailwayManagementProject.Entities.Maintenance_Record;
import com.RailwayManagementProject.Entities.Schedules;
import com.RailwayManagementProject.Entities.Seats;
import com.RailwayManagementProject.Entities.Trains;
import com.RailwayManagementProject.Service.MaintenanceRecordService;

public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {
	Scanner sc=new Scanner(System.in);
	  Session session;
	@Override
	public void insertMaintenanceRecord(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Maintenance_Record mr = new Maintenance_Record();
		
		System.out.println("Welcome to MaintenanceRecord");
		System.out.println("Enter record id: ");
		int id = sc.nextInt();
		mr.setRecord_id(id);

		System.out.println("Enter Description");
		String  Des = sc.next();
		mr.setDescription(Des);
		
		System.out.print("Enter maintenance_date  (yyyy-MM-dd HH:mm): ");
		sc.nextLine(); // Consume newline character left by nextInt()
		String maintenancedateInput = sc.nextLine();

		try {
		    // Parse the input string into LocalDateTime
		    LocalDateTime maintenance_date = LocalDateTime.parse(maintenancedateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		    mr.setMaintenance_date(maintenance_date);
		} catch (Exception e) {
		    System.out.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
		}
		
		System.out.println("Enter  Train_id:");
          int train_id = sc.nextInt();
		   sc.nextLine();

		Trains tr=session.get(Trains.class,train_id);
		if(tr==null) {
			System.out.println("Train not found.Please enter a valid train_id");
			return;
		}
		mr.setTrain_id(tr);

		
		session.persist(mr);
		tx.commit();
		session.close();

		
	}
	@Override
	public void updateMaintenanceRecord(SessionFactory sf) {
        try (Session session = sf.openSession()) {
            while (true) {
                System.out.println("Choose an Option for Update:" +
                                   "\n1. Update train_id" +
                                   "\n2. Update maintenance_date" +
                                   "\n3. Update description" +
                                   "\n4. Exit");

                int option = sc.nextInt();
                sc.nextLine();

                Maintenance_Record mr;
                int record_id;

                switch (option) {
                    case 1:
                        System.out.println("Enter record_id:");
                        record_id = sc.nextInt();
                        sc.nextLine();
                        mr = session.get(Maintenance_Record.class, record_id);

                        if (mr == null) {
                            System.out.println("record_id not found.");
                            break;
                        }

                        System.out.println("Enter new train_id:");
                        int tr_id = sc.nextInt();
                        sc.nextLine();
                        Trains tr = session.get(Trains.class, tr_id);

                        if (tr != null) {
                            Transaction tx = session.beginTransaction();
                            mr.setTrain_id(tr);
                            session.update(mr);
                            tx.commit();
                            System.out.println("Train ID updated successfully.");
                        } else {
                            System.out.println("Train ID not found.");
                        }
                        break;

                    case 2:
                        System.out.println("Enter record_id:");
                        record_id = sc.nextInt();
                        sc.nextLine();
                        mr = session.get(Maintenance_Record.class, record_id);

                        if (mr == null) {
                            System.out.println("Record ID not found.");
                            break;
                        }

                        System.out.println("Enter new maintenance_date (yyyy-MM-dd HH:mm):");
                        String maintenancedateInput = sc.nextLine();

                        try {
                            LocalDateTime maintenance_date = LocalDateTime.parse(maintenancedateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            Transaction tx = session.beginTransaction();
                            mr.setMaintenance_date(maintenance_date);
                            session.update(mr);
                            tx.commit();
                            System.out.println("Maintenance date updated successfully.");
                        } catch (Exception e) {
                            System.out.println("Invalid date format. Please use 'yyyy-MM-dd HH:mm'.");
                        }
                        break;

                    case 3:
                        System.out.println("Enter record_id:");
                        record_id = sc.nextInt();
                        sc.nextLine();
                        mr = session.get(Maintenance_Record.class, record_id);

                        if (mr == null) {
                            System.out.println("Record ID not found.");
                            break;
                        }

                        System.out.println("Update Description:");
                        String description = sc.nextLine();
                        Transaction tx = session.beginTransaction();
                        mr.setDescription(description);
                        session.update(mr);
                        tx.commit();
                        System.out.println("Description updated successfully.");
                        break;

                    case 4:
                        System.out.println("Exiting update...");
                        return;

                    default:
                        System.out.println("Choose a valid option!");
                }
            }
        }
    }


	@Override
	public void deleteMaintenanceRecord(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter record_id:");
		int id = sc.nextInt();

		Maintenance_Record mr = session.get(Maintenance_Record.class, id);
		try {
			if (mr!= null) {
				session.delete(mr);
				tx.commit();

			} else {
				System.out.println("Please Enter valid record_id");

			}
		} finally {
			session.close();

		}
		
	
		}

	
	@Override
	public void getAllMaintenanceRecord(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Maintenance_Record");
			List<Maintenance_Record> resultList = query.getResultList();

			for (Maintenance_Record c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();
	   }


	
	@Override
	public void getMaintenanceRecord(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		System.out.println("Enter record_id:");
		int id = sc.nextInt();
		Maintenance_Record  c = session.get(Maintenance_Record.class, id);
		System.out.println(c);
		session.close();
	}
	@Override
	public void getMaintenanceRecordInformation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();

		Query query = session.createQuery("select count(record_id) from Maintenance_Record");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Maintenance_Record:" + list.get(0));
		session.close();


	}

}
