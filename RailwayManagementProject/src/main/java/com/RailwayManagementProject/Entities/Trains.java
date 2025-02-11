package com.RailwayManagementProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trains")
public class Trains {
	@Id
	private int train_id;
    private String train_number; 
	private String  type;
	private int capacity;
	public int getTrain_id() {
		return train_id;
	}
	public void setTrain_id(int train_id) {
		this.train_id = train_id;
	}
	public String getTrain_number() {
		return train_number;
	}
	@Override
	public String toString() {
		return "Trains [train_id=" + train_id + ", train_number=" + train_number + ", type=" + type + ", capacity="
				+ capacity + "]";
	}
	public void setTrain_number(String train_number) {
		this.train_number = train_number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Trains() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trains(int train_id, String train_number, String type, int capacity) {
		super();
		this.train_id = train_id;
		this.train_number = train_number;
		this.type = type;
		this.capacity = capacity;
	}

}
