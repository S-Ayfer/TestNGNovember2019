package com.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

public class HomePageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		prop =basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);

	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("page title is "+title);
		Assert.assertEquals(title, "Account Setup | HubSpot");
		
	}
	@Test(priority=2,enabled=false)
	public void verifyHomePageHeaderTest(){
		String headerValue = homePage.getHomePageHeaderValue();
		System.out.println("home page header is  "+headerValue);
		Assert.assertEquals(headerValue,Constants.HOME_PAGE_HEADER);
	}
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
		
	}

}
