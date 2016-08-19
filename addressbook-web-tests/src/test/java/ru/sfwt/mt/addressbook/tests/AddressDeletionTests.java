package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.List;
import java.util.Set;

public class AddressDeletionTests extends TestBase {

  @BeforeTest
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().addressCreationPage();
      app.contact().create(new AddressData().withFirstname("name").withLastname("last").withGroup("test1"));
    }
  }

  @Test
  public void testAddressDeletion (){
    Set<AddressData> before = app.contact().all();
    AddressData deletedAddress = before.iterator().next();
    app.contact().delete(deletedAddress);
    Set<AddressData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedAddress);
    Assert.assertEquals(before, after);

  }


}
