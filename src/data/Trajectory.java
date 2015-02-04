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
	
	
}
