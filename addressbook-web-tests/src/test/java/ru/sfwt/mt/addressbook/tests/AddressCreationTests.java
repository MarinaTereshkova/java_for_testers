package ru.sfwt.mt.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.Addresses;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContact() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/address.xml"));
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

  @DataProvider
  public Iterator<Object[]> validContactCsv() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/address.csv"));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new AddressData().withFirstname(split[0]).withLastname(split[1]).withGroup("test1")});
      line = reader.readLine();
    }

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
