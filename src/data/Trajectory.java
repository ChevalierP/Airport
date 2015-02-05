package data;

public class Trajectory {

	public Trajectory()
	{
		
	}
	
	public double xposTakeOffupdate()
	{
		return 0.1/4.8 * 4;
	}
	
	public double speedTakeOffupdate()
	{
		return 0.1/4.8 * 300; 
	}
	
	public double zposWaitingArea1()
	{
		return 0.1/1.2 * 0.5;
	}
	
	public double setTheta()
	{
		return 0.1/15;
	}
	
	public double getAlpha(double x1, double y1, double x2, double y2)
	{
		if(y2-y1 != 0 && x2-x1!= 0) //cas normal
		return Math.abs(Math.atan((x2-x1)/(y2-y1)))%(2*Math.PI);
		
		/* Cas particuliers */
		else if(y2 == y1 && x2 > x1)
			return 3*Math.PI/2;
		else if(y2 == y1 && x2 < x1)
			return Math.PI/2;
		else if (x2 == x1 && y2 < y1)
			return Math.PI;
		else
			return 0;
	}
	
	public double getFlightTimes(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((1000*x2-1000*x1)*(1000*x2-1000*x1)+(1000*y2-1000*y1)*(1000*y2-1000*y1))/236; //236 m/s
	}
	
	public double waitingTime(double alpha)
	{
		return 2000*alpha/83.33; // vitesse = 83.33 m/s distance à parcourir = alpha*R (2000m)
	}
	
}
