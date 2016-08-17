package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressCreationTests extends TestBase{

  @Test (enabled = false)
  public void testAddressCreation() {
    app.goTo().homePage();
    List<AddressData> before = app.contact().list();
    app.goTo().addressCreationPage();
    AddressData address = new AddressData("name", "last", null, null, null, null, null, null, null,"test1");
    app.contact().create(address);
    app.goTo().homePage();
    List<AddressData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    //address.setId(after.stream().max((Comparator<AddressData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(address);
    Comparator<? super AddressData> byId = (ad1, ad2) -> Integer.compare(ad1.getId(), ad2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);
  }

}
