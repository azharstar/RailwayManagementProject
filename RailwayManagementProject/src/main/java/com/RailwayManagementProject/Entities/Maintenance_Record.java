package com.RailwayManagementProject.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Maintenance_Record")
public class Maintenance_Record {
	@Id
	private int	record_id; 
	@Override
	public String toString() {
		return "Maintenance_Record [record_id=" + record_id + ", train_id=" + train_id + ", maintenance_date="
				+ maintenance_date + ", description=" + description + "]";
	}
	@ManyToOne
	@JoinColumn(name="train_id")
	private Trains train_id; 
	private LocalDateTime maintenance_date; 
	private String description;
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public Trains getTrain_id() {
		return train_id;
	}
	public void setTrain_id(Trains train_id) {
		this.train_id = train_id;
	}
	public LocalDateTime getMaintenance_date() {
		return maintenance_date;
	}
	public void setMaintenance_date(LocalDateTime localDateTime) {
		this.maintenance_date = localDateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Maintenance_Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
