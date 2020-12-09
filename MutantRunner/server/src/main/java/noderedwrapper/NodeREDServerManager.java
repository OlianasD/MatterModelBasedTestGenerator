package noderedwrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class NodeREDServerManager {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket clientSocket = null;
		String mutDir = "/home/dario/winhome/mutants/DiaMH_QUATIC2020/nodeREDflows/";
		Process p = null;
		while(true) {
			
				try {
					server = new ServerSocket(8080);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Listening on port 8080");
			
				try {
					clientSocket = server.accept();
					System.out.println("Connection established");
					InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
					System.out.println("Got input stream");
					BufferedReader reader = new BufferedReader(isr); 
					String line = reader.readLine();
					System.out.println("Received "+line);
					if(line.equals("kill")) {
						System.out.println("Killing Node-RED");
						Runtime.getRuntime().exec("killall node-red");
					} else {
						System.out.println("Starting Node-RED");
						Runtime.getRuntime().exec("node-red "+mutDir+"/"+line);
					}
					clientSocket.close();
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	}


