package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class AddNewPayeeStepDef {
    DashboardPage dashboardPage = new DashboardPage();
    PayBillsPage payBillsPage = new PayBillsPage();
    @Then("Add New Payee tab")
    public void add_New_Payee_tab() {
        payBillsPage.navigateNewPayeetab();
    }
    @Then("creates new payee using following information with {string} {string} {string} {string}")
    public void creates_new_payee_using_following_information_with(String string, String string2, String string3, String string4) throws InterruptedException {
        payBillsPage.fillNewPayeeInfo(string,string2,string3,string4);
    }
    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        String expected = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Assert.assertEquals(payBillsPage.alertContent.getText(),expected);
    }
}




