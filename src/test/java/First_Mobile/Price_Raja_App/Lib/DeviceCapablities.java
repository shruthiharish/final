package First_Mobile.Price_Raja_App.Lib;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DeviceCapablities {
	
	public static AndroidDriver setDeviceCapablities() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		 File appDir = new File(".\\src\\test\\java\\First_Mobile\\Price_Raja_App\\Properties\\VioletStreet.apk");
		 capabilities.setCapability("automationName",Properties.getPropertyValue("automationName"));
		 //capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		 capabilities.setCapability("platformName",Properties.getPropertyValue("platformName"));
		 capabilities.setCapability("platformVersion",Properties.getPropertyValue("platformVersion"));
		 capabilities.setCapability("deviceName",Properties.getPropertyValue("deviceName"));
		 capabilities.setCapability("app", appDir);
		 capabilities.setCapability("appPackage",Properties.getPropertyValue("appPackage"));
		 capabilities.setCapability("appActivity",Properties.getPropertyValue("appActivity"));
		 return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

}
