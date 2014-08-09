package com.mobmaxime.database;


public class contact {

	int id;
	String name, address, phone_number;

	public contact() {

	}

	public contact(int id, String name, String address, String number) {
		this.address = address;
		this.id = id;
		this.name = name;
		this.phone_number = number;
	}
	
	public contact(String name, String address, String number) {
		this.address = address;
		this.name = name;
		this.phone_number = number;
	}
	
	public contact(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// get Name
	public String getName() {
		return this.name;
	}

	// set Name
	public void setName(String name) {
		this.name = name;
	}
	
	// get Address
	public String getAddress() {
		return this.address;
	}

	// set Address
	public void setAddress(String address) {
		this.address = address;
	}

	// get Phone
	public String getPhone_number() {
		return this.phone_number;
	}

	//set Phone
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

}
