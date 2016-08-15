package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.HashSet;
import java.util.List;

public class AddressModificationTests extends TestBase {

  @Test
  public void testAddressModification() {
    app.getNavigationHelper().gotoHomePage();
    List<AddressData> before = app.getContactHelper().getAddressList();
    if (! app.getContactHelper().isThereAnAderess()) {
      app.getNavigationHelper().gotoAddreessCreationPage();
      app.getContactHelper().createAddress(new AddressData("name", "last", null, null, null, null, null, null, null,"test1"));
    }
    app.getContactHelper().selectAddress(before.size() - 1);
    AddressData address = new AddressData(before.get(before.size() - 1).getId(), "name", "last", "Address", "098765", "98765", "87654",
            "mail_1", "mail_2", "mail_3", null);
    app.getContactHelper().fillAddressForm(address, false);
    app.getContactHelper().submitAddressModification();
    app.getContactHelper().returnToHomePage();
    List<AddressData> after = app.getContactHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(address);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
