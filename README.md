# Library Management System Documentation
# Overview
The Library Management System is a Java console application designed to manage books and members within a library context. The system allows for adding and deleting books and members, issuing and returning books, and maintains a record of which books are issued to which members.

# Classes and Their Functions
- LibraryManagementSystem
  - Main class that initializes the system and handles the user interface and input.
  - Provides a menu-driven interface for users to interact with the system, performing operations like adding or deleting books and members, issuing, and returning books.
- Book
  - Represents a book within the library.
  - Stores details about the book such as title, author, and availability status.
  - Availability status indicates whether the book is available for issuing.
- Member
  - Represents a library member.
  - Stores member details including name and ID.
  - Manages a list of books currently issued to the member.
  - Provides methods to issue and return books, updating the book's availability status accordingly.
# Core Functionalities
- Adding and Deleting Books
  - Users can add books to the library by specifying the book's title and author.
  - Books can be deleted from the library by title.
- Adding and Deleting Members
  - New members can be added to the library system by providing a name and ID.
  - Members can be removed from the system using their ID.
- Issuing and Returning Books
  - Books can be issued to members based on the member's ID and the book's title, assuming the book is available.
  - Members can return books, which updates the book's availability status.
- Handling Input and Output
  - The system interacts with the user through the console, using Scanner for input and System.out.println for output.
  - It provides a looped menu for continuous operation until the user decides to exit.