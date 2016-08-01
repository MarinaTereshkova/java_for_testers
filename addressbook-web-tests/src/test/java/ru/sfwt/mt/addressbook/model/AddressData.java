package ru.sfwt.mt.addressbook.model;

public class AddressData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String homenumber;
  private final String mobilenumber;
  private final String worknumber;
  private final String email1;
  private final String email2;
  private final String email3;

  public AddressData(String firstname, String lastname, String address, String homenumber, String mobilenumber, String worknumber, String email1, String email2, String email3) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.homenumber = homenumber;
    this.mobilenumber = mobilenumber;
    this.worknumber = worknumber;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomenumber() {
    return homenumber;
  }

  public String getMobilenumber() {
    return mobilenumber;
  }

  public String getWorknumber() {
    return worknumber;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }
}