package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.navigateToLoginPage();
    }
    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        loginPage.login();
    }
    @Then("Account summary page should be displayed.")
    public void account_summary_page_should_be_displayed() {
        String expected = "Account Summary";
        String actual = loginPage.accountSummaryButton.getText();
        Assert.assertEquals(actual, expected);
    }
    @When("the user enters invalid {string} and {string}")
    public void theUserEntersInvalidAnd(String username, String password) {
        loginPage.login(username, password);
    }
    @Then("Alert error is seen")
    public void alertErrorIsSeen() throws InterruptedException {
        Thread.sleep(1500);
        String expected = "Login and/or password are wrong.";
        String actual = loginPage.alertError.getText();
        Assert.assertEquals(actual, expected);
    }
}