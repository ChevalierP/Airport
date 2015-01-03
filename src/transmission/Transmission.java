package transmission;

import java.io.IOException;
import java.net.InetAddress;

public abstract class Transmission {

	protected int portNumber;
	protected InetAddress IPAddress;

	abstract void communicate();

	public abstract void create() throws IOException;

}
