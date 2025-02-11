package com.RailwayManagementProject.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tickets {
    @Id
    private int ticket_id; // Ticket ID as a unique identifier for each ticket

    @ManyToOne
    @JoinColumn(name = "train_id") // Foreign key column for train
    private Trains train; // Reference to the Trains entity

    private String passenger_name;
    private int seat_number;
    private int price;
	public int getTicket_id() {
		return ticket_id;
	}
	@Override
	public String toString() {
		return "Tickets [ticket_id=" + ticket_id + ", train=" + train + ", passenger_name=" + passenger_name
				+ ", seat_number=" + seat_number + ", price=" + price + "]";
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public Trains getTrain() {
		return train;
	}
	public void setTrain(Trains train) {
		this.train = train;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	public int getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tickets(int ticket_id, Trains train, String passenger_name, int seat_number, int price) {
		super();
		this.ticket_id = ticket_id;
		this.train = train;
		this.passenger_name = passenger_name;
		this.seat_number = seat_number;
		this.price = price;
	}

}