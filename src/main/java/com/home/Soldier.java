package com.home;

public class Soldier {
	private String name;
	private Long num;
	
	private Gun gun;
	
	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public Soldier(){
		this.gun = new Gun();
	}
	
	public void useGun() {
		this.gun.trigger();
	}
}
