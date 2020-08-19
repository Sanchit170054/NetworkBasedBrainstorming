package org.application.my.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	public User() {

	}

	@Id
	private int id;
	private String username;
	private String password;
	private String usertype;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", usertype=" + usertype + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public User(String username, String password, String usertype) {
		super();
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}



}
