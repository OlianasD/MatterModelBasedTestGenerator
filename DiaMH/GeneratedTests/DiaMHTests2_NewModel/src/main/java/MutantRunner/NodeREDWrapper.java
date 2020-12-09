package MutantRunner;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NodeREDWrapper {
	
	protected String host;
	
	public NodeREDWrapper(String host) {
		this.host = host;
	}
	
	public void start(String mutant) throws UnknownHostException, IOException {
		try {
			Socket clientSocket = new Socket(host, 8080);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(mutant+"\n");
			clientSocket.close();
		}
		catch(Exception e) {
			Socket clientSocket = new Socket(host, 8080);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes(mutant+"\n");
			clientSocket.close();
		}
	}
	
	public void stop() throws UnknownHostException, IOException  {
		try {
			Socket clientSocket = new Socket(host, 8080);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("kill\n");
			clientSocket.close();
		}
		catch(Exception e) {
			Socket clientSocket = new Socket(host, 8080);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			outToServer.writeBytes("kill\n");
			clientSocket.close();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
	}
}
