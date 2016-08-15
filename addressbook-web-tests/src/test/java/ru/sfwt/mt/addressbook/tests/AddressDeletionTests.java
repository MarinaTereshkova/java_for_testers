package ru.sfwt.mt.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.List;

public class AddressDeletionTests extends TestBase {

  @Test
  public void testAddressDeletion (){
    app.getNavigationHelper().gotoHomePage();
    List<AddressData> before = app.getContactHelper().getAddressList();
    if (! app.getContactHelper().isThereAnAderess()) {
      app.getNavigationHelper().gotoAddreessCreationPage();
      app.getContactHelper().createAddress(new AddressData("name", "last", null, null, null, null, null, null, null,"test1"));
    }
    app.getContactHelper().selectAddress(before.size() - 1);
    app.getContactHelper().deleteSelectAddress();
    app.getContactHelper().returnToHomePage();
    List<AddressData> after = app.getContactHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size() - 1);

  }
}
