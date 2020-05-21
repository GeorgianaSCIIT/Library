package com.georgiana.library;

public class Album extends Book {
    private String paperQuality;

    /**
     * Constructor - creates a new Album
     * @param name
     * @param pages
     * @param category
     * @param paperQuality
     */

    public Album(String name, int pages, String category, String paperQuality) {
        super(name, pages, category);
        this.paperQuality = paperQuality;
    }

    public String toString(){
        return String.format("Name: %-10s, number of pages: %-4d, category: %-5s, type: %35s",getName(),getPages(),
                getCategory(), paperQuality);
    }
}
