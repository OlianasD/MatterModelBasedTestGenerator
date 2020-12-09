package wrappers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import annots.ModelName;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

@ModelName("MobileApp")
public class MobileAppAppium implements MobileApp {
	
	
	private static final int TIMEOUT600 = 500;
	private static final int TIMEOUT1000 = 1000;
	private static final int TIMEOUT2000 = 2000;
	public AppiumDriver<WebElement> driver;
    private static AppiumDriverLocalService service;
    private Map<String, List<Park>> allParks;
    private Park myPosition;
    
    
	
    public MobileAppAppium(Map<String, List<Park>> allParks) {
    	this.allParks = allParks;
    	myPosition = new Park(-1, "My position", "NOTYPE", -1, 44.4574293, 8.8914264);
    	service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        }
        
        File classpathRoot = new File(System.getProperty("user.dir"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("appPackage", "org.olianda.smartparking");
        capabilities.setCapability("appActivity",".LoginActivity"); 
        capabilities.setCapability("newCommandTimeout", 300);
        driver = new AndroidDriver<>(service.getUrl(), capabilities);
    }
    
    
    private List<WebElement> getMarkers() {
    	WebElement gmap = driver.findElement(By.xpath("//android.view.View[@content-desc='Google Map']"));
    	return gmap.findElements(By.className("android.view.View"));
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#assertAllFree(java.lang.String)
	 */
    @Override
	@ModelName("assertAllFree")
    public void assertAllFree(String type) {
    	driver.findElement(By.id("org.olianda.smartparking:id/"+type+"RadioButton")).click();
    	waitMillis(TIMEOUT1000);
		List<WebElement> markers = getMarkers();
		assertEquals(allParks.get(type).size(), markers.size());
		List<Park> currParks = new LinkedList<>(allParks.get(type));
		Park oldPark = null;
		for(WebElement marker : markers) {
			marker.click();
			waitMillis(TIMEOUT600);
			Park currPark = retrieveParkInfo();
			if(oldPark != null && currPark.equals(oldPark)) {
				marker.click();
				waitMillis(TIMEOUT600);
				currPark = retrieveParkInfo();
			}
			assertTrue(currParks.contains(currPark));
			currParks.remove(currPark);
			oldPark = currPark;
		}
	}


	private void waitMillis(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#assertAvailable(java.lang.String, int)
	 */
    @Override
	@ModelName("assertAvailable")
    public void assertAvailable(String type, int expected) {
    	driver.findElement(By.id("org.olianda.smartparking:id/"+type+"RadioButton")).click();
    	waitMillis(TIMEOUT1000);
    	int actual = Integer.parseInt(driver.findElement(By.id("org.olianda.smartparking:id/freeParksArea")).getText());
    	assertEquals(expected, actual);
    	assertEquals(getMarkers().size(), actual);
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#refresh()
	 */
    @Override
	@ModelName("refresh")
    public void refresh() {
    	driver.findElement(By.id("org.olianda.smartparking:id/refreshBtn")).click();
    	waitMillis(TIMEOUT600);
    }
    
    private Park retrieveParkInfo() {
    	int id = Integer.parseInt(driver.findElement(By.id("org.olianda.smartparking:id/parkIdArea")).getText());
    	String address = driver.findElement(By.id("org.olianda.smartparking:id/parkAddressArea")).getText();
    	String type = driver.findElement(By.id("org.olianda.smartparking:id/parkTypeArea")).getText();
    	double lat = Double.parseDouble(driver.findElement(By.id("org.olianda.smartparking:id/parkLatArea")).getText());
    	double lon = Double.parseDouble(driver.findElement(By.id("org.olianda.smartparking:id/parkLonArea")).getText());
    	return new Park(id, address, type, 0, lat, lon);
    	
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#assertNearestParkSelected(java.lang.String)
	 */
    @Override
	@ModelName("assertNearestParkSelected")
    public void assertNearestParkSelected(String type)  {
    	driver.findElement(By.id("org.olianda.smartparking:id/"+type+"RadioButton")).click();
    	waitMillis(TIMEOUT1000);
    	Park p = retrieveParkInfo();
    	Park expected = allParks.get(p.getType()).stream().filter(x -> x.getStatus() == 0)
    	    	.sorted((p1, p2) -> p1.distanceFrom(myPosition).compareTo(p2.distanceFrom(myPosition))).findFirst().get();
    	assertEquals(expected, p);
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#validLogin()
	 */
    @Override
	@ModelName("validLogin")
    public void validLogin() {
    	driver.findElement(By.id("org.olianda.smartparking:id/usernameArea")).sendKeys("user");
    	driver.hideKeyboard();
    	driver.findElement(By.id("org.olianda.smartparking:id/passwordArea")).sendKeys("password");
    	driver.hideKeyboard();
    	driver.findElement(By.id("org.olianda.smartparking:id/loginBtn")).click();
    	waitMillis(TIMEOUT2000);
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#invalidLogin()
	 */
    @Override
	@ModelName("invalidLogin")
    public void invalidLogin() {
    	driver.findElement(By.id("org.olianda.smartparking:id/usernameArea")).sendKeys("pippo");
    	driver.hideKeyboard();
    	driver.findElement(By.id("org.olianda.smartparking:id/passwordArea")).sendKeys("pluto");
    	driver.hideKeyboard();
    	driver.findElement(By.id("org.olianda.smartparking:id/loginBtn")).click();
    	waitMillis(TIMEOUT1000);
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#emptyLogin()
	 */
    @Override
	@ModelName("emptyLogin")
    public void emptyLogin() {
    	driver.findElement(By.id("org.olianda.smartparking:id/loginBtn")).click();
    	waitMillis(TIMEOUT600);
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#assertInvalidLogin()
	 */
    @Override
	@ModelName("asssertInvalidLogin")
    public void assertInvalidLogin() {
    	String errorMsg = driver.findElement(By.id("org.olianda.smartparking:id/loginErrorArea")).getText();
    	assertEquals("Login failed.", errorMsg);
    }
    
    /* (non-Javadoc)
	 * @see wrappers.MobileApp#assertEmptyLogin()
	 */
    @Override
	@ModelName("asssertEmptyLogin")
    public void assertEmptyLogin() {
    	String errorMsg = driver.findElement(By.id("org.olianda.smartparking:id/loginErrorArea")).getText();
    	assertEquals("Username and password cannot be empty.", errorMsg);
    }
    

}
