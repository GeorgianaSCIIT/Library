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
                    Book.displayAllBooks(books);
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
                validateNovel(name, pages, category);
                cError = false;
            } else if(category.equalsIgnoreCase("album")){
                validateAlbum(name, pages,category);
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
    private void validateNovel(String name, int pages, String category) {
        boolean bError = true;
        do{
            System.out.println("Insert book type: mystery, sf, fantasy, western");
            String type = sc.next();
            if (type.equalsIgnoreCase("mystery") || type.equalsIgnoreCase("sf") ||
                    type.equalsIgnoreCase("fantasy") || type.equalsIgnoreCase("western")) {
                //add the novel in the list
                //the method is called from Book class
                Book.addBook(name, pages, category,type, books);
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

    private void validateAlbum(String name, int pages, String category){
            boolean aError = true;
            do{
                System.out.println("Enter the paper quality: premium, deluxe, standard ");
                String qualityPaper = sc.next();
                if(qualityPaper.equalsIgnoreCase("premium")
                    || qualityPaper.equalsIgnoreCase("deluxe")
                    || qualityPaper.equalsIgnoreCase("standard")){
                    //add the album in the list
                    //the method is called from Book class
                    Book.addBook(name, pages, category, qualityPaper, books);
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
        //we call the method from the Book Class
        Book.deleteBook(name, category, books);
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
