package ru.sfwt.mt.addressbook.tests;

import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressEmailTests extends TestBase{
  @Test
  public void testAddressEmail(){
    app.goTo().homePage();
    AddressData address = app.contact().all().iterator().next();
    AddressData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(address);

    assertThat(address.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(AddressData address) {
    return Arrays.asList(address.getEmail1(), address.getEmail2(), address.getEmail3())
            .stream()
            .filter((s) -> ! s.equals("")).collect(Collectors.joining("\n"));
  }
}
