package wrappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class MobileAppAPI implements MobileApp {
	
	protected String host;
	protected Map<String, List<Park>> allParks;
	protected Park myPosition;
	protected JSONObject loginResult;
	
	public MobileAppAPI(Map<String, List<Park>> allParks, String host) {
		this.allParks = allParks;
		this.host = host;
    	myPosition = new Park(-1, "My position", "NOTYPE", -1, 44.4574293, 8.8914264);

	}
	
	private void waitMillis(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private Park[] retrieveParks(String type) {
        HttpURLConnection conn = null;
        JSONArray resObj = null;
        byte[] data = ("{\"type\": \""+type+"\", \"pos\": {\"lat\": 44.4574293, \"lon\": 8.8914264}}").getBytes();
        try {
            //Preparing request
            URL url = new URL(host + "smartparking/req");

            conn = (HttpURLConnection) url
                    .openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setChunkedStreamingMode(data.length);
            conn.connect();

            //Sending request
            BufferedOutputStream output = new BufferedOutputStream(conn.getOutputStream());
            output.write(data);
            output.flush();

            //Receiving response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String strRes=in.readLine();
            resObj = new JSONArray(strRes);
            
            return jsonToParkArray(resObj);

        } catch (Exception e) {
        	e.printStackTrace();
        }
        finally {
            conn.disconnect();
        }
        return null;
	}
	
	private Park[] jsonToParkArray(JSONArray json) {
		Park[] parks = new Park[json.length()];
		for(int i =0; i<json.length(); i++) {
			JSONObject currObj = json.getJSONObject(i);
			parks[i] = new Park(currObj.optInt("parkid"), currObj.optString("address"), 
					currObj.optString("type"), currObj.optInt("status"), 
					currObj.optDouble("lat"), currObj.optDouble("lon"));
			
		}
		return parks;
	}
	
	private Integer getFreeParkCount(String type) {
		JSONObject resObj = null;
        HttpURLConnection conn = null;
        byte[] data = ("{\"type\": \""+type+"\"}").getBytes();
        try {
            //Preparing request
            URL url = new URL(host + "smartparking/count");
            conn = (HttpURLConnection) url
                    .openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setChunkedStreamingMode(data.length);
            conn.connect();

            //Sending request
            BufferedOutputStream output = new BufferedOutputStream(conn.getOutputStream());
            output.write(data);
            output.flush();

            //Receiving response
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String strRes=in.readLine();
            resObj = new JSONArray(strRes).getJSONObject(0);
            return resObj.optInt("numparks");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.disconnect();
        }
        return null;
	}
	
	@Override
	public void assertAllFree(String type) {
		Park[] actualParks = retrieveParks(type);
		List<Park> expectedParks = allParks.get(type);
		assertEquals(expectedParks.size(), actualParks.length);
		for(Park p : actualParks) {
			assertTrue(expectedParks.contains(p));
		}

	}

	@Override
	public void assertAvailable(String type, int expected) {
		int actualFreeParks = getFreeParkCount(type);
		Park[] actualParks = retrieveParks(type);
		assertEquals(expected, actualFreeParks);
		assertEquals(actualParks.length, expected);

	}

	@Override
	public void refresh() {
		waitMillis(100);

	}

	@Override
	public void assertNearestParkSelected(String type) {
		Park actual = retrieveParks(type)[0];
		Park expected = allParks.get(actual.getType()).stream().filter(x -> x.getStatus() == 0)
    	    	.sorted((p1, p2) -> p1.distanceFrom(myPosition).compareTo(p2.distanceFrom(myPosition))).findFirst().get();
		assertEquals(expected, actual);
	}
	
	public void doLogin(String username, String password) {
		 HttpURLConnection conn = null;
	        byte[] data = ("{\"user\" : \""+username+"\", \"psw\" : \""+password+"\"}").getBytes();
	        try {
	            //Preparing request
	            URL url = new URL(host + "smartparking/login");
	            conn = (HttpURLConnection) url
	                    .openConnection();
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            conn.setRequestProperty("Content-Type", "application/json");
	            conn.setChunkedStreamingMode(data.length);

	            //Sending request
	            BufferedOutputStream output = new BufferedOutputStream(conn.getOutputStream());
	            output.write(data);
	            output.flush();

	            //Receiving response
	            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String strRes=in.readLine();
	            loginResult = new JSONObject(strRes);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        finally {
	            conn.disconnect();
	        }
	}
	@Override
	public void validLogin() {
		doLogin("user", "password");
		assertTrue(loginResult.optBoolean("LoginResult"));

	}

	@Override
	public void invalidLogin() {
		doLogin("pippo", "pluto");
	}

	@Override
	public void emptyLogin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void assertInvalidLogin() {
		assertFalse(loginResult.optBoolean("LoginResult"));

	}

	@Override
	public void assertEmptyLogin() {
		assertTrue(true);

	}

}
