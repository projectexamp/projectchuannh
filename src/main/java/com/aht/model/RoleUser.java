//package com.aht.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "TBL_ROLE_USER")
//public class RoleUser {
//	@Id
//	@Column(name = "ROLE_USER_ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	@Column(name = "ROLE_ID")
//	private int roleId;
//	@Column(name = "USER_ID")
//	private String useId;
//	@Column(name = "IS_ACTIVE")
//	private boolean isActive = true;
//	@ManyToOne(cascade = CascadeType.REMOVE)
//	@JoinColumn(name = "id")
//	private Users user;
//
//	public RoleUser() {
//	}
//
//	public RoleUser(int id, int roleId, String useId, boolean isActive, Users user) {
//		super();
//		this.id = id;
//		this.roleId = roleId;
//		this.useId = useId;
//		this.isActive = isActive;
//		this.user = user;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getRoleId() {
//		return roleId;
//	}
//
//	public void setRoleId(int roleId) {
//		this.roleId = roleId;
//	}
//
//	public String getUseId() {
//		return useId;
//	}
//
//	public void setUseId(String useId) {
//		this.useId = useId;
//	}
//
//	public boolean getIsActive() {
//		return isActive;
//	}
//
//	public void setIsActive(boolean isActive) {
//		this.isActive = isActive;
//	}
//
//}
