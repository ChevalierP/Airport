package data;

public class Trajectory {

	public Trajectory()
	{
		
	}
	
	public double xposTakeOfupdate(double x)
	{
		return x + 0.1/48 * 4; // 0,1 = pas de temps(en s); 48 durée décollage(en s); 4 = longueur de la piste (en km)
	}
	
	public double speedTakeOfupdate(double s)
	{
		return s + 0.1/48 * 300; // 0,1 = pas de temps(en s); 48 durée décollage(en s); 4 = longueur de la piste (en km)
	}
	
	public double zposWaitingArea1(double z)
	{
		return z + 0.1/12 * 0.5;
	}
}
