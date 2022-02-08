package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepsDef {
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    DashboardPage dashboardPage = new DashboardPage();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("go to Account Activity page")
    public void go_to_Account_Activity_page() throws InterruptedException {
        dashboardPage.navigatePages("Account Activity");
    }
    @And("Account Activity page should have the title Zero – Account activity.")
    public void accountActivityPageShouldHaveTheTitleZeroAccountActivity() {
        Assert.assertEquals(Driver.get().getTitle(),"Zero - Account Activity");
   }
    @And("Account drop down default option should be Savings")
    public void accountDropDownDefaultOptionShouldBeSavings() {
        Select select = new Select(accountActivityPage.dropDown);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Savings");
    }
    @And("Account drop down should have the following options..")
    public void accountDropDownShouldHaveTheFollowingOptions(List<String> expectedDropDownOptionsList) {
        Assert.assertEquals(expectedDropDownOptionsList,accountActivityPage.selectAllOptionsDropdown(accountActivityPage.dropDown));
        }
    @And("Transactions table should have column names..")
    public void transactionsTableShouldHaveColumnNames(List<String> expectedTransactionsTableColumn) {
        List<String> actualDropDownOptionsList =BrowserUtils.getElementsText(accountActivityPage.transanctionTable);
        Assert.assertEquals(expectedTransactionsTableColumn,actualDropDownOptionsList);
    }
   @And("the Account Activity page should be displayed")
    public void theAccountActivityPageShouldBeDisplayed() throws InterruptedException {
      Assert.assertEquals(Driver.get().getTitle(),"Zero - Account Activity");
    }
    @Then("the user clicks on {string} link on the Account Summary page")
    public void theUserClicksOnLinkOnTheAccountSummaryPage(String link) {
        accountSummaryPage.selectDropdownLink(link);
    }
    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String link){
        Assert.assertEquals(new Select(accountActivityPage.dropDown).getFirstSelectedOption().getText(),link);
    }
}
