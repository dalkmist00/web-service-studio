package com.studio.app.dynamo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "${spring.dynamo.tablename}")
public class PersistentObject {
	@DynamoDBHashKey(attributeName = "pk")
	private String pk;
	@DynamoDBRangeKey(attributeName = "sk")
	private String sk;
	@DynamoDBAttribute(attributeName = "username")
	private String username;
	@DynamoDBAttribute(attributeName = "password")
	private String password;
	@DynamoDBAttribute(attributeName = "creation_date")
	private String creationDate;
	
	public PersistentObject() {
		super();
	}

	public String getPk() {
		return pk;
	}

	public String getSk() {
		return sk;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public void setSk(String sk) {
		this.sk = sk;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "PersistentObject [pk=" + pk + ", sk=" + sk + ", username=" + username + ", password=" + password
				+ ", creationDate=" + creationDate + "]";
	}
}
