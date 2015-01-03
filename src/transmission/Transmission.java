package transmission;

public abstract class Transmission {

	protected int portNumber;
	protected int IPAddress;

	abstract void communicate();

	abstract void create();

}
