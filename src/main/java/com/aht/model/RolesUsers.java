package com.aht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ROLE_USER")
public class RolesUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_USER_ID")
	private int id;
	@Column(name = "IS_ACTIVE")
	private boolean isActive = true;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;

	public RolesUsers() {
	}

	public RolesUsers(int id, boolean isActive, Users user, Role role) {
		this.id = id;
		this.isActive = isActive;
		this.user = user;
		this.role = role;
	}

	public RolesUsers(boolean isActive, Users user, Role role) {
		this.isActive = isActive;
		this.user = user;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
