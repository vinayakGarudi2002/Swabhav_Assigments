package com.aurionpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.comparator.BookComparator;
import com.aurionpro.model.Book;

public class BookTest {

	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<Book>();
		
		Scanner scanner = new Scanner(System.in);
		
		createListOfBooks(books,scanner);
		
		
		
		System.out.println("List of books created: \n");
		displayListOfBooks(books);
		
		Collections.sort(books,new BookComparator.BookTitleComparator());
		
		System.out.println("\nAfter Sorting Base on title\n");
		displayListOfBooks(books);
		
		Collections.sort(books,new BookComparator.BookAuthorComparator());
		
		System.out.println("\nAfter Sorting Base on author\n");
		displayListOfBooks(books);
		
		Collections.sort(books,new BookComparator.BookPriceComparator());
		
		System.out.println("\nAfter Sorting Base on price\n");
		displayListOfBooks(books);
		
		Collections.sort(books,new BookComparator.BookPublicationYearComparator());
		
		System.out.println("\nAfter Sorting Base on publication year\n");
		displayListOfBooks(books);
		
		sortBooksAuthorTitlePrice(books);
		
		System.out.println("\nAfter Sorting Base on author, then by title, and finally by price\n");
		displayListOfBooks(books);
		
		sortBooksPublicationYearPriceAuthor(books);
		
		System.out.println("\nAfter Sorting Base on publication year, then by price, and finally by author\n");
		displayListOfBooks(books);
	}
	

	private static void sortBooksPublicationYearPriceAuthor(List<Book> books) {
		
		Collections.sort(books,new BookComparator.BookPublicationYearComparator().thenComparing(new BookComparator.BookPriceComparator().thenComparing(new BookComparator.BookAuthorComparator())));
		
	}
	

	private static void sortBooksAuthorTitlePrice(List<Book> books) {
		
		Collections.sort(books,new BookComparator.BookAuthorComparator().thenComparing(new BookComparator.BookTitleComparator().thenComparing(new BookComparator.BookPriceComparator())));
		
	}
	

	private static void displayListOfBooks(List<Book> books) {


		for(Book book : books) {
			System.out.println(book);
		}
		
	}

	private static void createListOfBooks(List<Book> books, Scanner scanner) {
		
		while(true) {
			
			books.add(createBook(scanner));
			
			System.out.println("Enter -1 to exit or 0 to continue: ");
			int status=scanner.nextInt();
			
			if(status==-1) {
				break;
			}
			
		}
		
	}

	private static Book createBook(Scanner scanner) {
		
		System.out.println("Enter Title of Book: ");
		String title=scanner.next();
		
		System.out.println("Enter Author of Book: ");
		String author = scanner.next();
		
		System.out.println("Enter Publication Year of Book in YYYY");
		int publicationYear=scanner.nextInt();
		
		System.out.println("Enter price of book");
		double price=scanner.nextInt();
		
		
		return new Book(author,title,price,publicationYear);
	}

}
