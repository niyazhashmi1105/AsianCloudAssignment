package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDrivers {
	
	public static WebDriver getDriver(DriverManagerType browserName) {
	    switch (browserName.getDriver()) {
	        case "chromedriver":
	            ChromeOptions chromeOptions = new ChromeOptions();
	           // chromeOptions.addArguments("--headless");
	            chromeOptions.addArguments("--disable-notifications");
	            WebDriverManager.chromedriver().setup();
	            return new ChromeDriver(chromeOptions);
	        case "firefoxdriver":
	            WebDriverManager.firefoxdriver().setup();
	            return new FirefoxDriver();
	        case "edgedriver":
	            WebDriverManager.edgedriver().setup();
	            return new EdgeDriver();
	    }
	    return null;
	}

}
