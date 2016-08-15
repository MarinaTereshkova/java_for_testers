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
  private String group;

  public AddressData(String firstname, String lastname, String address, String homenumber, String mobilenumber, String worknumber, String email1, String email2, String email3, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.homenumber = homenumber;
    this.mobilenumber = mobilenumber;
    this.worknumber = worknumber;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.group = group;
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

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "AddressData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddressData that = (AddressData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
