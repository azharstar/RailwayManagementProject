package com.RailwayManagementProject.Service;

import org.hibernate.SessionFactory;

public interface StationService {
	void insertStation(SessionFactory sf);
	void updateStation(SessionFactory sf);
	void deleteStation(SessionFactory sf);
	void getAllStation(SessionFactory sf);
	void getStation(SessionFactory sf);
	void getStationInformation(SessionFactory sf);
	
}


