package com.shaswotdhungana.One2Many_Many2OneMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	private int id;
	
	private String addressType;
	private String address;
	
	// For bidirectional
	@ManyToOne
	private EmpDtls empdtls;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressType() {
		return addressType;
	}
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public EmpDtls getEmpdtls() {
		return empdtls;
	}
	public void setEmpdtls(EmpDtls empdtls) {
		this.empdtls = empdtls;
	}
	public Address(int id, String addressType, String address) {
		super();
		this.id = id;
		this.addressType = addressType;
		this.address = address;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
