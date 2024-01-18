package com.jacob.zookeeper;

public class Bat extends Mammal {

	public Bat() {
		super(300);
		
	}
	public void fly() {
		int energy = this.getEnergy() - 50;
		this.setEnergy(energy);
	}
	
	public void eatHumans() {
		int energy = this.getEnergy() + 25;
		this.setEnergy(energy);
	}

	
	public void attackTown() {
		int energy = this.getEnergy() - 100;
		this.setEnergy(energy);
}


}
