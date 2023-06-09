package inheritance;

public abstract class Vehicle {
	private String color;
	protected int maxSpeed;
	
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		this.color =c;
	}
//	@Override
	public void print() {
		System.out.println("Vehicle color " + getColor() + " maxspeed " + maxSpeed);
	}
	
	public abstract boolean isMotorized();
	
	public abstract String getCompany();
}
