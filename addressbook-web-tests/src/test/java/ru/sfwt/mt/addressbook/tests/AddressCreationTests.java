package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().gotoAddreessCreationPage();
    app.getContactHelper().createAddress(new AddressData("name", "last", null, null, null, null, null, null, null,"test1"));
  }

}
