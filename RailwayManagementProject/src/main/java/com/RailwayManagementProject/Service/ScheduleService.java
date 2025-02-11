package com.RailwayManagementProject.Service;

import org.hibernate.SessionFactory;

public interface ScheduleService {
		void insertSchedule(SessionFactory sf);
		void updateSchedule(SessionFactory sf);
		void deleteSchedule(SessionFactory sf);
		void getAllSchedule(SessionFactory sf);
		void getSchedule(SessionFactory sf);
		void getScheduleInformation(SessionFactory sf);
	}


