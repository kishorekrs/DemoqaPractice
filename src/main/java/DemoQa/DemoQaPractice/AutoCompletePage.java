package DemoQa.DemoQaPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoCompletePage {

	WebDriver driver;
	
	public AutoCompletePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Autocomplete_menu = By.xpath("//ul[@class='menu-list']//span[text()='Auto Complete']");
	By multi_color_menu = By.xpath("//div[contains(@id,'MultipleContainer')]//div[@class='auto-complete__input']/input");
	By multli_color_name = By.xpath("//div[contains(@id,'MultipleContainer')]//div[contains(@class,'value__label')]");
	By remove_multi_color = By.xpath("//div[contains(@id,'MultipleContainer')]//div[contains(@class,'value__remove')]");
	By single_color_menu = By.cssSelector("div[id*='SingleContainer']");
	By select_color_name = By.xpath("//div[contains(@id,'MultipleContainer')]//div[text()='Red']");
	
	public WebElement select_Autocomplete_menu() {
		return driver.findElement(Autocomplete_menu);
	}
	
	public WebElement select_multi_color_menu() {
		return driver.findElement(multi_color_menu);
	}
	
	public WebElement select_single_color_menu() {
		return driver.findElement(single_color_menu);
	}
	
	public WebElement select_remove_multi_color() {
		return driver.findElement(remove_multi_color);
	}
	
	public WebElement select_color_name() {
		return driver.findElement(select_color_name);
	}
	
	public List<WebElement> select_multli_color_name() {
		return driver.findElements(multli_color_name);
	}
}
