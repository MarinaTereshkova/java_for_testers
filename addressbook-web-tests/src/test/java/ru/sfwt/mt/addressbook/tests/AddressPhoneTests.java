package ru.sfwt.mt.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressPhoneTests extends TestBase{

  @Test
  public void testAddressPhone() {
    app.goTo().homePage();
    AddressData address = app.contact().all().iterator().next();
    AddressData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(address);

    assertThat(address.getHomenumber(), equalTo(cleaned(contactInfoFromEditForm.getHomenumber())));
    assertThat(address.getMobilenumber(), equalTo(cleaned(contactInfoFromEditForm.getMobilenumber())));
    assertThat(address.getWorknumber(), equalTo(cleaned(contactInfoFromEditForm.getWorknumber())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}