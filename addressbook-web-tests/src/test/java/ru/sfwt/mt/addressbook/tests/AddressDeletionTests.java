package ru.sfwt.mt.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddressDeletionTests extends TestBase {

  @Test
  public void testAddressDeletion (){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectAddress();
    app.getContactHelper().deleteSelectAddress();
    app.getContactHelper().returnToHomePage();

  }
}
