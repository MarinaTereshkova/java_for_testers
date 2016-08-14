package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getAddressCount();
    app.getNavigationHelper().gotoAddreessCreationPage();
    app.getContactHelper().createAddress(new AddressData("name", "last", null, null, null, null, null, null, null,"test1"));
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getAddressCount();
    Assert.assertEquals(after, before + 1);
  }

}
