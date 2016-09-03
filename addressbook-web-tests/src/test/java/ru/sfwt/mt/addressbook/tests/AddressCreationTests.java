package ru.sfwt.mt.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;
import ru.sfwt.mt.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/address.json"))) {
      String json ="";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<AddressData> addresses = gson.fromJson(json, new TypeToken<List<AddressData>>(){}.getType());
      return addresses.stream().map((ad) -> new Object[] {ad}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/address.xml"))) {
      String xml ="";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(AddressData.class);
      List<AddressData> addresses = (List<AddressData>)xstream.fromXML(xml);
      return addresses.stream().map((ad) -> new Object[] {ad}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactFromCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/address.csv"));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new AddressData().withFirstname(split[0]).withLastname(split[1])});
              //.withGroup("test1")});
      line = reader.readLine();
    }
    return list.iterator();

  }
  @Test(dataProvider = "validContactFromJson")
  public void testAddressCreation(AddressData address) {
    app.goTo().homePage();
    Addresses before = app.db().addresses();
    app.goTo().addressCreationPage();
    app.contact().create(address);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() +1));
    Addresses after = app.db().addresses();
    assertThat(after, equalTo(before.withAdded(
            address.withId(after.stream().mapToInt((ad) -> ad.getId()).max().getAsInt()))));
    verifyAddressListUI();
  }


// @Test
// public void testAddressCreationPhoto() {
//   app.goTo().homePage();
//   Addresses before = app.db().addresses();
//   app.goTo().addressCreationPage();
//   File photo = new File("/src/test/resources/images.jpg");
//   AddressData address = new AddressData().withFirstname("name").withLastname("last").withPhoto(photo).withGroup("test1");
//   app.contact().create(address);
//   app.goTo().homePage();
//   assertThat(app.contact().count(), equalTo(before.size() +1));
//   Addresses after = app.db().addresses();
//   assertThat(after, equalTo(before.withAdded(
//           address.withId(after.stream().mapToInt((ad) -> ad.getId()).max().getAsInt()))));
// }

  @Test
  public void testBadAddressCreation() {
    app.goTo().homePage();
    Addresses before = app.db().addresses();
    app.goTo().addressCreationPage();
    AddressData address = new AddressData().withFirstname("name'").withLastname("last");
            //.withGroup("test1");
    app.contact().create(address);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()));
    Addresses after = app.db().addresses();
    assertThat(after, equalTo(before));
    verifyAddressListUI();
  }

  @Test
  public void testAddressCreationAddInGroup() {
    Groups groups = app.db().groups();
    app.goTo().homePage();
    Addresses before = app.db().addresses();
    app.goTo().addressCreationPage();
    AddressData address = new AddressData().withFirstname("name").withLastname("last").inGroup(groups.iterator().next());
    app.contact().create(address);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size() +1));
    Addresses after = app.db().addresses();
    assertThat(after, equalTo(before.withAdded(
           address.withId(after.stream().mapToInt((ad) -> ad.getId()).max().getAsInt()))));
    verifyAddressListUI();
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
