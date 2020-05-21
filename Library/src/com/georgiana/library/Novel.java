package com.georgiana.library;

import java.util.List;

public class Novel extends Book {

    private String type;

    /**
     * Constructor creates a new Novel
     * @param name
     * @param pages
     * @param category
     * @param type
     */

    public Novel(String name, int pages, String category, String type) {
        super(name, pages, category);
        this.type = type;
    }

    public String toString(){
        return String.format("Name: %-10s, number of pages: %-4d, category: %-5s, type: %-5s",getName(),getPages(),
                getCategory(), type);
    }

}
