package DemoQa.DemoQaPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccordianPage {

	WebDriver driver;
	
	public AccordianPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Widgetmenu = By.xpath("//div[@class='accordion']/div[4]//div[@class='header-text']");
	By Accordmenu = By.xpath("//ul[@class='menu-list']//span[text()='Accordian']");
	By cards_list = By.xpath("//div[@class='card']");
	By card_header = By.xpath("div[1]");
	By card_message = By.xpath("div[2]");
	
	public WebElement select_widget_menu() {
		return driver.findElement(Widgetmenu);
	}
	
	public WebElement select_Accord_menu() {
		return driver.findElement(Accordmenu);
	}
	
	public WebElement select_card_header() {
		return driver.findElement(card_header);
	}
	
	public WebElement select_card_message() {
		return driver.findElement(card_message);
	}
	
	public List<WebElement> select_cards() {
		return driver.findElements(cards_list);
	}
	
}
