package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;


	public WebDriver initializeBrowser() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Kishore kumar\\eclipse-workspace\\DemoQaPractice\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);
		String browser_name = prop.getProperty("browser");
		System.out.println("browser_name :"+browser_name);
		System.out.println(prop.getProperty("url"));
		if(browser_name.equals("chrome")) {
			DesiredCapabilities ds = DesiredCapabilities.chrome();
			ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ds.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ChromeOptions co = new ChromeOptions();
			co.merge(ds);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kishore kumar\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver(co);
			driver.manage().window().maximize();
		}
		return driver;
	}

}
