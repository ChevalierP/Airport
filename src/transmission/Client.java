package transmission;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Transmission {

	public Client(int portNumber) {
		this.portNumber = portNumber;
	}

	@Override
	void communicate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create() throws IOException {

		Socket clientSocket = new Socket("localhost", this.portNumber);

		DataOutputStream outToServer = new DataOutputStream(
				clientSocket.getOutputStream());

//		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
//				clientSocket.getInputStream()));

		outToServer.writeBytes("blabla \r\n");

		clientSocket.close();
	}
}
