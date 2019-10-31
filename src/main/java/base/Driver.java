package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties {
	public static WebDriver driver;

	public void setDriver() {

		if (getProperty("browser").equalsIgnoreCase("firefox")) {

			initFirefox();

		} else if (getProperty("browser").equalsIgnoreCase("chrome")) {

			initChrome();
		} else {

			initFirefox();
		}
		
		setDriverProperties();

	}

	private void initFirefox() {

		driver = new FirefoxDriver();
	}

	private void initChrome() {

		driver = new ChromeDriver();
	}

	// this for driver setup and appurl setup
	private void setDriverProperties() {
		driver.manage().window().maximize();
		driver.get(getProperty("appUrl"));
	}

}
