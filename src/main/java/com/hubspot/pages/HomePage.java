package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.xpath("//span[contains(text(),', your account is all set up.')]");
    By userInfo = By.xpath("//span[contains(text(),'ayfer')]");
    
//To Navigate to ContactsPage
    By contactsMainTab =By.id("nav-primary-contacts-branch");
	By contactsChildTab = By.id("nav-secondary-contacts");

 
// CONSTRUCTOR
    public HomePage(WebDriver driver){
    this.driver = driver;
    elementUtil = new ElementUtil(driver);
    }
 // METHODS
  public String getHomePageTitle(){
  return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
  }
  public boolean verifyLoggedinUserInfoName(){
 return elementUtil.isElementDisplayed(userInfo);
 }
 public String getHomePageHeaderValue(){
 return elementUtil.doGetText(header);
 }
  
  public String getLoggedinUserName(){
  return elementUtil.doGetText(userInfo);
 }
  private void clickOnContacts(){
	  elementUtil.doClick(contactsMainTab);
	  elementUtil.doClick(contactsChildTab); 
  }
  public ContactsPage gotoContactsPage(){
	  clickOnContacts();
	  
	  return new ContactsPage(driver);
  }
  
}
