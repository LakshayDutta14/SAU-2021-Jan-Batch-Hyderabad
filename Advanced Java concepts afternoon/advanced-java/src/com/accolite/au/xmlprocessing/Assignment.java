package com.accolite.au.xmlprocessing;

import javax.xml.bind.annotation.XmlAccessorType;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "assignment")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Assignment implements Serializable {
	private static final long serialVersionUID = 1L;
//	@XmlElement
	String name;
//	@XmlElement
	String review;
//	@XmlElement
	int id;
	
	public Assignment() {
        super();
    }
 
    public Assignment(String name,String review,Integer id) {
        super();
        this.name = name;
        this.review = review;
        this.id=id;
    }
	public String getName() {
		return name;
	}
	@XmlElement(name="name")
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	@XmlElement(name="statusupdate")
	public void setReview(String review) {
		this.review = review;
	}
	public int getId() {
		return id;
	}
	@XmlElement(name="id")
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Assignment [name=" + name + ", review=" + review + ", id=" + id + "]";
	}
}