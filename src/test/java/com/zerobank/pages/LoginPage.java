package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    DashboardPage dashboardPage = new DashboardPage();
    @FindBy(name ="user_login")
    public WebElement usernameInput;

    @FindBy(id ="user_password")
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit"));
    @FindBy(name = "submit")
    public WebElement loginBtn;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li")
    public WebElement accountSummaryButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement alertError;

    public void login(){
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);
        //loginBtn.click();
    }
    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password+ Keys.ENTER);
        //loginBtn.click();
    } public void navigateToLoginPage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        dashboardPage.signinButton.click();
    }}


