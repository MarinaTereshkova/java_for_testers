package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.List;

public class AddressDeletionTests extends TestBase {

  @BeforeTest
  public void ensurePrecondition() {
    app.goTo().gotoHomePage();
    if (! app.getContactHelper().isThereAnAderess()) {
      app.goTo().gotoAddreessCreationPage();
      app.getContactHelper().createAddress(new AddressData("name", "last", null, null, null, null, null, null, null,"test1"));
    }
  }

  @Test (enabled = false)
  public void testAddressDeletion (){
    List<AddressData> before = app.getContactHelper().getAddressList();
    app.getContactHelper().selectAddress(before.size() - 1);
    app.getContactHelper().deleteSelectAddress();
    app.getContactHelper().returnToHomePage();
    List<AddressData> after = app.getContactHelper().getAddressList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    //for (int i = 0; i < after.size(); i++) {
    //  Assert.assertEquals(before.get(i), after.get(i));
    //}
    Assert.assertEquals(before, after);

  }
}
