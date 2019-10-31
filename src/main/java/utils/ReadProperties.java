package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	// this is for testRun file
	public String getProperty(String key) {
		String value = null;
		key = key.trim();

		Properties prop = loadProperty("testRun");

		value = prop.getProperty(key);

		if (value == null) {

			String testEnv = prop.getProperty("testEnv");
			prop = loadProperty(testEnv);

			value = prop.getProperty(key);

		}
		return value;
	}

	// for saucelabs properties
	public String getSaucelabproperty(String key) {
		String value = " ";
		key = key.trim();

		Properties prop = loadProperty("saucelabs");

		value = prop.getProperty(key);

		return value;
	}

	// this is from properties package to all properties file
	public Properties loadProperty(String propFileName) {
		Properties prop = new Properties();

		String path = ".\\src\\main\\resource\\properties\\" + propFileName.trim() + ".properties";

		try {
			File file = new File(path);
			FileInputStream fileStream = new FileInputStream(file);
			prop.load(fileStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

}
