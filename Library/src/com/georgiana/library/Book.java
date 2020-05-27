package com.georgiana.library;
import java.util.List;
import java.util.Objects;

/**
 * The parent class Book
 */

public class Book {
    private String name;
    private int pages;
    private String category;

    /**
     * Constructor creates a new Book
     * @param name
     * @param pages
     * @param category
     */

    public Book(String name, int pages, String category){
        this.name = name;
        this.pages = pages;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    public String getCategory() {
        return category;
    }

    public String toString(){
        return String.format("Name: %-4s, number of pages: %-4d, category: %-4s",name,pages, category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(name, book.name) &&
                Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pages, category);
    }

    /**
     * Method to add a book in the library
     * We call this method in the ScannerLibrary class
     * @param name
     * @param pages
     * @param category
     * @param value
     * @param books
     */

    public static void addBook(String name, int pages, String category, String value, List books){
        Book book = new Novel (name, pages, category, value);
        books.add(book);
        System.out.println("Your book is in Library!\n" + book);

    }

    /**
     * Method to delete book from the library
     * the method is used in the ScannerLibrary Class
     * @param name
     * @param category
     * @param books
     */
    public static void deleteBook(String name, String category, List books){
        for (int i = 0; i < books.size(); i++) {
            Book book = (Book) books.get(i);
            if (name.equals(book.getName()) && category.equals(book.getCategory())) {
                books.remove(book);
                System.out.println("Book has been deleted! ");
                break;
            } else {
                System.out.println("Insert a valid value!");
            }
        }

    }

    /**
     * display all books from the library
     * the method is used in the ScannerLibrary class
     */

    public static void displayAllBooks(List books){
        if(books.isEmpty()){
            System.out.println("The library is empty");
        }else {
            System.out.println("Books in the library:");
            for (Object book : books) {
                System.out.println(book);
            }
        }
        System.out.println();
    }

}
