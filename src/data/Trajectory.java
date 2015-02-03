package data;

public class Trajectory {

	public Trajectory()
	{
		
	}
	
	public double xposTakeOffupdate(double x)
	{
		return x + 0.1/48 * 4;
	}
	
	public double speedTakeOffupdate(double s)
	{
		return s + 0.1/48 * 300; 
	}
	
	public double zposWaitingArea1(double z)
	{
		return z + 0.1/12 * 0.5;
	}
	
	public double xposWaitingArea(double x, double theta)
	{
		return (x-2) - 2 * Math.sin(theta)*150/3600;
	}
	
	public double yposWaitingArea(double y, double theta)
	{
		return (y-2) + 2 * Math.cos(theta)* 150/3600;
	}
}
