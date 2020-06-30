package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;		
import utility.ExcelDataConfig;


public class LoginGit extends TestBase {

	@Test()//dataProvider = "Data")
	public void login() throws InterruptedException {
		log.debug("login test case ok");
		Focus("signin");
		Click("signin");
		Thread.sleep(1000);
		Focus("user");
		Write("user", "email@gmail.com");    //put your email here
		Thread.sleep(1000);
		Focus("pass");
		Write("pass", "aaasssddd");				//put your password here
		Thread.sleep(1000);
		Focus("loginbtn");
		Click("loginbtn");
		Thread.sleep(1000);
		
		log.debug("login case sukses");
	}

	/*
	 * @DataProvider(name = "Data") public Object[][] passData() { ExcelDataConfig
	 * config = new ExcelDataConfig( System.getProperty("user.dir") +
	 * "\\src\\test\\resources\\excel\\Data.xlsx");
	 * 
	 * int rows = config.getRowCount(0);
	 * 
	 * Object[][] data = new Object[rows][2];
	 * 
	 * for (int i = 0; i < rows; i++) { data[i][0] = config.getData(0, i, 0);
	 * data[i][1] = config.getData(0, i, 1); } return data; }
	 */
	 

}
