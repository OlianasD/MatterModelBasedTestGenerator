package wrappers;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import annots.ModelName;

@ModelName("Sensor")
public class Sensor {
	
	private String host;
	private Map<String, List<Park>> allParks;
	
	public Sensor(String host, Map<String, List<Park>> allParks) {
		this.host = host;
		this.allParks = allParks;
	}
	
	public boolean changeParkStatus(int parkid, int status) {
		 	HttpURLConnection conn = null;
	        byte[] data = ("{\"parkid\" : "+parkid+", \"status\" : "+status+" }").getBytes();
	        try {
	            //Preparing request
	            URL url = new URL(host+"smartparking/sensors");
	            
	            conn = (HttpURLConnection) url
	                    .openConnection();
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            conn.setReadTimeout(2000);
	            conn.setRequestMethod("POST");
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.setChunkedStreamingMode(data.length);
	            conn.connect();

	            //Sending request
	           
	            BufferedOutputStream output = new BufferedOutputStream(conn.getOutputStream());
	            
	            output.write(data);
	            output.flush();
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            
	            String strRes=in.readLine();
	            return true;
	      }
	     catch (IOException e) {
	        return false;
	    }
	    finally {
	        conn.disconnect();
	    }
	}
	
	public Park findParkWithStatus(String type, int status) {
		List<Park> currParks = allParks.get(type);
		for(Park p : currParks) {
			if(p.getStatus() == status) {
				return p;
			}
		}
		return null;
	}
	
	@ModelName("newVehicle")
	public void newVehicle(String type) {
		Park p = findParkWithStatus(type, 0);
		p.setStatus(1);
		changeParkStatus(p.getId(), 1);
	}
	
	@ModelName("vehicleLeaves")
	public void vehicleLeaves(String type)  {
		Park p = findParkWithStatus(type, 1);
		p.setStatus(0);
		changeParkStatus(p.getId(), 0);
	}
}
