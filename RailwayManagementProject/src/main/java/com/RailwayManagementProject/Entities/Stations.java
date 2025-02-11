package com.RailwayManagementProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="stations")
public class Stations {
	@Id
		private int station_id; 
		private String station_name; 
	private String location;
	@Override
	public String toString() {
		return "Stations [station_id=" + station_id + ", station_name=" + station_name + ", location=" + location + "]";
	}
	public int getStation_id() {
		return station_id;
	}
	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Stations() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stations(int station_id, String station_name, String location) {
		super();
		this.station_id = station_id;
		this.station_name = station_name;
		this.location = location;
	}
	
}
