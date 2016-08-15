package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.HashSet;
import java.util.List;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<AddressData> before = app.getContactHelper().getAddressList();
    app.getNavigationHelper().gotoAddreessCreationPage();
    AddressData address = new AddressData("name", "last", null, null, null, null, null, null, null,"test1");
    app.getContactHelper().createAddress(address);
    app.getNavigationHelper().gotoHomePage();
    List<AddressData> after = app.getContactHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (AddressData g : after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    address.setId(max);
    before.add(address);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
