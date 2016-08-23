package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressUserAddressTests extends TestBase{
  @Test
  public void testUserAddress() {
    app.goTo().homePage();
    AddressData address = app.contact().all().iterator().next();
    AddressData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(address);

    assertThat(address.getUserAddress(), equalTo(contactInfoFromEditForm.getUserAddress()));
  }
}
