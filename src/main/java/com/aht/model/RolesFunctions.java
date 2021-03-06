package com.aht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ROLE_FUNCTION")
public class RolesFunctions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_FUNCTION_ID")
	private int id;
	@Column(name = "IS_ACTIVE")
	private boolean isActive = true;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private Role role;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FUNCTION_ID")
	private Function function;

	public RolesFunctions() {
	}

	public RolesFunctions(int id, boolean isActive, Role role, Function function) {
		this.id = id;
		this.isActive = isActive;
		this.role = role;
		this.function = function;
	}

	public RolesFunctions(boolean isActive, Role role, Function function) {
		this.isActive = isActive;
		this.role = role;
		this.function = function;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}
