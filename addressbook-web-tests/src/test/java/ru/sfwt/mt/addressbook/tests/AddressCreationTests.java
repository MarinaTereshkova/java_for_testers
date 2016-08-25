package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase{

  @Test
  public void testAddressCreation() {
    app.goTo().homePage();
    Addresses before = app.contact().all();
    app.goTo().addressCreationPage();
    //AddressData address = new AddressData().withFirstname("name").withLastname("last").withGroup("test1");
    File photo = new File("/src/test/resources/images.jpg");
    app.contact().create(address);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() +1));
    Addresses after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            address.withId(after.stream().mapToInt((ad) -> ad.getId()).max().getAsInt()))));
  }

  @Test (enabled = false)
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

  @Test (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("/src/test/resources/images.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

}
