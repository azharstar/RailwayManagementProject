package com.RailwayManagementProject.ServiceImplementation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RailwayManagementProject.Entities.Employees;
import com.RailwayManagementProject.Entities.Seats;
import com.RailwayManagementProject.Entities.Stations;
import com.RailwayManagementProject.Entities.Tickets;
import com.RailwayManagementProject.Entities.Trains;
import com.RailwayManagementProject.Service.SeatsService;
import com.RailwayManagementProject.utility.AvailabilityCriteriaException;
public class SeatsServiceImpl implements SeatsService{
	Scanner sc=new Scanner(System.in);
	  Session session;
	@Override
	public void insertSeats(SessionFactory sf) throws AvailabilityCriteriaException {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Seats se= new Seats();
         
		System.out.println("Welcome to Seats");
		System.out.println("Enter seat_id : ");
		int id = sc.nextInt();
		se.setSeat_id(id);

		System.out.println("Enter Train Id :");
		int train_id = sc.nextInt();
		sc.nextLine();
		Trains tr=session.get(Trains.class,train_id);
		if(tr==null) {
			System.out.println("Train not found.Please enter a valid train_id");
			return;
		}
		se.setTrain_id(tr);
		
		System.out.println("Enter seat_number:");
	    String seat_number  =sc.next();
		se.setSeat_number(seat_number);
		
		System.out.println("Enter classes:");
	    String classes=sc.next();
		se.setClasses(classes);
		sc.nextLine();
		
		System.out.println("Enter availability:");
		String availability  =sc.next();
		
		int seatsAvailable = checkAvailability(availability);

        if (seatsAvailable == 0) {
            session.close();
            throw new AvailabilityCriteriaException("We are sorry, there are no seats available in this class. Please choose another class.");
        }
		se.setAvailability(availability);
		
		session.persist(se);
		tx.commit();
		session.close();
		}

	    public int checkAvailability(String availability) {
	        if ("No".equalsIgnoreCase(availability)) {
	            return 0;
	        } else {
	            return 1;
	        }
	    }
	
	@Override
	public void updateSeats(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
	    Transaction tx = session.beginTransaction();

	    Seats  se;

	    try {
	        while (true) {
	            System.out.println("Choose an Option for Update:" +
	                               "\n1. Update train_id "+
	                               "\n2. Update seat_number "+
	                               "\n3. Update class"+
	                               "\n4. Update availability"+
	                               "\n5. Exit");

	            int option = sc.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter seat_id :");
	                    
	                    se = session.get(Seats.class,sc.nextInt());
                        
	                    System.out.println("Update train_id:");
	                    int tr_id=sc.nextInt();
	                    Trains tr=session.get(Trains.class,tr_id);
	                    
	                    if (tr != null) {
	                    	se.setTrain_id(tr);
	                    	session.saveOrUpdate(tr);
	                    	tx.commit();
	                    	System.out.println("Train id updated successfully");
	                        
	                      } else {
	                        System.out.println("train_id not found for the given Id");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter seat_id:");
	                    se=session.get(Seats.class,sc.nextInt());
	                    if(se!=null) {
	                        System.out.println("Update seat_number :");
	                        se.setSeat_number(sc.next());
	                        session.saveOrUpdate(se);
	                        tx.commit();
	                        System.out.println("seat_number updated successfully");
	                        }
	                     else {
	                        	System.out.println("seat_number not found for the given id");
	                        }
	                        
	                      break;
	                case 3:
	                	System.out.println("Enter seat_id:");
	                    se=session.get(Seats.class,sc.nextInt());
	                    if(se!=null) {
	                        System.out.println("Update 	class :");
	                        se.setClasses(sc.next());
	                        session.saveOrUpdate(se);
	                        tx.commit();
	                        System.out.println("seat_number  updated successfully");
	                        }
	                     else {
	                        	System.out.println("seat_number  not found for the given id");
	                        }
	                        
	                    break;
	                   
	                      
	        case 4:
            	System.out.println("Enter seat_id:");
                se=session.get(Seats.class,sc.nextInt());
                if(se!=null) {
                    System.out.println("Update availability  :");
                    se.setAvailability(sc.next());
                    session.saveOrUpdate(se);
                    tx.commit();
                    System.out.println("availability  updated successfully");
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
	public void deleteSeats(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter seat_id :");
		int id = sc.nextInt();

		Seats se = session.get(Seats.class, id);
		try {
			if (se!= null) {
				session.delete(se);
				tx.commit();

			} else {
				System.out.println("Please Enter valid seat_id");

			}
		} finally {
			session.close();

		}

	}


	@Override
	public void getAllSeats(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Seats");
			List<Seats> resultList = query.getResultList();

			for (Seats c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();

	}

	@Override
	public void getSeats(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		System.out.println("Enter seat_id:");
		int id = sc.nextInt();
		Seats  c = session.get(Seats.class, id);
		System.out.println(c);
		session.close();

	}

	@Override
	public void getSeatsInformation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();

		Query query = session.createQuery("select count(seat_id) from Seats");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Seats:" + list.get(0));
		session.close();

	}

}
