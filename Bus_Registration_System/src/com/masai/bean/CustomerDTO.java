package com.masai.bean;

public class CustomerDTO {
	private int bno;
	private String busname;
	private int seat;
	private String cn;
	private String m;
	private String a;
	
	public CustomerDTO(int bn, String busn, int seat, String cn, String m, String a){
		super();
		this.bno = bn;
		this.busname = busn;
		this.seat = seat;
		this.cn = cn;
		this.m = m;
		this.a = a;
	}
	
	





	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}


	public CustomerDTO(int bn, int seat) {
		super();
		this.bno = bn;
		
		this.seat = seat;
	}




	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	

}
