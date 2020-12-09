package DiaMHTestsMaven.DiaMHTests;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.BeforeClass;import DiaMHTestsMaven.wrappers.Cloud;
import DiaMHTestsMaven.wrappers.GlucoseSensor;
import DiaMHTestsMaven.wrappers.IGlucoseSensor;
import DiaMHTestsMaven.wrappers.InsulinPump;
import DiaMHTestsMaven.wrappers.MobileApp;
import DiaMHTestsMaven.wrappers.MobileAppAppium;


public class DiaMHMinimizedTestClass {
protected int timeout = 2;
protected MobileApp app;
protected IGlucoseSensor sensor;
protected InsulinPump pump;
protected Cloud cloud;
protected int INJECTIONS;
protected int TRESHOLD;
protected int TOT;
protected int I;
protected int OVER;
protected int DISCARD;

@Test
	public void test_1() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 2: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 3: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 4: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 5: Normal -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 6: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
}

@Test
	public void test_2() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 2: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 3: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 4: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 5: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 6: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 7: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 8: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 9: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 10: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 11: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 12: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 13: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 14: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 15: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 16: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 17: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 18: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 19: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 20: Normal -> Normal   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 21: Normal -> Normal   
		cloud.resetReadings();
		app.assertNotRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
}

@Test
	public void test_3() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 2: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 3: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 4: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 5: Normal -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 6: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 7: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 8: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 9: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 10: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 11: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 12: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 13: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 14: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 15: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 16: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 17: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 18: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 19: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 20: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 21: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 22: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 23: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 24: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 25: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 26: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 27: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 28: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 29: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 30: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 31: More insulin -> Normal   
		app.assertAlarmOff(timeout);
		app.assertNotRequiringInsulin(timeout);
		cloud.resetReadings();
}

@Test
	public void test_4() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 2: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 3: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 4: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 5: Normal -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 6: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 7: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 8: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 9: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 10: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 11: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 12: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 13: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 14: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 15: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 16: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 17: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 18: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 19: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 20: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 21: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 22: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 23: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 24: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 25: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 26: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 27: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 28: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 29: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 30: More insulin -> More insulin   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 31: More insulin -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
}

@Test
	public void test_5() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 2: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 3: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 4: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 5: Normal -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 6: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 7: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 8: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 9: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 10: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 11: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 12: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 13: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 14: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 15: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 16: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 17: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 18: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 19: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 20: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 21: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 22: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 23: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 24: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 25: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 26: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 27: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 28: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 29: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 30: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 31: More insulin -> Problematic   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOn(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 32: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
}

@Test
	public void test_6() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 2: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 3: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 4: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 5: Normal -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 6: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 7: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 8: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 9: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 10: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 11: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 12: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 13: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 14: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 15: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 16: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 17: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 18: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 19: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 20: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 21: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 22: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 23: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 24: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 25: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 26: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 27: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 28: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 29: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 30: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 31: More insulin -> Problematic   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOn(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 32: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 33: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 34: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 35: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 36: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 37: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 38: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 39: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 40: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 41: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 42: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 43: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 44: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 45: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 46: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 47: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 48: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 49: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 50: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 51: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 52: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 53: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 54: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 55: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 56: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 57: Problematic -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
}

@Test
	public void test_7() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 2: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 3: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 4: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 5: Normal -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 6: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 7: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 8: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 9: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 10: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 11: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 12: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 13: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 14: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 15: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 16: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 17: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 18: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 19: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 20: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 21: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 22: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 23: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 24: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 25: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 26: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 27: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 28: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 29: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 30: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 31: More insulin -> Problematic   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOn(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 32: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 33: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 34: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 35: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 36: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 37: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 38: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 39: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 40: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 41: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 42: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 43: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 44: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 45: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 46: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 47: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 48: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 49: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 50: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 51: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 52: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 53: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 54: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 55: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 56: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 57: Problematic -> Problematic   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOn(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
}

@Test
	public void test_8() {
//transition 0: init -> Normal   
		pump = new InsulinPump();
		pump.reset();
		cloud = new Cloud();
		cloud.reset();
		app = new MobileAppAppium();
		sensor = new GlucoseSensor();
		app.shutdownAlarm();
//transition 1: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 2: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 3: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 4: Normal -> Normal   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 5: Normal -> More insulin   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOff(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 6: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 7: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 8: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 9: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 10: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 11: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 12: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 13: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 14: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 15: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 16: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 17: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 18: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 19: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 20: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 21: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 22: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 23: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 24: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 25: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 26: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 27: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 28: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 29: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 30: More insulin -> More insulin   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 31: More insulin -> Problematic   
		app.assertRequiringInsulin(timeout);
		app.assertAlarmOn(timeout);
		app.confirmInsulin();
		app.assertInsulinIncrement(pump.getErogatedInjections(),timeout);
		pump.inject();
		cloud.discardNext(5);
		cloud.resetReadings();
//transition 32: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 33: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 34: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 35: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 36: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 37: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 38: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 39: Problematic -> Problematic   sensor.sendOver(cloud.getThreshold())
		sensor.sendOver(cloud.getThreshold());
		cloud.receiveOver();
//transition 40: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 41: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 42: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 43: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 44: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 45: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 46: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 47: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 48: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 49: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 50: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 51: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 52: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 53: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 54: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 55: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 56: Problematic -> Problematic   sensor.sendUnder(cloud.getThreshold())
		sensor.sendUnder(cloud.getThreshold());
		cloud.receiveUnder();
//transition 57: Problematic -> Normal   
		app.assertAlarmOff(timeout);
		app.assertNotRequiringInsulin(timeout);
		cloud.resetReadings();
}

}
