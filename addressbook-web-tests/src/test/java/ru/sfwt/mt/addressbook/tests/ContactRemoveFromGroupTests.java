package ru.sfwt.mt.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;
import ru.sfwt.mt.addressbook.model.GroupData;

public class ContactRemoveFromGroupTests extends TestBase{
  @BeforeTest
  public void ensurePreconditionCreateContact() {
    if (app.db().addresses().size() == 0) {
      app.goTo().homePage();
      app.goTo().addressCreationPage();
      app.contact().create(new AddressData().withFirstname("name").withLastname("last"));
    }
  }
  @BeforeTest
  public void ensurePreconditionCreateGroup() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }
  @BeforeTest
  public void ensurePreconditionContactIntoGroup() {
    app.goTo().homePage();
    app.contact().selectContactForAdd();
    app.contact().selectGroupForAdd();
    app.contact().addContactIntoGroup();
    app.contact().returnToHomePage();
  }
  @Test
  public void testContactRemoveFromGroup() {
    app.goTo().homePage();
    app.contact().selectGroupForRemove();
    app.contact().selectContactForAdd();
    app.contact().removeContactFromGroup();
    app.contact().returnToHomePage();
  }
}
