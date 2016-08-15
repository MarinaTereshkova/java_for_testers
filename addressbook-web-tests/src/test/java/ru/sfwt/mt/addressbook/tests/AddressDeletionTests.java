package ru.sfwt.mt.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

public class AddressDeletionTests extends TestBase {

  @Test
  public void testAddressDeletion (){
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getAddressCount();
    if (! app.getContactHelper().isThereAnAderess()) {
      app.getNavigationHelper().gotoAddreessCreationPage();
      app.getContactHelper().createAddress(new AddressData("name", "last", null, null, null, null, null, null, null,"test1"));
    }
    app.getContactHelper().selectAddress(before - 1);
    app.getContactHelper().deleteSelectAddress();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getAddressCount();
    Assert.assertEquals(after, before - 1);

  }
}
