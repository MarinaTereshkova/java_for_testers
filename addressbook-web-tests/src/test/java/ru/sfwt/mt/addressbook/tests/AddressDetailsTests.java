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
    AddressData contactInfoFromEditForm = app.contact().contactInfoFromEditForm(address);
    AddressData contactInfoDetailsForm = app.contact().contactInfoDetailsForm(address);

    String editFullInfo = mergeFullInfo(contactInfoFromEditForm);
    String detailsFullInfo = contactInfoDetailsForm.getFullInfo();

    assertThat(editFullInfo, equalTo(detailsFullInfo));
  }

  private String mergeFullInfo(AddressData contactInfoFromEditForm) {
    String result = contactInfoFromEditForm.getFirstname() + " " + contactInfoFromEditForm.getLastname()
            + "\n" + cleaned(contactInfoFromEditForm.getUserAddress())
            + "\n\n" + "H: " + contactInfoFromEditForm.getHomenumber()
            + "\n" + "M: " + contactInfoFromEditForm.getMobilenumber()
            + "\n" + "W: " + contactInfoFromEditForm.getWorknumber();

    return result;
  }

  public static String cleaned(String userAddress) {
    return userAddress.replaceAll("\\s$", "");

  }
}
