package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDef {
    PayBillsPage payBillsPage = new PayBillsPage();
    @And("following currencies should be available")
    public void followingCurrenciesShouldBeAvailable(List<String> menuOptions) {
        Assert.assertTrue(payBillsPage.checkCurrencies(menuOptions));
    }
    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() throws InterruptedException {
        payBillsPage.amountInput.sendKeys("200");
        payBillsPage.calculateButton.click();
    }
    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() throws InterruptedException {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals(alert.getText(),"Please, ensure that you have filled all the required fields with valid values.");
    }
    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        Select dropdown = new Select(payBillsPage.currencyList);
        dropdown.selectByIndex(3);
        payBillsPage.calculateButton.click();
    }
    @Given("the user accesses the {string} cash tab")
    public void theUserAccessesTheCashTab(String tab) {
        payBillsPage.navigateToPaybillsTab(tab);
    }
}
