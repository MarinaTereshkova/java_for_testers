package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    assertThat(app.contact().count(), equalTo(before.size()));
    Addresses after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedAddress).withAdded(address)));
  }


}
