package com.aurionpro.model;

public class Book {
	
	private String author;
	private String title;
	private double price;
	private int publicationYear;
	public Book(String author, String title, double price, int publicationYear) {
		super();
		this.author = author;
		this.title = title;
		this.price = price;
		this.publicationYear = publicationYear;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", price=" + price + ", publicationYear="
				+ publicationYear + "]";
	}
	
	
	
	

}
