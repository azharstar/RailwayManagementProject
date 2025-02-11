package com.RailwayManagementProject.Service;

import org.hibernate.SessionFactory;

public interface TrainService {
	
	
		void insertTrain(SessionFactory sf);
		void updateTrain(SessionFactory sf);
		void deleteTrain(SessionFactory sf);
		void getAllTrain(SessionFactory sf);
		void getTrain(SessionFactory sf);
		void getTrainInformation(SessionFactory sf);
		
	}
