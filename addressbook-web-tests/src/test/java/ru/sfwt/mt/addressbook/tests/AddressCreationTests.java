package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContact() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new AddressData().withFirstname("name1").withLastname("last1").withGroup("test1")});
    list.add(new Object[] {new AddressData().withFirstname("name2").withLastname("last2").withGroup("test1")});
    list.add(new Object[] {new AddressData().withFirstname("name2").withLastname("last2").withGroup("test1")});
    return list.iterator();

  }

  @Test(dataProvider = "validContact")
  public void testAddressCreation(AddressData address) {
    app.goTo().homePage();
    Addresses before = app.contact().all();
    app.goTo().addressCreationPage();
    app.contact().create(address);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() +1));
    Addresses after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(
            address.withId(after.stream().mapToInt((ad) -> ad.getId()).max().getAsInt()))));
  }
  @Test
  public void testAddressCreationPhoto() {
    app.goTo().homePage();
    Addresses before = app.contact().all();
    app.goTo().addressCreationPage();
    File photo = new File("/src/test/resources/images.jpg");
    AddressData address = new AddressData().withFirstname("name").withLastname("last").withPhoto(photo).withGroup("test1");
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
