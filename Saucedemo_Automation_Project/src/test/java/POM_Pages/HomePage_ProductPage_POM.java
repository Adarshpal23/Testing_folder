package POM_Pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.BasePage;

public class HomePage_ProductPage_POM extends BasePage{
	private Logger log = LogManager.getLogger(HomePage_ProductPage_POM.class);

	public HomePage_ProductPage_POM(WebDriver wd)
	{
//	super(wd);
super(wd);
	}

	// Locators repository

	
	@FindBy(id="logout_sidebar_link")
	WebElement lgout;
	@FindBy(id="add-to-cart-sauce-labs-backpack")WebElement addcart;
	@FindBy(id="react-burger-menu-btn")
	WebElement menu;

	@FindBy(id="shopping_cart_container")
	WebElement cart;
	
	public void click_on_menu() {

		menu.click(); 
		log.info("Menu options displayed");
		}

		public void click_on_logout()
		{
		lgout.click(); 
		log.info("Navigating to login page");

		}

		public void click_on_add_to_cart_button()
		{
		addcart.click(); 
log.info("Product added to cart");
		}
		public void click_on_cart_icon()

		{

		cart.click(); 
		log.info("Navigating to cart page");
		}
		public void logout_process() {

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    menu.click();

		    wait.until(ExpectedConditions.visibilityOf(lgout));

		    wait.until(ExpectedConditions.elementToBeClickable(lgout));

		    lgout.click();

		    log.info("User logged out successfully");
		}
}
