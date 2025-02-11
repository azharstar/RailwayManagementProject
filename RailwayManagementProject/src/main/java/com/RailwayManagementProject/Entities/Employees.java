package com.RailwayManagementProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {
	@Id
	private int employee_id; 
	private String name; 
		private String position; 
		@ManyToOne
		@JoinColumn
		private Stations station_id;
		public int getEmployee_id() {
			return employee_id;
		}
		public void setEmployee_id(int employee_id) {
			this.employee_id = employee_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public Stations getStation_id() {
			return station_id;
		}
		public void setStation_id(Stations station_id) {
			this.station_id = station_id;
		}
		public Employees() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employees(int employee_id, String name, String position, Stations station_id) {
			super();
			this.employee_id = employee_id;
			this.name = name;
			this.position = position;
			this.station_id = station_id;
		}
		@Override
		public String toString() {
			return "Employees [employee_id=" + employee_id + ", name=" + name + ", position=" + position
					+ ", station_id=" + station_id + "]";
		} 

}

