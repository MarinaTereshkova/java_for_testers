package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.List;

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
    List<AddressData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<AddressData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);

  }


}
