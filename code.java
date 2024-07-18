//Define the Book class (Encapsulation and File Handling)
import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String title;
    private String author;
    private Genre genre;
    private boolean isAvailable;

    public Book(String title, String author, Genre genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", genre=" + genre + ", isAvailable=" + isAvailable + "]";
    }
}
//Define the Genre enum
public enum Genre {
    FICTION, NONFICTION, MYSTERY, SCI_FI, BIOGRAPHY;
}


//Define the User class (Inheritance and Method Overloading)

public abstract class User {
    private String name;
    private String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Abstract method
    public abstract void displayUserInfo();
}

//Define the Student class (Inheritance and Polymorphism)

public class Student extends User {
    private String grade;

    public Student(String name, String id, String grade) {
        super(name, id);
        this.grade = grade;
    }

    // Getters and Setters
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Student [name=" + getName() + ", id=" + getId() + ", grade=" + grade + "]");
    }
}

//Define the Librarian class (Inheritance and Polymorphism)

public class Librarian extends User {
    private String employeeId;

    public Librarian(String name, String id, String employeeId) {
        super(name, id);
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Librarian [name=" + getName() + ", id=" + getId() + ", employeeId=" + employeeId + "]");
    }
}

// Define the LibraryManagement interface (Interface and Lambda)
import java.util.List;

public interface LibraryManagement {
    void addBook(Book book);
    void removeBook(Book book);
    List<Book> searchBooksByTitle(String title);
    List<Book> searchBooksByAuthor(String author);
    List<Book> searchBooksByGenre(Genre genre);
}

//Implement the LibraryManagement interface in the Library class
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements LibraryManagement {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> searchBooksByGenre(Genre genre) {
        return books.stream()
                .filter(book -> book.getGenre() == genre)
                .collect(Collectors.toList());
    }

    // File handling methods
    public void saveLibraryToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(books);
        }
    }

    public void loadLibraryFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            books = (List<Book>) ois.readObject();
        }
    }

    public void displayAllBooks() {
        books.forEach(System.out::println);
    }
}
// Define a custom exception (Exceptions)
public class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Define the main class
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some books
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", Genre.FICTION));
        library.addBook(new Book("1984", "George Orwell", Genre.SCI_FI));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", Genre.FICTION));

        // Save to file
        try {
            library.saveLibraryToFile("library.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Load from file
        try {
            library.loadLibraryFromFile("library.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Search books by title
        List<Book> booksByTitle = library.searchBooksByTitle("1984");
        booksByTitle.forEach(System.out::println);

        // Display all books
        library.displayAllBooks();
    }
}
