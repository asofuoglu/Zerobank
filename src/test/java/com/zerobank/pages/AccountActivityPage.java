package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
     }
     @FindBy(id = "aa_accountId")
    public WebElement dropDown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']//tr/th")
    public List<WebElement> transanctionTable;

    @FindBy(xpath = "//table[@class='table']//td//a")
    public List<WebElement> accountTableLink;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactionsButton;

    public List<String> selectAllOptionsDropdown(WebElement element) {
        Select Dropdown = new Select(element);
        return  BrowserUtils.getElementsText(Dropdown.getOptions());
    }
}

