package com.RailwayManagementProject.ServiceImplementation;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.RailwayManagementProject.Entities.Trains;
import com.RailwayManagementProject.Service.TrainService;

public class TrainServiceImpl implements TrainService{
	  Scanner sc=new Scanner(System.in);
	  Session session;
	@Override
	public void insertTrain(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
         Trains tr = new Trains();
		System.out.println("Welcome to Trains");
		System.out.println("Enter Train Id: ");
		int id = sc.nextInt();
		tr.setTrain_id(id);

		System.out.println("Enter Train number:");
		String Train_number = sc.next();
		tr.setTrain_number(Train_number);
		
		System.out.println("Enter Train Capacity:");
	    int Capacity=sc.nextInt();
		tr.setCapacity(Capacity);
		
		System.out.println("Enter Train type:");
		String Type = sc.next();
		tr.setType(Type);


		session.persist(tr);
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateTrain(SessionFactory sf) {
	    Scanner sc = new Scanner(System.in); // Use a dedicated scanner if not globally initialized
	    session = sf.openSession();
	    Trains tr;

	    try {
	        while (true) {
	            System.out.println("Choose an Option for Update:" +
	                               "\n1. Update Train_number" +
	                               "\n2. Update Type" +
	                               "\n3. Update Capacity" +
	                               "\n4. Exit");

	            int option = sc.nextInt();
	            switch (option) {
	                case 1:
	                    System.out.println("Enter Train Id:");
	                    int trainId = sc.nextInt();
	                    tr = session.get(Trains.class, trainId);

	                    if (tr != null) {
	                        System.out.println("Enter new Train_number:");
	                        String trainNumber = sc.next();
	                        tr.setTrain_number(trainNumber);

	                        Transaction tx = session.beginTransaction();
	                        try {
	                            session.saveOrUpdate(tr);
	                            tx.commit();
	                            System.out.println("Train number updated successfully");
	                        } catch (Exception e) {
	                            tx.rollback();
	                            System.out.println("Failed to update Train_number: " + e.getMessage());
	                        }
	                    } else {
	                        System.out.println("Train not found for the given Id");
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter Train Id:");
	                    trainId = sc.nextInt();
	                    tr = session.get(Trains.class, trainId);

	                    if (tr != null) {
	                        System.out.println("Enter new Train type:");
	                        String type = sc.next();
	                        tr.setType(type);

	                        Transaction tx = session.beginTransaction();
	                        try {
	                            session.saveOrUpdate(tr);
	                            tx.commit();
	                            System.out.println("Train type updated successfully");
	                        } catch (Exception e) {
	                            tx.rollback();
	                            System.out.println("Failed to update Type: " + e.getMessage());
	                        }
	                    } else {
	                        System.out.println("Train not found for the given Id");
	                    }
	                    break;

	                case 3:
	                    System.out.println("Enter Train Id:");
	                    trainId = sc.nextInt();
	                    tr = session.get(Trains.class, trainId);

	                    if (tr != null) {
	                        System.out.println("Enter new Train capacity:");
	                        int capacity = sc.nextInt();
	                        tr.setCapacity(capacity);

	                        Transaction tx = session.beginTransaction();
	                        try {
	                            session.saveOrUpdate(tr);
	                            tx.commit();
	                            System.out.println("Train capacity updated successfully");
	                        } catch (Exception e) {
	                            tx.rollback();
	                            System.out.println("Failed to update Capacity: " + e.getMessage());
	                        }
	                    } else {
	                        System.out.println("Train not found for the given Id");
	                    }
	                    break;

	                case 4:
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
	public void deleteTrain(SessionFactory sf) {
		// TODO Auto-generated method stub
			session = sf.openSession();
			Transaction tx = session.beginTransaction();

			System.out.println("Enter Train Id:");
			int id = sc.nextInt();

			Trains tr = session.get(Trains.class, id);
			try {
				if (tr!= null) {
					session.delete(tr);
					tx.commit();

				} else {
					System.out.println("Please Enter valid Train Id");

				}
			} finally {
				session.close();

			} 
		}
	@Override
	public void getAllTrain(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Trains");
			List<Trains> resultList = query.getResultList();

			for (Trains c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();
	   }
	@Override
	public void getTrain(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();
		System.out.println("Enter Train Id:");
		int id = sc.nextInt();
		Trains c = session.get(Trains.class, id);
		System.out.println(c);
		session.close();
	}

	@Override
	public void getTrainInformation(SessionFactory sf) {
		// TODO Auto-generated method stub
		session = sf.openSession();

		Query query = session.createQuery("select count(train_id) from Trains");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Trains:" + list.get(0));
		session.close();

	}

}

