package com.aurionpro.comparator;

import java.util.Comparator;

import com.aurionpro.model.Book;

public class BookComparator {
	
	public static class BookTitleComparator implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			
			return book1.getTitle().compareTo(book2.getTitle());
		}
		
	}
	
	
	public static class BookAuthorComparator implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			
			return book1.getAuthor().compareTo(book2.getAuthor());
		}
		
	}
	
	
	public static class BookPriceComparator implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			
			return (int) (book1.getPrice() - book2.getPrice());
		}
		
	}
	
	public static class BookPublicationYearComparator implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			
			return book1.getPublicationYear()-book2.getPublicationYear();
		}
		
	}

}
