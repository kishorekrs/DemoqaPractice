package DemoQa.DemoQaPractice;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.BaseClass;

public class BrowserWindow extends BaseClass {
	
	BrowserWindowPage bwp;
	AlertPage ap;
	FramePage fp;
	ModalPage mp;
	Alert alert;
	JavascriptExecutor js;
	WebDriverWait wait;
	
//	public BrowserWindow() throws IOException{
//		System.out.println("CONSTRUCTOR INITIALIZATION STARTED");
//		driver = initializeBrowser();
//		driver.get(prop.getProperty("url"));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		this.bwp = new BrowserWindowPage(driver);
//		this.ap = new AlertPage(driver);
//		System.out.println("CONSTRUCTOR INITIALIZATION COMPLETED");
//	}
	
	@BeforeClass
	public void open_browser() throws IOException {
		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.bwp = new BrowserWindowPage(driver);
		this.ap = new AlertPage(driver);
		this.fp = new FramePage(driver);
		this.mp = new ModalPage(driver);
		js = (JavascriptExecutor) driver;
		wait= new WebDriverWait(driver,5);
	}
	
	
	@Test
	public void open_Alert_menus() {
		System.out.println("Open_Alert_Menu_Executing");
		WebElement Element = bwp.selectAlertmenu();
		js.executeScript("arguments[0].scrollIntoView();", Element);
		bwp.selectAlertmenu().click();
	}
	
	
	
	@Test(dependsOnMethods= {"open_Alert_menus"})
	public void test_newTab() throws InterruptedException {
//		action.moveToElement(bwp.selectBrowserWindow()).perform();
		bwp.selectBrowserWindow().click();
		bwp.selectNewTab().click();
		Thread.sleep(3000);
		switch_tab_or_window();
		bwp.selectNewWindow().click();
		Thread.sleep(3000);
		switch_tab_or_window();
	}
	
	public void switch_tab_or_window() {
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parenttab = it.next();
		String childtab = it.next();
		driver.switchTo().window(childtab);
		System.out.println("Child Tab Title :"+driver.getTitle());
		System.out.println("Child Tab Url :"+driver.getCurrentUrl());
		System.out.println("Header Message : "+bwp.selectHeader().getText());
		driver.close();
		driver.switchTo().window(parenttab);
		System.out.println("Default Tab Title :"+driver.getTitle());
		System.out.println("Default Tab Url :"+driver.getCurrentUrl());
	}
	
	@Test(dependsOnMethods= {"open_Alert_menus"})
	public void test_Alert_Button() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", ap.selectAlertMenu());
		ap.selectAlertMenu().click();
		ap.selectAlertButton().click();
//		Thread.sleep(5000);
		alert = driver.switchTo().alert();
		Assert.assertEquals("You clicked a button", alert.getText());
		alert.accept();
	}
	
	
	@Test(dependsOnMethods= {"open_Alert_menus"})
	public void test_Alert_Confirm_Button() throws InterruptedException {
		ap.selectAlertConfirmButton().click();
//		Thread.sleep(2000);
		alert.accept();
		Assert.assertTrue(ap.getConfirmMessage().getText().contains("Ok"));
		ap.selectAlertConfirmButton().click();
//		Thread.sleep(2000);
		alert.dismiss();
		Assert.assertTrue(ap.getConfirmMessage().getText().contains("Cancel"));
	}
	
	@Test(dependsOnMethods= {"open_Alert_menus"})
	public void test_Alert_Prompt_Button() throws InterruptedException {
		ap.selectAlertPromptButton().click();
//		Thread.sleep(2000);
		alert.sendKeys("Testing");
		alert.accept();
		System.out.println(ap.getPromptMessage().isDisplayed());
		System.out.println(ap.getPromptMessage().getText());
	}
		
	@Test(dependsOnMethods= {"open_Alert_menus"})
	public void test_TimeAlert_Button() throws InterruptedException {
		ap.selectAlertTimeButton().click();
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		
	}
	
	@Test(dependsOnMethods= {"open_Alert_menus"})
	public void test_frames_using_id() {
		js.executeScript("arguments[0].scrollIntoView();", fp.select_frame_menu());
		fp.select_frame_menu().click();
		driver.switchTo().frame(fp.select_frame1());
		System.out.println(fp.get_header_text().getText());
		driver.switchTo().parentFrame();
		driver.switchTo().frame(fp.select_frame2());
		System.out.println(fp.get_header_text().getText());
		driver.switchTo().parentFrame();
	}
	
	@Test(dependsOnMethods= {"open_Alert_menus"})
	public void test_modal() {
		js.executeScript("arguments[0].scrollIntoView();", mp.select_modalmenu());
		mp.select_modalmenu().click();
		mp.select_smallmodal().click();
		System.out.println(mp.get_smallmodal_msg().getText());
		mp.close_smallmodal().click();
		mp.select_largemodal().click();
		System.out.println(mp.get_smallmodal_msg().getText());
		mp.close_largemodal().click();
		
	}
	
	
	@Test(dependsOnMethods= {"open_Alert_menus","test_modal","test_newTab"})
	public void test_nested_frames() {
//		driver.get(prop.getProperty("nested_frames"));
		driver.get(prop.getProperty("nested_frames"));
		int size = fp.select_nframes().size();
		System.out.println("Total No of Frame " +size);
		for(int i=0;i<size;i++) {
			driver.switchTo().frame(i);
			int frames_size = fp.select_nframes().size();
			System.out.println(i+" index inner frame size is "+frames_size);
			for(int j=0;j<frames_size;j++) {
				driver.switchTo().frame(j);
				System.out.println(fp.get_body_text().getText());
				driver.switchTo().parentFrame();
				}
			driver.switchTo().defaultContent();
		}
		driver.close();
	}


	}
	
	

