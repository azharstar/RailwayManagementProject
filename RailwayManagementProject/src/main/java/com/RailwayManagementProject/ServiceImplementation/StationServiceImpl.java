package com.RailwayManagementProject.ServiceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RailwayManagementProject.Entities.Stations;
import com.RailwayManagementProject.Entities.Trains;
import com.RailwayManagementProject.Service.StationService;

public class StationServiceImpl implements StationService{
	Scanner sc=new Scanner(System.in);
	  Session session;
	@Override
	public void insertStation(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
         Stations st = new Stations();
         
		System.out.println("Welcome to Stations");
		System.out.println("Enter Station Id: ");
		int id = sc.nextInt();
		st.setStation_id(id);

		System.out.println("Enter Station name:");
		String Station_name = sc.next();
		st.setStation_name(Station_name);
		
		System.out.println("Enter Station Location:");
	    String Location=sc.next();
		st.setLocation(Location);
		
		session.persist(st);
		tx.commit();
		session.close();
	}
	@Override
	public void updateStation(SessionFactory sf) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // Use a dedicated scanner if not globally initialized
	    session = sf.openSession();
	    Stations st;

	    try {
	        while (true) {
	            System.out.println("Choose an Option for Update:" +
	                               "\n1. Update station_name " +
	                               "\n2. Update location" +
	                               "\n3. Exit");

	            int option = sc.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter Station Id:");
	                    int StationId = sc.nextInt();
	                    st = session.get(Stations.class, StationId);

	                    if (st != null) {
	                        System.out.println("Enter new Station_name:");
	                        String Station_name= sc.next();
	                        st.setStation_name(Station_name);

	                        Transaction tx = session.beginTransaction();
	                        try {
	                            session.saveOrUpdate(st);
	                            tx.commit();
	                            System.out.println("Station_name updated successfully");
	                        } catch (Exception e) {
	                            tx.rollback();
	                            System.out.println("Failed to update Station_name: " + e.getMessage());
	                        }
	                    } else {
	                        System.out.println("Station_name not found for the given Id");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter Station Id:");
	                    StationId= sc.nextInt();
	                    st = session.get(Stations.class, StationId);

	                    if (st != null) {
	                        System.out.println("Enter new :");
	                        String type = sc.next();
	                        st.setLocation(type);

	                        Transaction tx = session.beginTransaction();
	                        try {
	                            session.saveOrUpdate(st);
	                            tx.commit();
	                            System.out.println("Location updated successfully");
	                        } catch (Exception e) {
	                            tx.rollback();
	                            System.out.println("Failed to update Type: " + e.getMessage());
	                        }
	                    } else {
	                        System.out.println("Location not found for the given Id");
	                    }
	                    break;

	                
	                case 3:
	                    System.out.println("Exiting update...");
	                    return;

	                default:
	                    System.out.println("Choose a valid option!");
	            }
	        }
	    } finally {
	        session.close();
	        sc.close();
	    }
	}


	@Override
	public void deleteStation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Station Id:");
		int id = sc.nextInt();

		Stations st = session.get(Stations.class, id);
		try {
			if (st!= null) {
				session.delete(st);
				tx.commit();

			} else {
				System.out.println("Please Enter valid Station Id");

			}
		} finally {
			session.close();

		}

	}
	@Override
	public void getAllStation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Stations");
			List<Stations> resultList = query.getResultList();

			for (Stations c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();
	   }
	@Override
	public void getStation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		System.out.println("Enter Station Id:");
		int id = sc.nextInt();
		Stations  c = session.get(Stations.class, id);
		System.out.println(c);
		session.close();
	}

	@Override
	public void getStationInformation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();

		Query query = session.createQuery("select count(station_id) from Stations");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Stations:" + list.get(0));
		session.close();
	}
}
