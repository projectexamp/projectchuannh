package com.aht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_FUNCTION")
//@Where(clause = "status = '0'") them dieu kien cho findAll
public class Function {
	@Id
	@Column(name = "FUNCTION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "STATUS")
	private int status;
	@Column(name = "FUNCTION_ORDER")
	private int functionOrder;
	@Column(name = "FUNCTION_URL")
	private String functionUrl;
	@Column(name = "FUNCTION_NAME")
	private String functionName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "FUNCTION_CODE")
	private String functionCode;

	public Function() {
	}

	public Function(int id, int status, int functionOrder, String functionUrl, String functionName, String description,
			String functionCode) {
		this.id = id;
		this.status = status;
		this.functionOrder = functionOrder;
		this.functionUrl = functionUrl;
		this.functionName = functionName;
		this.description = description;
		this.functionCode = functionCode;
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

	public int getFunctionOrder() {
		return functionOrder;
	}

	public void setFunctionOrder(int functionOrder) {
		this.functionOrder = functionOrder;
	}

	public String getFunctionUrl() {
		return functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

}
