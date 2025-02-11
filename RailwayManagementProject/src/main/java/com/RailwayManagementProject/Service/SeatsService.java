package com.RailwayManagementProject.Service;

import org.hibernate.SessionFactory;

import com.RailwayManagementProject.utility.AvailabilityCriteriaException;

public interface SeatsService {
	void insertSeats(SessionFactory sf)throws AvailabilityCriteriaException;
	void updateSeats(SessionFactory sf);
	void deleteSeats(SessionFactory sf);
	void getAllSeats(SessionFactory sf);
	void getSeats(SessionFactory sf);
	void getSeatsInformation(SessionFactory sf);
}
