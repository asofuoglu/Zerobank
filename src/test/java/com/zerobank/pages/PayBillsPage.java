package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PayBillsPage {
    public PayBillsPage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement description;
    //2021-11-23
    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(css = "#alert_content>span")
    public WebElement payMessage;

    @FindBy(css = "li.ui-state-default>a")
    public List<WebElement> payBillsTab;

    @FindBy(id = "np_new_payee_name")
    public WebElement nameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement adressInput;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement detailsInput;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "alert_content")
    public WebElement alertContent;

    @FindBy(id = "pc_currency")
    public WebElement currencyList;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateButton;

    @FindBy(xpath = "//input[@id='pc_amount']")
    public WebElement amountInput;


   public void fillPaymentForm(String amount1,String date1) throws InterruptedException {
       amount.sendKeys(amount1);
       date.sendKeys(date1);
      // description.sendKeys("loan return back");
       Thread.sleep(1500);
       payButton.click();
    }

    public void fillPaymentFormWithoutDate(String amount1) throws InterruptedException {
        amount.sendKeys(amount1);
        Thread.sleep(1500);
        payButton.click();
    }

    public void fillNewPayeeInfo(String s1,String s2,String s3,String s4) throws InterruptedException {
        nameInput.sendKeys(s1);
        adressInput.sendKeys(s2);
        accountInput.sendKeys(s3);
        detailsInput.sendKeys(s4);
        Thread.sleep(1000);
        addButton.click();
    }
    public void navigateNewPayeetab() {
        for (WebElement element : payBillsTab) {
            if (element.getText().equals("Add New Payee")) {
                element.click();
                break;
            }
        }

     }
     public boolean checkCurrencies(List<String> menuOptions) {
        Select dropdown = new Select(currencyList);
        List<WebElement> options = dropdown.getOptions();

        boolean check=true;
        List<String> list= BrowserUtils.getElementsText(options);
         System.out.println(list.toString());
         System.out.println(menuOptions.toString());
        for (String str :list ) {
           if(!menuOptions.contains(str))
               check=false;
        }
        return check;
   }
    public void navigateToPaybillsTab(String str) {
        for (WebElement element :payBillsTab) {
            if (element.getText().equals(str)) {
                element.click();
                break;
            }
        }
    }
}
