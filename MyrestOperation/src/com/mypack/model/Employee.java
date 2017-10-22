package com.mypack.model;



import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

	
	
	@XmlElement(required = true)
	private int id;
	@XmlElement(required = true)
	private String name;
	@XmlElement(required = true)
	private String age;

	public Employee() {
		super();
		// Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	 
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
