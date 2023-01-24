package com.bitlabs.hibtut1;

import javax.persistence.Entity;//important
import javax.persistence.Id;

@Entity
public class Emp {
	@Id
	private int id;
	private String name;
	private String address;
	private String contact;
	private String email;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp(String name, String address, String contact, String email) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}

	public Emp(int id, String name, String address, String contact, String email) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", email=" + email
				+ "]";
	}
	

}
