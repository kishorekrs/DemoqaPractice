package DemoQa.DemoQaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserWindowPage {

	WebDriver driver;
	
	public BrowserWindowPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Alertmenu = By.xpath("//div[@class='accordion']/div[3]//div[@class='header-text']");
	By Browsermenu = By.xpath("//div[@class='accordion']/div[3]//li[@id='item-0']");
	By newTab = By.id("tabButton");
	By newwindow = By.id("windowButton");
	By newwindowmessage = By.id("messageWindowButton");
	By header = By.id("sampleHeading");
	
	public WebElement selectAlertmenu() {
		return driver.findElement(Alertmenu);
	}
	
	
	public WebElement selectBrowserWindow() {
		return driver.findElement(Browsermenu);
	}
	
	public WebElement selectNewTab() {
		return driver.findElement(newTab);
	}
	
	public WebElement selectNewWindow() {
		return driver.findElement(newwindow);
	}
	
	public WebElement selectWindowMessage() {
		return driver.findElement(newwindowmessage);
	}
	
	public WebElement selectHeader() {
		return driver.findElement(header);
	}
	
}
