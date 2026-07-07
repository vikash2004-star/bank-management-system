package model;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;




private int customerId;
private String name;
private String phoneNo;
private String email;
private String address;

public Customer(int customerId, String name, String phoneNo, String email, String address) {
    this.customerId = customerId;
    this.name = name;
    this.phoneNo = phoneNo;
    this.email = email;
    this.address = address;
}
public int getCustomerId() {
    return customerId;
}
public void setCustomerId(int customerId) {
    this.customerId = customerId;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getPhoneNo() {
    return phoneNo;
}
public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}


@Override
public String toString() {
    return "Customer{" +
            "customerId=" + customerId +
            ", name='" + name + '\'' +
            ", phoneNo='" + phoneNo + '\'' +
            ", email='" + email + '\'' +
            ", address='" + address + '\'' +
            '}';
}

}
