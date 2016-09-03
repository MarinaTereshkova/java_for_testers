package ru.sfwt.mt.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class AddressData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String firstname;

  @Expose
  @Column(name = "lastname")
  private String lastname;

  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Column(name = "home")
  @Type(type = "text")
  private String homenumber;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilenumber;

  @Column(name = "work")
  @Type(type = "text")
  private String worknumber;

  @Column(name = "email")
  @Type(type = "text")
  private String email1;

  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @Transient
  private String fullInfo;

  @Transient
  private String fullName;

  @Transient
  private String userAddress;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))

  private Set<GroupData> groups = new HashSet<GroupData>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AddressData that = (AddressData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public File getPhoto() {
    if (photo != null) {
      return new File(photo);
    } else {
      return null;
    }
  }

  public AddressData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getFullInfo() {
    return fullInfo;
  }

  public AddressData withFullInfo(String fullInfo) {
    this.fullInfo = fullInfo;
    return this;
  }

  public String getFullName() {
    return fullName;
  }

  public AddressData withFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }


  public String getUserAddress() {
    return userAddress;
  }

  public AddressData withUserAddress(String userAddress) {
    this.userAddress = userAddress;
    return this;
  }


  public String getAllEmails() {
    return allEmails;
  }

  public AddressData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public AddressData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
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

  public Groups getGroups() {
    return new Groups(groups);
  }

  @Override
  public String toString() {
    return "AddressData{" +
            "id='" + id + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public AddressData withId(int id) {
    this.id = id;
    return this;
  }

  public AddressData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public AddressData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public AddressData withAddress(String address) {
    this.address = address;
    return this;
  }

  public AddressData withHomenumber(String homenumber) {
    this.homenumber = homenumber;
    return this;
  }

  public AddressData withtMobilenumber(String mobilenumber) {
    this.mobilenumber = mobilenumber;
    return this;
  }

  public AddressData withWorknumber(String worknumber) {
    this.worknumber = worknumber;
    return this;
  }

  public AddressData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public AddressData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public AddressData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public AddressData inGroup(GroupData group) {
    groups.add(group);
    return this;
  }
}
