package com.sdut.opreation;

public class Sale {
public String Id;
public String Name;
public String Gender;
public String Address;
public Sale(String id,String name,String gender,String address)
{
	this.Id = id;
	this.Name = name;
	this.Gender = gender;
	this.Address = address;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
@Override
public String toString() {
	return "Sale [Id=" + Id + ", Name=" + Name + ", Gender=" + Gender + ", Address=" + Address + "]";
}

}
