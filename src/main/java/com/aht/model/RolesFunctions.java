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
//	@Column(name = "FUNCTION_ID")
//	private int functionId;
//	@Column(name = "ROLE_ID")
//	private int roleId;
	@Column(name = "IS_ACTIVE")
	private boolean isActive = true;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private Role roles;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FUNCTION_ID")
	private Function functions;

	public RolesFunctions() {
	}

	public RolesFunctions(int id, boolean isActive, Role roles, Function functions) {
		this.id = id;
		this.isActive = isActive;
		this.roles = roles;
		this.functions = functions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getFunctionId() {
//		return functionId;
//	}
//
//	public void setFunctionId(int functionId) {
//		this.functionId = functionId;
//	}
//
//	public int getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public Function getFunctions() {
		return functions;
	}

	public void setFunctions(Function functions) {
		this.functions = functions;
	}

}
