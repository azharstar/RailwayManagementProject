package com.RailwayManagementProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Seats")
public class Seats {
	@Id
	private int	seat_id;
	@ManyToOne
	@JoinColumn(name="Trains")
 private Trains train_id; 
	private String seat_number;
    private String Classes;
	private String availability;
	
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public Trains getTrain_id() {
		return train_id;
	}
	public void setTrain_id(Trains train_id) {
		this.train_id = train_id;
	}
	public String getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}
	public String getClasses() {
		return Classes;
	}
	public void setClasses(String classes) {
		Classes = classes;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Seats() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seats(int seat_id, Trains train_id, String seat_number, String classes, String availability) {
		super();
		this.seat_id = seat_id;
		this.train_id = train_id;
		this.seat_number = seat_number;
		this.Classes = classes;
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Seats [seat_id=" + seat_id + ", train_id=" + train_id + ", seat_number=" + seat_number + ", Classes="
				+ Classes + ", availability=" + availability + "]";
	}
	
		}

