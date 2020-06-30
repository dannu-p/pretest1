package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.TestBase;
import utility.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		 try{
			 TestUtil.captureScreenshot();
		 }catch (IOException e){
			 e.printStackTrace();
		 }
		 Reporter.log("capturing screenshoot");
		 Reporter.log("<a target=\"blank\" href="+TestUtil.screenshotName+">Screenshoot</a>");
		 Reporter.log("<br>");
		 Reporter.log("<a target=\"blank\" href="+TestUtil.screenshotName+"><img src=\"D:\\test foto\\765-default-avatar.png\" height=200 width=200></img></a>");
		 

	}

	public void onTestSuccess(ITestResult result) {

		 System.setProperty("org.uncommons.reportng.escape-output", "true");
		 try{
			 TestUtil.captureScreenshot();
		 }catch (IOException e){
			 e.printStackTrace();
		 }
		 Reporter.log("capturing screenshoot");
		 Reporter.log("<a target=\"blank\" href=\"\\target\\surefire-reports\\html\">Screenshot</a>");
		 Reporter.log("<br>");
		 Reporter.log("<a target=\"blank\" href="+TestUtil.screenshotName+"><img src=\"D:\\test foto\\765-default-avatar.png\" height=200 width=200> </img></a>");

	}
}