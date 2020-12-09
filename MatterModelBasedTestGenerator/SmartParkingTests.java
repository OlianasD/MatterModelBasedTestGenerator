package SmartParkingTestSuite.tests;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import wrappers.MobileAppAppium;
import wrappers.Sensor;
import wrappers.Server;
import wrappers.WrapperFactory;


public class SmartParkingTests {
protected int timeout = 2;
protected MobileApp app;
protected Sensor sensor;
protected Server server;
protected WrapperFactory factory;
protected int INJECTIONS;
protected int TRESHOLD;
protected int TOT;
protected int I;
protected int OVER;
protected int DISCARD;

@Test
	public void test_1() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> Login   app.invalidLogin()
		app.invalidLogin();
		app.assertInvalidLogin();
}

@Test
	public void test_2() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> Login   app.emptyLogin()
		app.emptyLogin();
		app.assertEmptyLogin();
}

@Test
	public void test_3() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_4() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_5() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_6() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> Free car, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: Free car, free moto, handicap over -> All free   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_7() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> Free car, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_8() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> Free car, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_9() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> All free   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_10() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_11() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_12() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> All free   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_13() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_14() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_15() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> Free car, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Free car, free moto, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_16() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Free car, moto over, free handicap -> Free car, moto over, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Free car, moto over, handicap over -> Free car, moto over, free handicap   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_17() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Free car, moto over, free handicap -> Free car, moto over, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Free car, moto over, handicap over -> Free car, free moto, handicap over   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_18() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Free car, moto over, free handicap -> Free car, moto over, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_19() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> Free car, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Free car, free moto, handicap over -> Free car, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Free car, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_20() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, handicap over -> Free car, free moto, handicap over   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_21() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, handicap over -> Car over, free moto, free handicap   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_22() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_23() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Free car, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_24() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Car over, free moto, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Car over, moto over, free handicap -> Car over, free moto, free handicap   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_25() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Car over, free moto, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Car over, moto over, free handicap -> Free car, moto over, free handicap   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_26() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Car over, free moto, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 22: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_27() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 22: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 23: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 24: Car over, free moto, handicap over -> Car over, free moto, handicap over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 25: Car over, free moto, handicap over -> All over   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_28() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> Free car, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Free car, moto over, free handicap -> Free car, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Free car, moto over, free handicap -> Free car, moto over, handicap over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 22: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 23: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 24: Free car, moto over, handicap over -> Free car, moto over, handicap over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 25: Free car, moto over, handicap over -> All over   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_29() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Car over, free moto, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 22: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 23: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 24: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 25: Car over, moto over, free handicap -> All over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 26: All over -> Car over, moto over, free handicap   sensor.vehicleLeaves("handicap")
		sensor.vehicleLeaves("handicap");
		server.vehicleLeaves("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_30() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Car over, free moto, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 22: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 23: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 24: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 25: Car over, moto over, free handicap -> All over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 26: All over -> Free car, moto over, handicap over   sensor.vehicleLeaves("car")
		sensor.vehicleLeaves("car");
		server.vehicleLeaves("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

@Test
	public void test_31() {
//transition 0: init -> Login   
		factory = new WrapperFactory();
		server = factory.createServer();
		sensor = factory.createSensor();
		server.setAllFree();
		app = factory.createMobileApp();
//transition 1: Login -> All free   app.validLogin()
		app.validLogin();
		app.assertAllFree("car");
		app.assertAllFree("moto");
		app.assertAllFree("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 2: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 3: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 4: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 5: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 6: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 7: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 8: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 9: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 10: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 11: All free -> All free   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertNearestParkSelected("car");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 12: All free -> Car over, free moto, free handicap   sensor.newVehicle("car")
		sensor.newVehicle("car");
		server.newVehicle("car");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 13: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 14: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 15: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 16: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 17: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 18: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 19: Car over, free moto, free handicap -> Car over, free moto, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 20: Car over, free moto, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("moto")
		sensor.newVehicle("moto");
		server.newVehicle("moto");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 21: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 22: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 23: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 24: Car over, moto over, free handicap -> Car over, moto over, free handicap   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertNearestParkSelected("handicap");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 25: Car over, moto over, free handicap -> All over   sensor.newVehicle("handicap")
		sensor.newVehicle("handicap");
		server.newVehicle("handicap");
		app.refresh();
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
//transition 26: All over -> Car over, free moto, handicap over   sensor.vehicleLeaves("moto")
		sensor.vehicleLeaves("moto");
		server.vehicleLeaves("moto");
		app.refresh();
		app.assertNearestParkSelected("moto");
		app.assertAvailable("car", server.maxCar-server.nCar);
		app.assertAvailable("moto", server.maxMoto-server.nMoto);
		app.assertAvailable("handicap", server.maxHandicap-server.nHandicap);
}

}
