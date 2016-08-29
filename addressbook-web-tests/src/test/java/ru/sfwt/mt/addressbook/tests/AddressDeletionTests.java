package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressDeletionTests extends TestBase {

  @BeforeTest
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().addressCreationPage();
      app.contact().create(new AddressData().withFirstname("name").withLastname("last").withGroup("test1"));
    }
  }

  @Test
  public void testAddressDeletion (){
    Addresses before = app.contact().all();
    AddressData deletedAddress = before.iterator().next();
    app.contact().delete(deletedAddress);
    assertThat(app.contact().count(), equalTo(before.size() -1));
    Addresses after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedAddress)));

  }


}
