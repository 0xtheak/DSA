package inheritance_temp;

import inheritance.*;

public class Truck extends Vehicle {
	int maxLoadingCapacity;
	
	public void print() {
		this.maxSpeed = 100;
		System.out.println("Vehicle color " + getColor() + " maxspeed " + maxSpeed + " maxLoadingCapacity " + maxLoadingCapacity);
	}

}
