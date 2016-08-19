package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.goTo().homePage();
    Set<AddressData> before = app.contact().all();
    app.goTo().addressCreationPage();
    AddressData address = new AddressData().withFirstname("name").withLastname("last").withGroup("test1");
    app.contact().create(address);
    app.goTo().homePage();
    Set<AddressData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    address.withId(after.stream().mapToInt((ad) -> ad.getId()).max().getAsInt());
    before.add(address);
    Assert.assertEquals(before, after);
  }

}
