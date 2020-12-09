package SmartParkingTestSuite.tests;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import wrappers.MobileApp;
import wrappers.Sensor;
import wrappers.Server;
import wrappers.WrapperFactory;

public class Main {
	
	@Test
	public void testAll() {
		WrapperFactory factory = new WrapperFactory();
		//factory.printAllDistances();
		Sensor sensor = factory.createSensor();
		Server server = factory.createServer();
		server.setAllFree();
		
		MobileApp app = factory.createMobileApp();
		app.validLogin();
		/*app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");*/
		int maxCar = 11;
		int maxMoto = 8;
		int maxHandicap = 5;
		Map<String, Integer> maxes = new HashMap<>();
		maxes.put("car", 11);
		maxes.put("moto", 8);
		maxes.put("handicap", 5);
		
		String[] types = new String[] {"car", "moto", "handicap"};
		
		
		for(String type : types) {
			for(int i=0; i<maxes.get(type); i++) {
				app.assertNearestParkSelected(type);
				sensor.newVehicle(type);
				//Thread.sleep(1000);
				app.refresh();
				app.assertAvailable(type, maxes.get(type)-(i+1));
			}
			
			for(int i=0; i<maxes.get(type); i++) {
				sensor.vehicleLeaves(type);
				//Thread.sleep(1000);
				app.refresh();
				app.assertAvailable(type, i+1);
				app.assertNearestParkSelected(type);
			}
			app.assertAllFree(type);
		}
		
		
		
		
		app.assertAvailable("car", 11);
		app.assertAvailable("moto", 8);
		app.assertAvailable("handicap", 5);
	}
	
	@Test
	public void testValidLogin() {
		WrapperFactory factory = new WrapperFactory();
		//factory.printAllDistances();
		Sensor sensor = factory.createSensor();
		Server server = factory.createServer();
		server.setAllFree();
		
		MobileApp app = factory.createMobileApp();
		app.validLogin();
		app.assertAvailable("car", 11);
		app.assertAvailable("moto", 8);
		app.assertAvailable("handicap", 5);
		
	}
	
	@Test
	public void testInvalidLogin() {
		WrapperFactory factory = new WrapperFactory();
		//factory.printAllDistances();
		Sensor sensor = factory.createSensor();
		Server server = factory.createServer();
		server.setAllFree();
		
		MobileApp app = factory.createMobileApp();
		app.invalidLogin();
		app.assertInvalidLogin();
	}
	
	@Test
	public void testEmptyLogin() {
		WrapperFactory factory = new WrapperFactory();
		//factory.printAllDistances();
		Sensor sensor = factory.createSensor();
		Server server = factory.createServer();
		server.setAllFree();
		
		MobileApp app = factory.createMobileApp();
		app.emptyLogin();
		app.assertEmptyLogin();
	}
	
	

}
