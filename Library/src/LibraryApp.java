import com.georgiana.scannerlibrary.ScannerLibrary;

/**
 * Create a small application that mimics a library catalog.
 * It needs to be able to add books, delete books and list books.
 * Books are of two kinds: novels and art albums.
 * They both have names and number of pages.
 * Novels have type (like mystery, sf, etc.) while albums have paper quality.
 * Model these entities (book, novel, album) with different classes and inheritance.
 */

/**
 * Main class - hered the program starts
 */

public class LibraryApp {
    public static void main(String[] args) {
        ScannerLibrary scLibrary = new ScannerLibrary();
        scLibrary.showMenu();

    }
}
