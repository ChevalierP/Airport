package transmission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur extends Transmission {

	public Serveur(int portNumber) {

		this.portNumber = portNumber;
	}

	@Override
	void communicate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create() throws IOException {

		@SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(portNumber);
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(connectionSocket.getInputStream()));

//			DataOutputStream outToClient = new DataOutputStream(
//					connectionSocket.getOutputStream());

			System.out.println(inFromClient.readLine());

			//welcomeSocket.close();
		}

	}
}
