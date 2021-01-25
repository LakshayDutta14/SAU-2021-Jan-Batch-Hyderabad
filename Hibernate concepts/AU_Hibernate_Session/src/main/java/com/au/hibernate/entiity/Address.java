package com.au.hibernate.entiity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Address_Table")
@Setter
@Getter
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "Address_Id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "street_Name")
    private String streetName;

    @Column(name = "City")
    private String city;

    @Column(name = "Pincode")
    private String pincode;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    public Address(String streetName, String city, String pincode, Employee employee) {
        this.streetName = streetName;
        this.city = city;
        this.pincode = pincode;
        this.employee = employee;
    }

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    
}
