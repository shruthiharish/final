package First_Mobile.Price_Raja_App.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.StaticBucketMap;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import First_Mobile.Price_Raja_App.Lib.DeviceCapablities;
import First_Mobile.Price_Raja_App.Lib.DriverListner;
import io.appium.java_client.android.AndroidDriver;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;


@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Settings {
	
	static AndroidDriver device;
	static EventFiringWebDriver driver;
	static DriverListner listner;
	
	{
		System.setProperty("atu.reporter.config", ".\\src\\test\\java\\First_Mobile\\Price_Raja_App\\Properties\\atu.properties");
	}

	
	@BeforeMethod
	public void preCondition() throws IOException{
		device = DeviceCapablities.setDeviceCapablities();
		driver = new EventFiringWebDriver(device);
		listner = new DriverListner();
		driver.register(listner);
		driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	 public void setCountry(){
		 driver.findElement(By.name("India")).click();
	 }
	

}
