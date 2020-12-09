package wrappers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import annots.ModelName;

@ModelName("WrapperFactory")
public class WrapperFactory {
	
	
	private Map<String, List<Park>> allParks;
	private String host = "http://192.168.1.161:1880/";
	private int maxCar = 11;
	private int maxMoto = 8;
	private int maxHandicap = 5;
	
	public WrapperFactory() {
		try {
			this.allParks = loadParkData("file:///C:/Users/olly1/Dropbox/Dario%20PhD/SmartParkingTests/parks.json");
		} catch (URISyntaxException | IOException e) {
			this.allParks=null;
			e.printStackTrace();
		}
	}
	
    public Map<String, List<Park>> loadParkData(String path) throws URISyntaxException, MalformedURLException, IOException {
    	JSONTokener tokener = null;
    	URI uri = new URI(path);
    	tokener = new JSONTokener(uri.toURL().openStream());
    	JSONArray parksJson = new JSONArray(tokener);
    	Map<String, List<Park>> parks = new HashMap<>();
    	parks.put("car", new LinkedList<Park>());
    	parks.put("moto", new LinkedList<Park>());
    	parks.put("handicap", new LinkedList<Park>());
    	for(int i=0; i<parksJson.length(); i++) {
    		JSONObject currJsonPark = parksJson.getJSONObject(i);
    		Park currPark = new Park(currJsonPark.getInt("parkid"), currJsonPark.getString("address"), currJsonPark.getString("type"), currJsonPark.getInt("status"), currJsonPark.getDouble("lat"), currJsonPark.getDouble("lon"));
    		List<Park> currParkList = parks.get(currPark.getType());
    		currParkList.add(currPark);
    	}
    	return parks;
    }
    
    @ModelName("createMobileApp")
    public MobileApp createMobileApp() {
    	return new MobileAppAppium(allParks);
    	//return new MobileAppAPI(allParks, host);
    }
    
    @ModelName("createSensor")
    public Sensor createSensor() {
    	return new Sensor(host, allParks);
    }
    
    @ModelName("createServer")
    public Server createServer() {
    	return new Server(0, maxCar, 0, maxMoto, 0, maxHandicap);
    }
    
    private void printAllDistances() {
    	Park myPosition = new Park(-1, "My position", "NOTYPE", -1, 44.4574293, 8.8914264);
    	for(String type : allParks.keySet()) {
    		for(Park p : allParks.get(type)) {
    			System.out.println(p.getId());
    			System.out.println(Double.toString(p.distanceFrom(myPosition))+"\n");
    		}
    	}
    	Park found = allParks.get("car").stream().filter(x -> x.getStatus() == 0)
    	.sorted((p1, p2) -> p1.distanceFrom(myPosition).compareTo(p2.distanceFrom(myPosition))).findFirst().get();
    	System.out.println(found.getAddress());
    }
}
