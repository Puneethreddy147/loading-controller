package com.verizon.loading.frontcontroller.loadingcontroller.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "com.verizon.vho.loading.model.BookStore")
public class Book {

	private String name;
	private String publisher;
	

	public Book() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", publisher=" + publisher + "]";
	}

	


}