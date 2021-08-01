package DemoQa.DemoQaPractice;

import java.util.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.BaseClass;
//import sun.security.util.Length;

public class WidgetsPractice extends BaseClass{

	AccordianPage acp;
	AutoCompletePage atp;
	DatePickerPage dp;
	JavascriptExecutor js;
	TabsPage tp;
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver =initializeBrowser();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		acp = new AccordianPage(driver);
		atp = new AutoCompletePage(driver);
		dp = new DatePickerPage(driver);
		tp = new TabsPage(driver);
		js = (JavascriptExecutor)driver;
	}
	
	@Test
	public void open_widgets_menu() {
		js.executeScript("arguments[0].scrollIntoView();", acp.select_widget_menu());
		acp.select_widget_menu().click();
		System.out.println("OPEN WIDGETS MENU");
	}
	
//	@Test(dependsOnMethods= {"open_widgets_menu"})
	public void test_accordian() {
		acp.select_Accord_menu().click();
		int size = acp.select_cards().size();
		System.out.println("size of cards :"+size);
		List<WebElement> cards = acp.select_cards();
		for(WebElement card:cards) {
			js.executeScript("arguments[0].scrollIntoView();", card.findElement(By.xpath("div[1]")));
			if(card.findElement(By.xpath("div[2]")).getAttribute("class").equals("collapse")) {
				card.findElement(By.xpath("div[1]")).click();
				System.out.println(card.findElement(By.xpath("div[1]")).getText()+" Status :"+card.findElement(By.xpath("div[2]")).getAttribute("class"));
				System.out.println(card.findElement(By.xpath("div[2]")).getText());
				System.out.println("=============================");
			}
			else {
				System.out.println(card.findElement(By.xpath("div[1]")).getText()+" Status :"+card.findElement(By.xpath("div[2]")).getAttribute("class"));
				System.out.println(card.findElement(By.xpath("div[2]")).getText());
				System.out.println("=============================");
			}
		}
		
		
			
	}
	
//	@Test(dependsOnMethods= {"test_accordian"})
	public void select_Autocomplete_menu() {
		js.executeScript("arguments[0].scrollIntoView();", atp.select_Autocomplete_menu());
		atp.select_Autocomplete_menu().click();
		System.out.println("SELCET AUTOCOMPLETE MENU");
	}
	
	
//	@Test(dependsOnMethods= {"open_widgets_menu","select_Autocomplete_menu"})
	public void test_autocomplete_multicolor() throws InterruptedException {
		String[] arr = {"White","Blue","Green","Indigo"};
		System.out.println(arr.length);
		for(String colorname:arr) {
			WebElement multi_color = atp.select_multi_color_menu();
//			multi_color.click();
			multi_color.sendKeys(colorname);
//			Thread.sleep(1000);
			List<WebElement> colors = atp.select_multli_color_names();
			int length = colors.size();
			System.out.println("Size :"+length);
			for(int i=0;i<length;i++) {
				System.out.println(colors.get(i).getText());
				if(colors.get(i).getText().contains(colorname)) {
					colors.get(i).click();
					break;
				}
			}
		}
		
		System.out.println("========Selected Color Names===================");
		List<WebElement> selected_colours = atp.select_multli_color_selectednames();
		for(WebElement e:selected_colours) {
			String Color = e.findElement(By.xpath("div[1]")).getText();
//			System.out.println("Color name : "+Color);
			if(Color.contains("Blue")) {
				e.findElement(By.xpath("div[2]")).click();
				break;
			}
		}

	}
	
//	@Test(dependsOnMethods= {"open_widgets_menu","select_Autocomplete_menu"})
	public void test_autocomplete_singlecolor() throws InterruptedException {

		String colorname = "Voilet";
		WebElement single_color = atp.select_single_color_menu();
//			multi_color.click();
		single_color.sendKeys(colorname);
		Thread.sleep(1000);
		List<WebElement> colors = atp.select_single_color_names();
		int length = colors.size();
		System.out.println("Size :"+length);
		for(int i=0;i<length;i++) {
			System.out.println(colors.get(i).getText());
			if(colors.get(i).getText().contains(colorname)) {
				colors.get(i).click();
				break;
			}
		}
		String Selected_color = atp.select_single_color_selectednames().getText();
		System.out.println("Single Selected_color : "+Selected_color);
	}
	
	
	@Test(dependsOnMethods= {"open_widgets_menu"})
	public void select_Datepicker_menu() {
		js.executeScript("arguments[0].scrollIntoView();", dp.select_Date_picker_menu());
		dp.select_Date_picker_menu().click();		
	}
	
//	@Test(dependsOnMethods= {"select_Datepicker_menu"})
	public void test_SelectDate() throws InterruptedException {
		dp.select_Date_menu().click();
		dp.select_month().click();
		Select month_menu = new Select(dp.select_month());
//		month_menu.selectByValue("1");
		month_menu.selectByVisibleText("October");
		Select year_menu = new Select(dp.select_year());
		year_menu.selectByVisibleText("2022");
		Thread.sleep(5000);
		List<WebElement> dates= dp.select_date("October");
		System.out.println("Total No of Days : "+dates.size());
		for(WebElement date:dates) {
			if(date.getText().equals("19")) {
				date.click();
				break;			
			}
		}
		System.out.println("Date Choosen : "+dp.select_Date_menu().getAttribute("value"));
	}
	
//	@Test(dependsOnMethods= {"select_Datepicker_menu","test_SelectDate"})
	public void select_Datetime() {
		dp.select_Datetime_menu().click();
		dp.select_datetime_month_dropdown().click();
		List<WebElement> months = dp.select_datetime_month_names();
		for(WebElement month:months) {
			if(month.getText().equals("August")) {
				month.click();
				break;
			}
		}
		
		dp.select_datetime_year_dropdown().click();
		List<WebElement> years = dp.select_datetime_year_names();
		for(WebElement year:years) {
			if(year.getText().equals("2021")) {
				year.click();
			}
		}
		
		List<WebElement> dates= dp.select_date("August");
		System.out.println("Total No of Days : "+dates.size());
		for(WebElement date:dates) {
			if(date.getText().equals("15")) {
				date.click();
				break;			
			}
		}
		
		List<WebElement> times= dp.select_datetime_timelist();
		for(WebElement time:times) {
			if(time.getText().equals("15:15")) {
				time.click();
				break;			
			}
		}
	}
	
	
	@Test(dependsOnMethods= {"open_widgets_menu"})
	public void select_open_tabs_menu() {
		js.executeScript("arguments[0].scrollIntoView();", tp.select_tabs_menu());
		tp.select_tabs_menu().click();
		
	}
	
	@Test(dependsOnMethods= {"select_open_tabs_menu"})
	public void test_tab_menus() {
		List<WebElement> tabs=tp.get_tab_menus();
		for(WebElement tab:tabs) {
			if(!tab.getAttribute("class").contains("disabled")) {
				tab.click();
				System.out.println("=======================================");
				System.out.println(tab.getText());
				System.out.println(tp.get_menu_text(tab.getText()).getText());
			}
		}
	}
	
}









//div[@class='card'][1]/div[2]/div/p
//div[@id='autoCompleteMultipleContainer']/descendant::div[2]/div - list of selected colors
//atp.select_color_name().findElement(By.xpath(xquery)).click();
//Actions action = new Actions(driver);
//action.moveToElement(atp.select_color_name()).perform();

//multi_color.sendKeys(Keys.ARROW_DOWN);
//multi_color.sendKeys(Keys.ENTER);
