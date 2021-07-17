package DemoQa.DemoQaPractice;

import java.util.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import resources.BaseClass;

public class WidgetsPractice extends BaseClass{

	AccordianPage acp;
	AutoCompletePage atp;
	JavascriptExecutor js;
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver =initializeBrowser();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		acp = new AccordianPage(driver);
		atp = new AutoCompletePage(driver);
		js = (JavascriptExecutor)driver;
	}
	
	@Test
	public void open_widgets_menu() {
		js.executeScript("arguments[0].scrollIntoView();", acp.select_widget_menu());
		acp.select_widget_menu().click();
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
	
	@Test(dependsOnMethods= {"open_widgets_menu"})
	public void test_autocomplete() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", atp.select_Autocomplete_menu());
		atp.select_Autocomplete_menu().click();
		Thread.sleep(2000);
		WebElement multi_color = atp.select_multi_color_menu();
		multi_color.click();
		String colorname = "Re";
		String xquery = "/div[text()='"+colorname+"']";
		System.out.println("xquery : "+xquery);
		multi_color.sendKeys(colorname);
		Thread.sleep(1000);
		List<WebElement> colors = driver.findElements(By.xpath("//div[@id='autoCompleteMultipleContainer']/div[2]/div/div"));
		int length = colors.size();
		System.out.println("Size :"+length);
		for(int i=0;i<length;i++) {
			System.out.println(colors.get(i).getText());
			if(colors.get(i).getText().contains("Red")) {
				colors.get(i).click();
				break;
			}
		}
//		atp.select_color_name().findElement(By.xpath(xquery)).click();
//		Actions action = new Actions(driver);
//		action.moveToElement(atp.select_color_name()).perform();
		
//		multi_color.sendKeys(Keys.ARROW_DOWN);
//		multi_color.sendKeys(Keys.ENTER);
	}
	
}


//div[@class='card'][1]/div[2]/div/p
