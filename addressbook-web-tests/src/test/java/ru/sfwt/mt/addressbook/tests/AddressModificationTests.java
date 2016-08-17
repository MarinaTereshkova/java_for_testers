package ru.sfwt.mt.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressModificationTests extends TestBase {

  @BeforeTest
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().addressCreationPage();
      app.contact().create(new AddressData().withFirstname("name").withLastname("last").withGroup("test1"));
    }
  }

  @Test
  public void testAddressModification() {
    List<AddressData> before = app.contact().list();
    int index = before.size() - 1;
    AddressData address = new AddressData()
            .withId(before.get(index).getId()).withFirstname("name").withLastname("last").withAddress("Address")
            .withHomenumber("098765").withtMobilenumber("98765").withWorknumber("87654")
            .withEmail1("mail_1").withEmail2("mail_2").withEmail3("mail_3");
    app.contact().modify(index, address);
    List<AddressData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(address);
    Comparator<? super AddressData> byId = (ad1, ad2) -> Integer.compare(ad1.getId(), ad2.getId());
    before.sort(byId);
    after.sort(byId);
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);
  }


}
