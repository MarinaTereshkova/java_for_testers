package ru.sfwt.mt.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressPhoneEmailUserAddressTests extends TestBase{
  @Test
  public void testAddressPhoneEmailUserAddress(){
    app.goTo().homePage();
    AddressData address = app.contact().all().iterator().next();
    AddressData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(address);

    assertThat(address.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(address.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(address.getUserAddress(), equalTo(contactInfoFromEditForm.getUserAddress()));
  }
  private String mergePhones(AddressData address) {
    return Arrays.asList(address.getHomenumber(), address.getMobilenumber(), address.getWorknumber()).stream()
            .filter((s) -> ! s.equals(""))
            .map(AddressPhoneTests::cleaned).collect(Collectors.joining("\n"));
  }
  private String mergeEmails(AddressData address) {
    return Arrays.asList(address.getEmail1(), address.getEmail2(), address.getEmail3())
            .stream()
            .filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }
  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
