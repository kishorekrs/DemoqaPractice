package DemoQa.DemoQaPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlertPage {

	WebDriver driver;
	
	public AlertPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Alertmenu = By.xpath("//ul[@class='menu-list']//span[text()='Alerts']");
	By alertButton = By.cssSelector("#alertButton");
	By alertTimeButton = By.id("timerAlertButton");
	By alertConfirmButton = By.id("confirmButton");
	By alertpromtButton = By.id("promtButton");
	By confirm_message =By.cssSelector("#confirmResult");
	By prompt_result =By.cssSelector("#promptResult");
	
	public WebElement selectAlertMenu() {
		return driver.findElement(Alertmenu);
	}
	
	public WebElement selectAlertButton() {
		return driver.findElement(alertButton);
	}
	
	public WebElement selectAlertTimeButton() {
		return driver.findElement(alertTimeButton);
	}
	
	public WebElement selectAlertConfirmButton() {
		return driver.findElement(alertConfirmButton);
	}
	
	public WebElement selectAlertPromptButton() {
		return driver.findElement(alertpromtButton);
	}
	
	public WebElement getConfirmMessage() {
		return driver.findElement(confirm_message);
	}
	
	public WebElement getPromptMessage() {
		return driver.findElement(prompt_result);
	}
}
