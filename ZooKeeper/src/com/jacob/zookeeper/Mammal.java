package com.jacob.zookeeper;

public class Mammal {
	private int energy = 100;

	protected Mammal(int energy) {
		this.energy = energy;
	}

	public void displayEnergy() {
		System.out.println("the energy is: " + this.energy);
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	
}

