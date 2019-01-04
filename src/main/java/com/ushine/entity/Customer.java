package com.ushine.entity;

import org.springframework.data.annotation.Id;

public class Customer {
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	public Customer(){
		
	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
}
