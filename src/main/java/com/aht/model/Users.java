package com.aht.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_USER")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int id;
	@Column(name = "USER_NAME")
	private String username;
	@Column(name = "FULL_NAME")
	private String fullName;
	@Column(name = "GENDER")
	private int gender;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "STATUS")
	private int status;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TBL_ROLE_USER", 
	joinColumns = @JoinColumn(name = "USER_ID", nullable = false), 
	inverseJoinColumns = @JoinColumn(name = "ROLE_ID", nullable = false))
	private List<Role> roles;
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//	private Set<RoleUser> roleUser;

	public Users() {

	}

	public Users(int id, String username, String fullName, int gender, String password, int status, List<Role> roles) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.gender = gender;
		this.password = password;
		this.status = status;
		this.roles = roles;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
