package com.verizon.loading.frontcontroller.loadingcontroller.model;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
//Below annotation defines root element of XML file
@XmlRootElement
public class Bookstore {
 
 private String owner;
 private String location;
 
 private ArrayList<Book> booksList;
 public Bookstore() {
 
 }
 
public String getOwner() {
	return owner;
}

public void setOwner(String owner) {
	this.owner = owner;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public ArrayList<Book> getBooksList() {
	return booksList;
}

//XmLElementWrapper generates a wrapper element around XML representation
@XmlElementWrapper(name = "booksList")
//XmlElement sets the name of the entities in collection
@XmlElement(name = "book")
public void setBooksList(ArrayList<Book> booksList) {
	this.booksList = booksList;
}

@Override
public String toString() {
	return "BookStore [owner=" + owner + ", location=" + location + ", booksList=" + booksList + "]";
}


 
 
   
}
