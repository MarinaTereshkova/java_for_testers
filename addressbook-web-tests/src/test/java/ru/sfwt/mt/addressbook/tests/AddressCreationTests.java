package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().gotoAddreessCreationPage();
    app.getContactHelper().fillAddressForm(new AddressData("name", "last", "Address", "098765", "98765", "87654", "mail_1", "mail_2", "mail_3"));
    app.getContactHelper().enterAddressCreation();
    app.getContactHelper().returnToHomePage();
  }

}
