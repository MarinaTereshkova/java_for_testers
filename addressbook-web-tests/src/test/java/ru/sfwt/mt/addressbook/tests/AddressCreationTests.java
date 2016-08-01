package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.gotoAddreessCreationPage();
    app.fillAddressForm(new AddressData("name", "last", "Address", "098765", "98765", "87654", "mail_1", "mail_2", "mail_3"));
    app.enterAddressCreation();
    app.returnToHomePage();
  }

}
