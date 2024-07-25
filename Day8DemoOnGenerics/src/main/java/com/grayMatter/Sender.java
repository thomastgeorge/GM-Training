package com.grayMatter;

public class Sender <T>{
	
	T msg;
	
	public void setMsg(T msg) {
		this.msg=msg;
	}
	
	public void sendMsg() {
		System.out.println("From class Sender msg to Reciever " + msg);
	}
	
	public static void main(String[] args) {
		Sender<String> strMsg = new Sender<>();
		strMsg.setMsg("Hello");
		strMsg.sendMsg();
	}

}
