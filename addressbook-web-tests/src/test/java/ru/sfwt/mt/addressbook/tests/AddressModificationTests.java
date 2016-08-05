package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase {

  @Test
  public void testAddressModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectAddress();
    app.getContactHelper().fillAddressForm(new AddressData("name", "last", "Address", "098765", "98765", "87654", "mail_1", "mail_2", "mail_3", null), false);
    app.getContactHelper().submitAddressModification();
    app.getContactHelper().returnToHomePage();
  }
}
