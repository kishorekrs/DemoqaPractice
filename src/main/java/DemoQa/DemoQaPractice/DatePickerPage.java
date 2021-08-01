package DemoQa.DemoQaPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerPage {
	
	WebDriver driver;
	
	public DatePickerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By Datepicker_menu = By.xpath("//ul[@class='menu-list']//span[text()='Date Picker']");
	By date = By.id("datePickerMonthYearInput");
	By datetime = By.id("dateAndTimePickerInput");
	By month_dropdown = By.cssSelector(".react-datepicker__month-select");
	By year_dropdown = By.className("react-datepicker__year-select");
	By datetime_month_dropdown = By.cssSelector("div[class*='__month-read'] span:nth-child(1)");
	By datetime_month_names = By.cssSelector("div[class*='datepicker__month-dropdown'] div");
	By datetime_year_dropdown = By.cssSelector("div[class*='__year-read'] span:nth-of-type(1)");
	By datetime_year_names = By.cssSelector("div[class*='datepicker__year-dropdown'] div");
	By datetime_timelist = By.cssSelector("ul[class*='time-list'] li");
	
	public WebElement select_Date_picker_menu() {
		return driver.findElement(Datepicker_menu);
	}
	
	public WebElement select_Date_menu() {
		return driver.findElement(date);
	}
	
	public WebElement select_Datetime_menu() {
		return driver.findElement(datetime);
	}
	
	public WebElement select_month() {
		return driver.findElement(month_dropdown);
	}
	
	public WebElement select_year() {
		return driver.findElement(year_dropdown);
	}
	
	public List<WebElement> select_date(String month) {
		return driver.findElements(By.xpath("//div[@class='react-datepicker__month']//div[contains(@aria-label,'"+month+"')]"));
	}
	
	public WebElement select_datetime_month_dropdown() {
		return driver.findElement(datetime_month_dropdown);
	}
	
	public List<WebElement> select_datetime_month_names() {
		return driver.findElements(datetime_month_names);
	}
	
	public WebElement select_datetime_year_dropdown() {
		return driver.findElement(datetime_year_dropdown);
	}
	
	public List<WebElement> select_datetime_year_names() {
		return driver.findElements(datetime_year_names);
	}
	
	public List<WebElement> select_datetime_timelist() {
		return driver.findElements(datetime_timelist);
	}
}
