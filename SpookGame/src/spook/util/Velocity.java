package spook.util;


public class Velocity {

	private double x, y;
	
	public Velocity(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void addY(double y)
	{
		this.y+=y;
	}
	
	public void addX(double x)
	{
		this.x+=x;
	}
	
	public Velocity clone()
	{
		return new Velocity(x,y);
	}
	
	public Velocity getLocation()
	{
		return this;
	}

	
	
	
}
