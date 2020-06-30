package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utility.ExcelDataConfig;


public class AllGist extends TestBase {

	@Test()
	public void listgist() throws InterruptedException {
		
		log.debug("All gist case ok");
		Click2("nmenu");
		Thread.sleep(1000);
		Click2("glist");
		Thread.sleep(1000);
		
		//Assert.assertTrue(isElementPresent(By.cssSelector(obj.getProperty("img1"))), "Validasi muncul sukses bro");
		log.debug("Allgist lsit case sukses");
	}

}
