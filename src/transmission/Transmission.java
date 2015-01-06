package transmission;

import java.io.IOException;

public abstract class Transmission {

	protected int portNumber;

	abstract void communicate();

	public abstract void create() throws IOException;

}
