package com.pinnacle.bus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class Vehicle {

	@Id
	private String id;

	private String name;

	private String number;

	private int seats;
	private String type;

	public Vehicle() {
		super();
	}

	public Vehicle(String name, String number, int seats, String type, String id) {
		super();
		this.name = name;
		this.number = number;
		this.seats = seats;
		this.type = type;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", number=" + number + ", seats=" + seats + ", type=" + type + ", id=" + id
				+ "]";
	}

}