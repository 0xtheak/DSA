package inheritance;

public abstract class Car extends Vehicle {
	int numDoors;
	int numGears;
	
	public Car() {
		this.numGears=6;
	}
	
	public void print() {
		System.out.println("Car color " + getColor() + " maxspeed " + maxSpeed + " number of doors " + numDoors);
	}
	
	public void printMaxSpeed() {
		maxSpeed=150;
		System.out.println("maxspeed" + " " + maxSpeed);
	}

	@Override
	public boolean isMotorized() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
