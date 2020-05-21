package com.georgiana.scannerlibrary;
import com.georgiana.library.Album;
import com.georgiana.library.Book;
import com.georgiana.library.Novel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Scanner Class
 * Here are all the methods which use scanner
 */

public class ScannerLibrary {
    List books = new ArrayList();
    Scanner sc = new Scanner(System.in);

    /**
     * Constructor is used to create new scanner
     */
    public ScannerLibrary(){

    }

    /**
     * method to display menu
     */
    public void showMenu(){
        int selection = 0;
        while(selection !=4) {
            System.out.println("Select operation:" +
                    "\n 1. Add book" +
                    "\n 2. Delete book" +
                    "\n 3. Show all books" +
                    "\n 4. Exit");
            selection = validateNumber();
            switch(selection){
                case 1:
                    menuToAddNewBook();
                    break;
                case 2:
                    removeBookFromList();
                    break;
                case 3:
                    displayAllBooks();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Error! Insert a number from the menu!");
            }

        }
    }

    /**
     * method to display menu for adding a book
     */
    private void menuToAddNewBook(){
        System.out.println("Insert the book name: ");
        String name = sc.next();
        System.out.println("Insert number of pages:");
        int pages = validateNumber();
        System.out.println("Insert the category: novel or album ");
        selectCategory(name, pages);
    }

    /**
     * method used to select and validate category
     * @param name
     * @param pages
     * @return
     */
    private String selectCategory(String name, int pages){
        String category = " ";
        boolean cError = true;
        do{
            category = sc.next();
            if(category.equalsIgnoreCase("novel")){
                addNovel(name, pages, category);
                cError = false;
            } else if(category.equalsIgnoreCase("album")){
                addAlbum(name, pages,category);
                cError = false;
            } else{
                System.out.println("Error insert novel or album!");
            }

        }while(cError);

        return category;
    }

    /**
     * Method used to validate and add new novel in the library
     * @param name
     * @param pages
     * @param category
     */
    private void addNovel(String name, int pages, String category) {
        boolean bError = true;
        do{
            System.out.println("Insert book type: mystery, sf, fantasy, western");
            String type = sc.next();
            if (type.equalsIgnoreCase("mystery") || type.equalsIgnoreCase("sf") ||
                    type.equalsIgnoreCase("fantasy") || type.equalsIgnoreCase("western")) {
                Book novel = new Novel(name, pages, category, type);
                System.out.println("Your book is in Library!\n" + novel);
                books.add(novel);
                bError = false;
            } else{
                System.out.println("Error! Insert a valid value!");
            }
        }while(bError);
        System.out.println();
    }

    /**
     * Method used to validate and add new album in the library
     * @param name
     * @param pages
     * @param category
     */

    private void addAlbum(String name, int pages, String category){
            boolean aError = true;
            do{
                System.out.println("Enter the paper quality: premium, premium plus, deluxe, standard ");
                String qualityPaper = sc.next();
                if(qualityPaper.equalsIgnoreCase("premium")
                    || qualityPaper.equalsIgnoreCase("premium plus")
                    || qualityPaper.equalsIgnoreCase("deluxe")
                    || qualityPaper.equalsIgnoreCase("standard")){
                    Book album = new Album(name, pages, category, qualityPaper);
                    System.out.println("Your album is in Library\n" + album);
                    books.add(album);
                    aError = false;
                }else {
                    System.out.println("Error! Insert a valid value!");
                }
            }while(aError);
            System.out.println();
    }


    /**
     * method to remove a book from the library
     */

    private void removeBookFromList() {
        System.out.println("Enter the name: ");
        String name = sc.next();
        System.out.println("Enter the category: ");
        String  category = sc.next();
        for (int i = 0; i < books.size(); i++) {
           Book book = (Book) books.get(i);
           if(name.equals(book.getName())&& category.equals(book.getCategory())){
               books.remove(book);
               System.out.println("Book has been deleted! ");
           } else {
               System.out.println("Insert a valid value!");
           }
       }
    }

    /**
     * display all books from the library
     */

    private void displayAllBooks(){
        System.out.println("Books in the library:");
        for(Object book: books){
            System.out.println(book);
        }
    }

    /**
     * method to validate numbers from the program
     * @return
     */

    private int validateNumber(){
        int value = 0;
        boolean nError = true;
        do{
            try{
                value = Integer.parseInt(sc.next());
                if(value <0){
                    System.out.println("Insert a positive number!");
                }else{
                    nError = false;
                }
            }catch (InputMismatchException | NumberFormatException ex){
                System.out.println("Error! Insert a number!");
            }

        }while(nError);

        return value;
    }

    /**
     * method to exit from the program
     */

    private void exit(){
        System.out.println("Exiting...");
        System.exit(1);
    }
}
