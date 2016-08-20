package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.goTo().homePage();
    Addresses before = app.contact().all();
    app.goTo().addressCreationPage();
    AddressData address = new AddressData().withFirstname("name").withLastname("last").withGroup("test1");
    app.contact().create(address);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() +1));
    Addresses after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            address.withId(after.stream().mapToInt((ad) -> ad.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadAddressCreation() {
    app.goTo().homePage();
    Addresses before = app.contact().all();
    app.goTo().addressCreationPage();
    AddressData address = new AddressData().withFirstname("name'").withLastname("last").withGroup("test1");
    app.contact().create(address);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Addresses after = app.contact().all();
    assertThat(after, equalTo(before));
  }

}
