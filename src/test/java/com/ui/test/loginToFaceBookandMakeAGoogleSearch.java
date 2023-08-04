package com.ui.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginToFaceBookandMakeAGoogleSearch{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Throwable {
		/*
		 * This line of codes allows a user Login to facebook, make a post and navigate
		 * to Google to make a search
		 */

		// Setting up Selenium WebDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login to Facebook.
		String username = "teekay@mailinator.com";
		String password = "Mailinator123";
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		WebElement emailAddressTextBox = driver.findElement(By.id("email"));
		WebElement passwordTextBox = driver.findElement(By.id("pass"));
		WebElement loginButton = driver.findElement(By.name("login"));

		emailAddressTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();

		// Making a post on Facebook

		WebElement homeIcon = driver.findElement(By.xpath("//a[@aria-label='Home']"));
		homeIcon.click();
		
		//Actions actions = new Actions(driver);
		WebElement whatsOnYourMindTextbox = driver.findElement(By.xpath("//div[contains(@class,'x1lkfr')]"));
		Actions actions = new Actions(driver);
		actions.doubleClick(whatsOnYourMindTextbox);
		//whatsOnYourMindTextbox.click();

		WebElement postTextbox = driver.findElement(By.xpath("//p[contains(@class,'x16tdsg8')]"));
		postTextbox.sendKeys("I Kill Bugs!");
		WebElement postButton = driver.findElement(By.xpath("//div[contains(@class,'x1e0frkt')]"));
		postButton.click();

		// Making a search on Google
		driver.navigate().to("https://www.google.com/");
		WebElement searchTextBox = driver.findElement(By.id("input"));
		searchTextBox.sendKeys("best QA Engineering practices");
		searchTextBox.submit();

		driver.quit();
	}
}
