package com.sdut.opreation;

public class Book {
	public String Id;
	public String Name;
	public String Nature;
	public double Value;
	long Num;
	public Book(String id,String name,String nature,double value,long num)
	{
		this.Id = id;
		this.Name = name;
		this.Nature = nature;
		this.Value = value;
		this.Num = num;
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
	public String getNature() {
		return Nature;
	}
	public void setNature(String nature) {
		Nature = nature;
	}
	public double getValue() {
		return Value;
	}
	public void setValue(double value) {
		Value = value;
	}
	public long getNum() {
		return Num;
	}
	public void setNum(long num) {
		Num = num;
	}
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", Name=" + Name + ", Nature=" + Nature + ", Value=" + Value + ", Num=" + Num + "]";
	}

	
}
