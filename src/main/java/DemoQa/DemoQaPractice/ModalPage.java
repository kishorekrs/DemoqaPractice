package DemoQa.DemoQaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalPage {

WebDriver driver;
	
	public ModalPage(WebDriver driver) {
		this.driver =driver;
	}
	
	By Modalmenu = By.xpath("//ul[@class='menu-list']//span[text()='Modal Dialogs']");
	By small_modal = By.id("showSmallModal");
	By large_modal = By.id("showLargeModal");
	By modaltext = By.xpath("//div[@class='modal-body']");
	By close_small_modal = By.id("closeSmallModal");
	By close_large_modal = By.id("closeLargeModal");
	
	public WebElement select_modalmenu() {
		return driver.findElement(Modalmenu);
	}
	
	
	public WebElement select_smallmodal() {
		return driver.findElement(small_modal);
	}
	
	public WebElement select_largemodal() {
		return driver.findElement(large_modal);
	}
	
	public WebElement get_smallmodal_msg() {
		return driver.findElement(modaltext);
	}
	
	public WebElement close_smallmodal() {
		return driver.findElement(close_small_modal);
	}
	
	public WebElement close_largemodal() {
		return driver.findElement(close_large_modal);
	}
}
