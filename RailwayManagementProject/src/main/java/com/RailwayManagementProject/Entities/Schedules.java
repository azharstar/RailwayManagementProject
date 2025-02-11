package com.RailwayManagementProject.Entities;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedules {
    @Id
    private int schedule_id;

    @ManyToOne
    @JoinColumn(name = "train_id") // Foreign key for train
    private Trains train;

    @ManyToOne
    @JoinColumn(name = "station_id") // Foreign key for station
    private Stations station;

    private LocalDateTime arrival_time;
    @Override
	public String toString() {
		return "Schedules [schedule_id=" + schedule_id + ", train=" + train + ", station=" + station + ", arrival_time="
				+ arrival_time + ", departure_time=" + departure_time + "]";
	}

	private LocalDateTime departure_time;

    // Getters and Setters
    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public Trains getTrain() {
        return train;
    }

    public void setTrain(Trains train) {
        this.train = train;
    }

    public Stations getStation() {
        return station;
    }

    public void setStation(Stations station) {
        this.station = station;
    }

    public LocalDateTime getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(LocalDateTime arrival_time) {
        this.arrival_time = arrival_time;
    }

    public LocalDateTime getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
        this.departure_time = departure_time;
    }

    // Constructors
    public Schedules() {
        super();
    }

    public Schedules(int schedule_id, Trains train, Stations station, LocalDateTime arrival_time, LocalDateTime departure_time) {
        this.schedule_id = schedule_id;
        this.train = train;
        this.station = station;
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
    }
}
