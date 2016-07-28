package ru.sfwt.mt.addressbook;

import org.testng.annotations.Test;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    gotoAddreessCreationPage();
    fillAddressForm(new AddressData("name", "last", "Address", "098765", "98765", "87654", "mail_1", "mail_2", "mail_3"));
    enterAddressCreation();
    returnToHomePage();
  }

}
