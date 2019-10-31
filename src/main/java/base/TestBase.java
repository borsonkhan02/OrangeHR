package base;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listener.EliteListener.class)
public class TestBase extends Saucelabs {

	@BeforeSuite

	public void setUp() {

		if (Boolean.valueOf(getProperty("saucelabs"))) {

		} else {

			setDriver();
		}
	}
	
	@Test
	public void test() {
		
	String title =	driver.getTitle();
	
	Assert.assertEquals(title, "HR Management System | HR Management Software | OrangeHRM");
	}
	

	@AfterSuite
	public void tearDown() {

		driver.quit();
	}

}
