package com.RailwayManagementProject.ServiceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RailwayManagementProject.Entities.Stations;
import com.RailwayManagementProject.Entities.Tickets;
import com.RailwayManagementProject.Entities.Trains;
import com.RailwayManagementProject.Service.TicketsService;

public class TicketsServiceImpl implements TicketsService{
	Scanner sc=new Scanner(System.in);
	  Session session;

	@Override
	public void insertTickets(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Tickets ti = new Tickets();
         
		System.out.println("Welcome to Tickets");
		System.out.println("Enter Ticket Id: ");
		int id = sc.nextInt();
		ti.setTicket_id(id);

		System.out.println("Enter Train Id :");
		int train_id = sc.nextInt();
		sc.nextLine();
		Trains tr=session.get(Trains.class,train_id);
		if(tr==null) {
			System.out.println("Train not found.Please enter a valid train_id");
			return;
		}
		ti.setTrain(tr);
		
		System.out.println("Enter Passenger Name :");
	    String passenger_name =sc.next();
		ti.setPassenger_name(passenger_name);
		
		System.out.println("Enter Seat number  :");
	    int seat_number  =sc.nextInt();
		ti.setSeat_number(seat_number);

		System.out.println("Enter Price   :");
	    int price  =sc.nextInt();
		ti.setPrice(price);
		
		session.persist(ti);
		tx.commit();
		session.close();
	}

	
	@Override
	public void updateTickets(SessionFactory sf) {
		// TODO Auto-generated method stub
	    session = sf.openSession();
	    Transaction tx = session.beginTransaction();

	    Tickets  ti;

	    try {
	        while (true) {
	            System.out.println("Choose an Option for Update:" +
	                               "\n1. Update train_id " +
	                               "\n2. Update passenger_name"+
	                               "\n3. Update seat_number "+
	                               "\n4. Update price"+
	                               "\n5. Exit");

	            int option = sc.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter ticket_id :");
	                    
	                    ti = session.get(Tickets.class,sc.nextInt());
                        
	                    System.out.println("Update train_id:");
	                    int tr_id=sc.nextInt();
	                    Trains tr=session.get(Trains.class,tr_id);
	                    
	                    if (tr != null) {
	                    	ti.setTicket_id(tr_id);
	                    	session.saveOrUpdate(ti);
	                    	tx.commit();
	                    	System.out.println("Train id updated successfully");
	                        
	                    } else {
	                        System.out.println("train_id not found for the given Id");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter  ticket_id:");
	                    ti=session.get(Tickets.class,sc.nextInt());
	                    if(ti!=null) {
	                        System.out.println("Update passenger_name:");
	                        ti.setPassenger_name(sc.next());
	                        session.saveOrUpdate(ti);
	                        tx.commit();
	                        System.out.println("passenger_name updated successfully");
	                        }
	                     else {
	                        	System.out.println("passenger_name not found for the given id");
	                        }
	                        
	                      break;
	                case 3:
	                	System.out.println("Enter  ticket_id:");
	                    ti=session.get(Tickets.class,sc.nextInt());
	                    if(ti!=null) {
	                        System.out.println("Update seat_number :");
	                        ti.setSeat_number(sc.nextInt());
	                        session.saveOrUpdate(ti);
	                        tx.commit();
	                        System.out.println("seat_number  updated successfully");
	                        }
	                     else {
	                        	System.out.println("seat_number  not found for the given id");
	                        }
	                        
	                    break;
	                   
	                      
	        case 4:
            	System.out.println("Enter  ticket_id:");
                ti=session.get(Tickets.class,sc.nextInt());
                if(ti!=null) {
                    System.out.println("Update price  :");
                    ti.setPrice(sc.nextInt());
                    session.saveOrUpdate(ti);
                    tx.commit();
                    System.out.println("price  updated successfully");
                    }
                 else {
                    	System.out.println("price not found for the given id");
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
	        sc.close();
	    }
	}
	


	
	@Override
	public void deleteTickets(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter ticket_id:");
		int id = sc.nextInt();

		Tickets ti = session.get(Tickets.class, id);
		try {
			if (ti!= null) {
				session.delete(ti);
				tx.commit();

			} else {
				System.out.println("Please Enter valid ticket_id");

			}
		} finally {
			session.close();

		}

	}

	@Override
	public void getAllTickets(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Tickets");
			List<Tickets> resultList = query.getResultList();

			for (Tickets c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();
	   }

	

	@Override
	public void getTickets(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		System.out.println("Enter ticket_id:");
		int id = sc.nextInt();
		Tickets  c = session.get(Tickets.class, id);
		System.out.println(c);
		session.close();

	}

	@Override
	public void getTicketsInformation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();

		Query query = session.createQuery("select count(ticket_id) from Tickets ");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Tickets:" + list.get(0));
		session.close();

	}

}
