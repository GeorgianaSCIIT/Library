package com.georgiana.library;
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
}
