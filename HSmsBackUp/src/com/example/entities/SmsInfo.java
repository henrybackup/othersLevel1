package com.example.entities;

public class SmsInfo {
	private int id;
	private String address;
	private long date;
	private String body;
	private int type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "SmsInfo [id=" + id + ", address=" + address + ", date=" + date
				+ ", body=" + body + ", type=" + type + "]";
	}

	public SmsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmsInfo(int id, String address, long date, String body, int type) {
		super();
		this.id = id;
		this.address = address;
		this.date = date;
		this.body = body;
		this.type = type;
	}
}
