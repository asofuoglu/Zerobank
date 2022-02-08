package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSumStepsDef {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    @Then("title should be Zero – Account summary")
    public void title_should_be_Zero_Account_summary() {
        Assert.assertEquals(Driver.get().getTitle(),"Zero - Account Summary");
    }
    @Then("Accounts types must be expected")
    public void accountsTypesMustBeExpected(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = accountSummaryPage.getActualAccountTypes();
        Assert.assertEquals(expectedAccountTypes,actualAccountTypes);
    }
    @Then("Verify Credit Accounts table must have columns")
    public void verifyCreditAccountsTableMustHaveColumns(List<String> expectedColumns) {
        List<String> actualColumns = accountSummaryPage.getActualColumns();
        Assert.assertEquals(expectedColumns,actualColumns);
    }
}
