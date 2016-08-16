package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddressModificationTests extends TestBase {

  @BeforeTest
  public void ensurePrecondition() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAnAderess()) {
      app.getNavigationHelper().gotoAddreessCreationPage();
      app.getContactHelper().createAddress(new AddressData("name", "last", null, null, null, null, null, null, null,"test1"));
    }
  }

  @Test (enabled = false)
  public void testAddressModification() {
    List<AddressData> before = app.getContactHelper().getAddressList();
    int index = before.size() - 1;
    AddressData address = new AddressData(before.get(index).getId(), "name", "last", "Address", "098765", "98765", "87654",
            "mail_1", "mail_2", "mail_3", null);
    app.getContactHelper().modifyAddress(index, address);
    List<AddressData> after = app.getContactHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(address);
    Comparator<? super AddressData> byId = (ad1, ad2) -> Integer.compare(ad1.getId(), ad2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);
  }


}
