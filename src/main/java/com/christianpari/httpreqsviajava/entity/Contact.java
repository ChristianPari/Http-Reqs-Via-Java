package com.christianpari.httpreqsviajava.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "CONTACT_TABLE")
public class Contact {

  @Id
  public String id;
  public String name;
  public String phone;
  public String fax;
  public String company;
  public String address;

  public Contact() {
  }

  public Contact(
    String name
    , String phone
    , String fax
    , String company
    , String address
  ) {
    id = UUID.randomUUID().toString();
    this.name = name;
    this.phone = phone;
    this.fax = fax;
    this.company = company;
    this.address = address;
  }

  @Override
  public String toString() {
    return "Contact {" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", phone='" + phone + '\'' +
      ", fax='" + fax + '\'' +
      ", company='" + company + '\'' +
      ", address='" + address + '\'' +
      '}';
  }
}
