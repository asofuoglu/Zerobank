package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
public class PayBillsStepDef {
    DashboardPage dashboardPage = new DashboardPage();
    PayBillsPage payBillsPage = new PayBillsPage();
    @Then("go to Pay Bills page")
    public void go_to_Pay_Bills_page() {
       dashboardPage.navigatePages("Pay Bills");
    }

    @Then("Pay Bills page should have the title Zero – Pay Bill")
    public void pay_Bills_page_should_have_the_title_Zero_Pay_Bill() {
        Assert.assertEquals(Driver.get().getTitle(),"Zero - Pay Bills");
     }
    @And("make successful Pay operation {string}, {string} and verify message")
    public void makeSuccessfulPayOperationAndVerifyMessage(String amount, String date) throws InterruptedException {
        payBillsPage.fillPaymentForm(amount,date);
        Assert.assertEquals(payBillsPage.payMessage.getText(),"The payment was successfully submitted.");
    }
    @And("make a payment without entering the date  {string}")
    public void makeAPaymentWithoutEnteringTheDate(String amount) throws InterruptedException {
       payBillsPage.fillPaymentFormWithoutDate(amount);
       String actual = payBillsPage.date.getAttribute("validationMessage");
       Assert.assertEquals(actual,"Please fill out this field.");
    }
}
