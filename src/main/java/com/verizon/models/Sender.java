package com.verizon.models;

public class Sender {

	private Long senderId;

	private String channel;

	private String company;

	public Sender() {
	}

	public Sender(Long senderId, String channel, String company) {
		this.senderId = senderId;
		this.channel = channel;
		this.company = company;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
