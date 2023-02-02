package com.home;

public class Gun {
	private String company;
	private String name;
	
	private Bullet b;
	
	public Gun() {
		this.b = new Bullet();
	}
	public void setB(Bullet b) {
		this.b = b;
	}
	public void trigger() {
		this.b.sound();
	}
}	
