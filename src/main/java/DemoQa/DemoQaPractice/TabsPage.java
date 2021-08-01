package DemoQa.DemoQaPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TabsPage {
	
	WebDriver driver;
	
	public TabsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Tabs_menu = By.xpath("//ul[@class='menu-list']//span[text()='Tabs']");
	By tabs_menu_list = By.cssSelector("nav[role='tablist'] a");
	By menu_text = By.cssSelector("div[role='tabpanel'] p");
	
	
	public WebElement select_tabs_menu() {
		return driver.findElement(Tabs_menu);
	}
	
	public List<WebElement> get_tab_menus() {
		return driver.findElements(tabs_menu_list);
	}

	public List<WebElement> get_menu_text() {
		return driver.findElements(menu_text);
	}
	
	public WebElement get_menu_text(String tabname) {
		tabname = tabname.toLowerCase();
		return driver.findElement(By.cssSelector("div[id*='"+tabname+"'] p"));
		
	}
}
