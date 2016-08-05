package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().gotoAddreessCreationPage();
    app.getContactHelper().fillAddressForm(new AddressData("name", "last", null, null, null, null, null, null, null));
    app.getContactHelper().enterAddressCreation();
    app.getContactHelper().returnToHomePage();
  }

}
