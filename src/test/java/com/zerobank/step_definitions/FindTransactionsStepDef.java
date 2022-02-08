package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class FindTransactionsStepDef {
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
    Select typeDropdown;

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.findTransactionsButton.click();
    }
    @When("clicks search")
    public void clicks_search() throws InterruptedException {
        findTransactionsPage.findButton.click();
    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws InterruptedException, ParseException {
        findTransactionsPage.sortedMostDated();
    }
    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String str1, String str2) throws InterruptedException {
        findTransactionsPage.entersDateRangeFromTo(str1,str2);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String str1, String str2) throws InterruptedException {
       findTransactionsPage.showDatesBetweenTo(str1,str2);
    }
    @Then("results table should only show descriptions containing “ONLINE”")
    public void resultsTableShouldOnlyShowDescriptionsContainingONLINE() {
        Assert.assertTrue(findTransactionsPage.OnlyShowDescriptionsContainingONLINE());
    }
    @Then("results table should only show descriptions containing “OFFICE”")
    public void resultsTableShouldOnlyShowDescriptionsContainingOFFICE() {
        Assert.assertTrue(findTransactionsPage.OnlyShowDescriptionsContainingOFFICE());
    }
    @When("the user enters description {string}")
    public void theUserEntersDescription(String str) {
        findTransactionsPage.entersDescription(str);
    }
    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String str) {
        Assert.assertTrue(findTransactionsPage.OnlyShowDescriptionsContaining(str));
    }
    @Then("verify it gives error")
    public void verifyItGivesError() {
        Assert.assertEquals(findTransactionsPage.noResultText.getText(),"No results.");
    }

    @Then("results table should show at least one result under Deposit")
    public void resultsTableShouldShowAtLeastOneResultUnderDeposit() throws InterruptedException {
        Assert.assertTrue(findTransactionsPage.OneResultUnderDeposit());
    }
    @Then("results table should show at least one result under Withdrawal")
    public void resultsTableShouldShowAtLeastOneResultUnderWithdrawal() throws InterruptedException {
        Assert.assertTrue(findTransactionsPage.OneResultUnderWithdrawal());
    }
    @But("results table should show no result under Withdrawal")
    public void resultsTableShouldShowNoResultUnderWithdrawal() {
        Assert.assertTrue(findTransactionsPage.NoResultUnderWithdrawal());
    }
    @But("results table should show no result under Deposit")
    public void resultsTableShouldShowNoResultUnderDeposit() {
     Assert.assertTrue(findTransactionsPage.NoResultUnderDeposit());
   }
    @And("the	results	table	should	only not	contain	transactions dated	{string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String str) throws InterruptedException {
        Assert.assertTrue(findTransactionsPage.notContainDate(str));
    }
    @When("user selects type {string}")
    public void userSelectsType(String type) {
        findTransactionsPage.selectType(type);
    }
}
