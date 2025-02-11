package com.RailwayManagementProject.Service;

import org.hibernate.SessionFactory;

public interface TicketsService {
	void insertTickets(SessionFactory sf);
	void updateTickets(SessionFactory sf);
	void deleteTickets(SessionFactory sf);
	void getAllTickets(SessionFactory sf);
	void getTickets(SessionFactory sf);
	void getTicketsInformation(SessionFactory sf);
}



