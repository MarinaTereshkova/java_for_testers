package ru.sfwt.mt.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressDetailsTests extends TestBase{
  @Test
  public void testAddressDetails() {
    app.goTo().homePage();
    AddressData address = app.contact().all().iterator().next();
    AddressData contactInfoFromEditForm = app.contact()
            .contactInfoFromEditForm(address);
    AddressData contactInfoDetailsForm = app.contact()
            .contactInfoDetailsForm(address);


    assertThat(mergeFullName(contactInfoFromEditForm), equalTo(contactInfoDetailsForm.getFullName()));


  }

  private String mergeFullName(AddressData contactInfoFromEditForm) {
    String result = contactInfoFromEditForm.getFirstname() + " " + contactInfoFromEditForm.getLastname();
    return result;
  //  return Arrays.asList(contactInfoFromEditForm.getFirstname(), contactInfoFromEditForm.getLastname())
  //          .stream()
  //          .filter((s) -> ! s.equals("")).collect(Collectors.joining("\\s"));
  }
}
