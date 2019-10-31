package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Saucelabs extends Driver {
	
	DesiredCapabilities caps;

	public void setSauceLabs() {

		String USERNAME = getSaucelabproperty("userName");
		String ACCESS_KEY = getSaucelabproperty("accessKey");
		String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

		setCapabilities();
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(getProperty("appUrl"));
	}

	private void setCapabilities() {

		if (getSaucelabproperty("browser").equalsIgnoreCase("chrome")) {

			caps = DesiredCapabilities.chrome();
		} else if (getSaucelabproperty("browser").equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();

		} else if (getSaucelabproperty("browser").equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();

		} else if (getSaucelabproperty("browser").equalsIgnoreCase("ie")) {
			caps = DesiredCapabilities.internetExplorer();

		} else {
			caps = DesiredCapabilities.firefox();
		}

		caps.setCapability("platform", getSaucelabproperty("platform"));
		caps.setCapability("version", getSaucelabproperty("browserVersion"));
	}

}
