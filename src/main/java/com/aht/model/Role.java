package com.aht.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ROLE")
//@Where(clause = "status in(0,1)")
public class Role {
	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "STATUS")
	private int status;
	@Column(name = "ROLE_NAME")
	private String roleName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ROLE_CODE")
	private String roleCode;
	@Column(name = "ROLE_ORDER")
	private int roleOrder;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
	private List<Users> users;

	public Role() {
	}

	public Role(int id, int status, String roleName, String description, String roleCode, int roleOrder,
			List<Users> users) {
		this.id = id;
		this.status = status;
		this.roleName = roleName;
		this.description = description;
		this.roleCode = roleCode;
		this.roleOrder = roleOrder;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public int getRoleOrder() {
		return roleOrder;
	}

	public void setRoleOrder(int roleOrder) {
		this.roleOrder = roleOrder;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}
