This  a simple Library Management System demonstrating various OOP principles and Java features. 

1- Book Class
    The Book class encapsulates the details of a book.
    Encapsulation: The fields of the Book class are private, and public getter and setter methods are provided to access and     
    modify these fields.
    File Handling: Implements Serializable to allow instances of Book to be serialized and deserialized.

2- User Class
    The User class is an abstract class representing a user in the library system.
    nheritance: The User class is the base class for other user types like Student and Librarian.
    Method Overloading: While this class does not directly demonstrate method overloading, it sets up a structure where         
    subclasses can implement the abstract method displayUserInfo.

3-Student Class
    The Student class inherits from User and represents a student in the library system.
    Polymorphism: Implements the displayUserInfo method defined in the User class.

4- Librarian Class
    The Librarian class inherits from User and represents a librarian in the library system.
    Polymorphism: Implements the displayUserInfo method defined in the User class.

5- LibraryManagement Interface
    The LibraryManagement interface defines methods for managing the library.
    Interface: Defines the contract for library management operations.

6- Library Class
  The Library class implements the LibraryManagement interface and manages the books in the library.
  File Handling: The saveLibraryToFile and loadLibraryFromFile methods handle the serialization and deserialization of the     library's book list.
  Lambda Expressions: Uses lambda expressions and streams for filtering books by title, author, and genre.
  
7- BookNotAvailableException Class
  A custom exception to handle cases where a book is not available.

8- Main Class
  The Main class demonstrates the functionality of the library management system.
  Main Method: Demonstrates the creation of a library, adding books, saving and loading the library to/from a file, 
  searching for books, and displaying all books.

--------
Key Concepts Demonstrated
1- Encapsulation: Private fields in classes with public getter and setter methods.
2- Inheritance: Student and Librarian classes inherit from the User class.
3- Polymorphism: The displayUserInfo method is implemented differently in Student and Librarian classes.
4- Abstraction: The User class is abstract, and the LibraryManagement interface defines methods for library operations.
5- Interfaces: The LibraryManagement interface is implemented by the Library class.
6- File Handling: Serialization and deserialization of the library's book list.
7- Enums: The Genre enum defines the genre of a book.
8- Exceptions: Custom exception BookNotAvailableException.







    
    
