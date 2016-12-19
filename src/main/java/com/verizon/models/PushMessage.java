package com.verizon.models;

import com.verizon.models.Message;

public class PushMessage {

	private Message message;

	public PushMessage() {
	}

	public PushMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
