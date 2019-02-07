package com.sizmek.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();

	}
	
	@Test(priority=1)
	public void loginTest() {
		loginPage.login("username", "password");
		loginPage.explicitWaitForMessage();
	}
	
	@Test(priority=2)
	public void validateLoginSuccessMessageTest() {
		String SuccessMessage = loginPage.validateLoginSuccessMessage();
		Assert.assertEquals(SuccessMessage, "Logged in Successfully", "Login failed error");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
