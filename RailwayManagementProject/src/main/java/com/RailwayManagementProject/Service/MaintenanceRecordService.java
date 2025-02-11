package com.RailwayManagementProject.Service;

import org.hibernate.SessionFactory;

public interface MaintenanceRecordService {
	void insertMaintenanceRecord(SessionFactory sf);
	void updateMaintenanceRecord(SessionFactory sf);
	void deleteMaintenanceRecord(SessionFactory sf);
	void getAllMaintenanceRecord(SessionFactory sf);
	void getMaintenanceRecord(SessionFactory sf);
	void getMaintenanceRecordInformation(SessionFactory sf);

}
