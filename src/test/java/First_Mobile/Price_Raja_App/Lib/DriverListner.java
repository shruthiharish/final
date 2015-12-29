package First_Mobile.Price_Raja_App.Lib;


import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

//This is webdriver listener i.e., for every driver actions webdrivereventlistener will be logging the status to the log file
public class DriverListner implements WebDriverEventListener {

	//create log4j object with logger name WebDriverActions
	private static Logger log = Logger.getLogger("WebDriverActions");
	
	
	{
	//PropertiesConfigurator is used to configure logger from properties file
    PropertyConfigurator.configure(".\\src\\test\\java\\First_Mobile\\Price_Raja_App\\Properties\\log4j.properties");
	}
	
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		log.info("element changed value");
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		log.info("element clicked in device app ");
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		log.info("After finding the device app ");
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		log.info("Browser was navigated back");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		log.info("Browser was navigated forward to URL : " + driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		log.info("Browser was navigated to the URL : " + url);
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		log.info("After " + script + " script execution");
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		log.info("Changing the value of : ");
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		log.info("clicking : ");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		log.info("Before finding the element ");
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		log.info("Browser is navgating back now");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		log.info("Browser is navigating back now");		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		log.info("Browser is navigating to the url "+ url);
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		log.info(script + " script execution started");
		
	}

	@Override
	public void onException(Throwable e, WebDriver driver) {
		log.error("Exception : " + e.getMessage());
		log.error(e.getCause());
		try {
			ScreenShot.takeScreenShot(driver);
		} catch (IOException e1) {
			log.error(e1.getCause());
			e1.printStackTrace();
		}
	}

}
