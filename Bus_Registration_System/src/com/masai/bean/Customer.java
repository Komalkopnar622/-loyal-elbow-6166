package com.masai.bean;

public class Customer {
	private int cid;
	private String cname;
	private String address;
	private String mobile;
	private String source;
	private String destination;
	
	public Customer() {
		
	}

	public Customer(int cid, String cname, String address, String mobile, String source, String destination) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.address = address;
		this.mobile = mobile;
		this.source = source;
		this.destination = destination;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", address=" + address + ", mobile=" + mobile + ", source="
				+ source + ", destination=" + destination + "]";
	}
	
	

}


