package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressPhoneTests extends TestBase{

  @Test
  public void testAddressPhone() {
    app.goTo().homePage();
    AddressData address = app.contact().all().iterator().next();
    AddressData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(address);

    assertThat(address.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

  }

  private String mergePhones(AddressData address) {
    return Arrays.asList(address.getHomenumber(), address.getMobilenumber(), address.getWorknumber()).stream()
            .filter((s) -> ! s.equals(""))
            .map(AddressPhoneTests::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}