package First_Mobile.Price_Raja_App.Lib;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
//This is for TestNG i.e., for every test method this listener will be called respectively depending on the conditions
public class ResultListner implements ITestListener {

	static Logger log;
	
	public void setLogger(String clsName){
		log=Logger.getLogger(clsName);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		setLogger(result.getName());
		log.info("Starting test execution");
		//Reporter.log("Starting " + result.getName() + " : ", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		setLogger(result.getName());
		
		log.info("Test execution completed Successfully");
		//Reporter.log("Successfully completed the execution of test : " + result.getName(), true);		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		setLogger(result.getName());
		log.fatal("Failed");
		//Reporter.log(result.getName() + " failed ", true);
		onTestFailedButWithinSuccessPercentage(result);
		//mailing code
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		setLogger(result.getName());
		log.warn("Skiped");
		//Reporter.log("Test method " + result.getName() + " skkiped", true);
		//mailing code
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		setLogger(result.getName());
		log.info("Pass percentage before test could fail : " + result.SUCCESS_PERCENTAGE_FAILURE);
		//Reporter.log("Test method " + result.getName() + "failed" , true);
		//Reporter.log("percentage passed before the test could fail : " + result.SUCCESS_PERCENTAGE_FAILURE, true);
		//mailing code
		
	}

	@Override
	public void onStart(ITestContext context) {
		setLogger(context.getClass().getName());
		log.info("Starting test execution");
		//Reporter.log("Starting test execution", true);
		//include code to send mail to the tester on intimating the starting of the automation test
	}

	@Override
	public void onFinish(ITestContext context) {
		setLogger(context.getClass().getName());
		log.info("Finished test execution");
		//Reporter.log("Finished test execution", true);
		//mailing code
		
	}

}
