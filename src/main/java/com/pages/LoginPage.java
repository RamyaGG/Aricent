package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(id = "okta-signin-username")
	WebElement username;

	@FindBy(className = "okta-signin-password")
	WebElement password;

	@FindBy(xpath = "//input[@class='okta-signin-password']//following-sibling::button[@value='Sign In']")
	WebElement signIn;
	
	@FindBy(xpath = "//body//p[contains(text(),'Logged in Successfully')]")
	WebElement success;

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signIn.submit();

	}
	
	public void explicitWaitForMessage() {
		new WebDriverWait(driver, 20).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(success));
		
	}
	
	public String validateLoginSuccessMessage() {
		return success.getText();
	}

}
