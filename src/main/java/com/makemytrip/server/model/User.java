
package com.makemytrip.server.model;


import org.springframework.data.annotation.Id;



import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="LoginUser")
public class User {

	@Id
	private String id;
	
	private String name;
	private String email;
	private long contact;
	private String password;

	
	public User() {
		super();
	}
	public User(String name, String email, long contact, String password) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	public User(String id, String name, String email, long contact, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	public String getId() {
		return this.id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

