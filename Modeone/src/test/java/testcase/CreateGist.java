package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utility.ExcelDataConfig;


public class CreateGist	 extends TestBase {

	@Test()//dataProvider = "Data")
	public void creategist() throws InterruptedException {
		
		log.debug("add gist case ok");
		Focus("addbtn");
		Click("addbtn");
		Thread.sleep(1000);
		Click2("addgist");
		Thread.sleep(1000);
		Focus("gdesc");
		Write("gdesc", "aaaaaa");
		Thread.sleep(1000);
		Focus("fname");
		Write("fname", "ssssss");
		Thread.sleep(1000);
		Focus("wtext");
		Click("wtext");
		Write("wtext", "xxxxxxxx");
		Thread.sleep(1000);
		Focus("bgist");
		Click("bgist");
		Thread.sleep(1000);
		
		log.debug("login asdasdasd case sukses");
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
