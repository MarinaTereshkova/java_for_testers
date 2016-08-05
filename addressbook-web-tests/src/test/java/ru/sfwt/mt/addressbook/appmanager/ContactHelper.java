package ru.sfwt.mt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

  public void fillAddressForm(AddressData addressData) {
    type("firstname", addressData.getFirstname());
    type("lastname", addressData.getLastname());
    type("address", addressData.getAddress());
    type("home", addressData.getHomenumber());
    type("mobile", addressData.getMobilenumber());
    type("work", addressData.getWorknumber());
    type("email", addressData.getEmail1());
    type("email2", addressData.getEmail2());
    type("email3", addressData.getEmail3());
    }

  public void selectAddress() {
    click(By.xpath("//div/div[4]/form[2]/table/tbody/tr[5]/td[8]/a/img"));
  }

  public void submitAddressModification() {
    click(By.name("update"));
  }

  public void deleteSelectAddress() {
    click(By.xpath("//div/div[4]/form[2]/input[2]"));
  }

}
