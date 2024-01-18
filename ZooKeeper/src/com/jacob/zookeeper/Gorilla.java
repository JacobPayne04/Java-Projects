package com.jacob.zookeeper;
public class Gorilla extends Mammal {

    public Gorilla() {
        super(100);
    }
    
    public void throwSomething() {
        int energy = this.getEnergy() - 5;
        this.setEnergy(energy);
    }
    
    public void eatBananas() {
        int energy = this.getEnergy() + 10;
        this.setEnergy(energy);
    }
    
    public void climb() {
        this.setEnergy(this.getEnergy() - 10);
    }

}
