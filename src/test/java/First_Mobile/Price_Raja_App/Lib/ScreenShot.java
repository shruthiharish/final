package First_Mobile.Price_Raja_App.Lib;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;

//import io.appium.java_client.android.AndroidDriver;

public class ScreenShot {
/*
	//This is to take screenshot in android devises
	public static void takeScreenShot(AndroidDriver driver) throws IOException{
		File snapShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destName = ".\\" + driver.getTitle() + ".png";
		FileUtils.copyFile(snapShot, new File(destName));
	}
*/	
	//This is to take screenshot through selenium
	public static void takeScreenShot(WebDriver driver) throws IOException{
		File snapShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snapShot, new File(".\\snapshot.png"));
	}
	
	//Taking full screenshot using Robot classes
	public static void takeFullScreenShot(){
		try {
            Robot robot = new Robot();
            String format = "jpg";
            String fileName = "./" + "PartialScreenshot." + format;
            //get the size of the monitor screen to get the entire screen image 
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
           // Rectangle captureRect = new Rectangle(0, 0, screenSize.width / 2, screenSize.height / 2);
            Rectangle captureRect = new Rectangle(0, 0, screenSize.width, screenSize.height);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
             
            System.out.println("A partial screenshot saved!");
        }catch(Exception ex){
		//catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
	}
	
	//take screenshot of given element
	public static void takeElementScreenShot(WebDriver driver, WebElement element){
		    try {
		    	String format = "png";
		        String fileName = ".\\"+element.getTagName() + "." + format;
		        //Retrieve location coordinates in pointX and pointY
		        int pointX = element.getLocation().x;
		        int pointY = element.getLocation().y;
		        //Retrieve element height and width in elementWidth and elemHight
		        int elemWidth = element.getSize().width;
		        int elemHight = element.getSize().height;
		        //take browser screenshot 
		        File fullBrowser = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        //open the captured image in reading mode as below
		        BufferedImage  fullImg = ImageIO.read(fullBrowser);
		        //Crop the image by giving the element location and size
		        BufferedImage eleScreenshot= fullImg.getSubimage(pointX, pointY, elemWidth, elemHight);
		        //save it in the snapshot output 
		        ImageIO.write(eleScreenshot, "png", fullBrowser);
		        //Copy the element screenshot to disk
		        FileUtils.copyFile(fullBrowser, new File(fileName));
		        
		    } catch (IOException ex) {
		        System.err.println(ex);
		    }
	}
	
}
