package DemoQa.DemoQaPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramePage {

	WebDriver driver;
	
	public FramePage(WebDriver driver) {
		this.driver =driver;
	}
	
	By frames = By.tagName("iframe");
	By n_frames = By.tagName("frame");
	By body = By.tagName("body");
	By frame_1 = By.id("frame1");
	By frame_2 = By.id("frame2");
	By heading = By.id("sampleHeading");
	By framemenu = By.xpath("//ul[@class='menu-list']//span[text()='Frames']");
	
	
	public List<WebElement> select_frames() {
		return driver.findElements(frames);
	}	
	
	public List<WebElement> select_nframes() {
		return driver.findElements(n_frames);
	}
	
	public WebElement select_frame_menu() {
		return driver.findElement(framemenu);
	}	
	
	public WebElement select_frame1() {
		return driver.findElement(frame_1);
	}
	
	public WebElement select_frame2() {
		return driver.findElement(frame_2);
	}
	
	public WebElement get_header_text() {
		return driver.findElement(heading);
	}
	
	public WebElement get_body_text() {
		return driver.findElement(body);
	}
}
