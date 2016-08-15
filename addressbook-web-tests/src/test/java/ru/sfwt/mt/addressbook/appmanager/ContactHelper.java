package ru.sfwt.mt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.sfwt.mt.addressbook.model.AddressData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void enterAddressCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillAddressForm(AddressData addressData, boolean creation) {
    type("firstname", addressData.getFirstname());
    type("lastname", addressData.getLastname());
    type("address", addressData.getAddress());
    type("home", addressData.getHomenumber());
    type("mobile", addressData.getMobilenumber());
    type("work", addressData.getWorknumber());
    type("email", addressData.getEmail1());
    type("email2", addressData.getEmail2());
    type("email3", addressData.getEmail3());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectAddress(int index) {
     //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    WebElement row = wd.findElements(By.cssSelector("tr[name=entry]")).get(index);
    row.findElement(By.xpath("./td[8]/a/img")).click();
  }

  public void submitAddressModification() {
    click(By.name("update"));
  }

  public void deleteSelectAddress() {
    click(By.xpath("//div/div[4]/form[2]/input[2]"));
  }

  public void createAddress(AddressData address) {
    fillAddressForm(address, true);
    enterAddressCreation();
    returnToHomePage();
  }

  public boolean isThereAnAderess() {
    //return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    return isElementPresent(By.xpath("//table[@id='maintable']//tr[2]"));
  }

  public int getAddressCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
