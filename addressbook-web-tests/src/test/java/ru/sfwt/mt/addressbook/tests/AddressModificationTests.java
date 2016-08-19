package ru.sfwt.mt.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddressModificationTests extends TestBase {

  @BeforeTest
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().addressCreationPage();
      app.contact().create(new AddressData().withFirstname("name").withLastname("last").withGroup("test1"));
    }
  }

  @Test
  public void testAddressModification() {
    Addresses before = app.contact().all();
    AddressData modifiedAddress = before.iterator().next();
    AddressData address = new AddressData()
            .withId(modifiedAddress.getId()).withFirstname("name").withLastname("last").withAddress("Address")
            .withHomenumber("098765").withtMobilenumber("98765").withWorknumber("87654")
            .withEmail1("mail_1").withEmail2("mail_2").withEmail3("mail_3");
    app.contact().modify(address);
    Addresses after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedAddress).withAdded(address)));
  }


}
