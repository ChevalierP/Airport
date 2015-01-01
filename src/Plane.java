
public class Plane extends Thread {

	double xCurrentPos, yCurrentPos, xTargetPos, yTargetPos, xInitialPos,yInitialPos;
	double speed = 0;
	
	public Plane(int xdepart, int ydepart, int xArrivee, int yArrivee)
	{
		xCurrentPos = xdepart;
		yCurrentPos = ydepart;
		
		xInitialPos = xdepart;
		yInitialPos = ydepart;
		
		xTargetPos = xArrivee;
		yTargetPos = yArrivee;
	}
	
	public void run()
	{
		
	}
}
