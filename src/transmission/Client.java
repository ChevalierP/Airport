package transmission;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Transmission {

	public Client(int portNumber, InetAddress inetAddress) {
		this.portNumber = portNumber;
		this.IPAddress = inetAddress;
	}

	@Override
	void communicate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create() throws IOException {
		
		Socket clientSocket = new Socket(this.IPAddress, this.portNumber);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		outToServer.writeBytes("blabla");
		
		String modifiedSentence = inFromServer.readLine();
		
		System.out.println("Recu : " + modifiedSentence);
		
		//clientSocket.close();
	}
}
