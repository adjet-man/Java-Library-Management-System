import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("Welcome to the Library Management System!");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. Add Member");
                System.out.println("4. Delete Member");
                System.out.println("5. Issue Book");
                System.out.println("6. Return Book");
                System.out.println("7. Exit");

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        library.addBook();
                        break;
                    case 2:
                        library.deleteBook();
                        break;
                    case 3:
                        library.addMember();
                        break;
                    case 4:
                        library.deleteMember();
                        break;
                    case 5:
                        library.issueBook();
                        break;
                    case 6:
                        library.returnBook();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }

    public void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = input.nextLine();

        System.out.print("Enter book author: ");
        String author = input.nextLine();

        books.add(new Book(title, author));
    }

    public void deleteBook() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book title: ");
        String title = input.nextLine();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                System.out.println("Book removed successfully!");
                return;
            }
        }

        System.out.println("Book not found!");
    }

    public void addMember() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter member name: ");
        String name = input.nextLine();

        System.out.print("Enter member ID: ");
        int id = input.nextInt();

        members.add(new Member(name, id));
    }

    public void deleteMember() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter member ID: ");
        int id = input.nextInt();

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId() == id) {
                members.remove(i);
                System.out.println("Member removed successfully!");
                return;
            }
        }

        System.out.println("Member not found!");
    }

    public void issueBook() {
        Scanner input = new Scanner(System.in);
        
        // Get member
        System.out.print("Enter member ID: ");
        int memberId = input.nextInt();
        
        Member member = null;
        
       for (int i=0;i<members.size();i++) { 
           if(members.get(i).getId()==memberId) { 
               member=members.get(i); 
               break; 
           } 
       }
       
       if(member==null) { 
           System.out.println("Member not found!"); 
           return; 
       }
       
       // Get book
       System.out.print("Enter book title: "); 
       String title=input.nextLine(); 

       Book book=null;
        
       for (int i=0;i<books.size();i++) { 
           if(books.get(i).getTitle().equals(title)) { 
               book=books.get(i); 
               break; 
           } 
       }
       
       if(book==null) { 
           System.out.println("Book not found!"); 
           return; 
       }
       
       // Issue book
       if(book.isAvailable()) { 
           member.issueBook(book); 
           System.out.println("Book issued successfully!"); 
       } else { 
           System.out.println("Book not available!"); 
       }
    }

    public void returnBook() {
        Scanner input = new Scanner(System.in);
        
        // Get member
        System.out.print("Enter member ID: ");
        int memberId = input.nextInt();
        
        Member member = null;
        
        for (int i=0;i<members.size();i++) { 
            if(members.get(i).getId()==memberId) { 
                member=members.get(i); break; } } 
        
        if(member==null) { System.out.println("Member not found!"); return; }
        
        // Get book
        System.out.print("Enter book title: "); String title=input.nextLine();
        
        Book book=null;
        
        for (int i=0;i<books.size();i++) {
            if(books.get(i).getTitle().equals(title)) {
                book=books.get(i);
                break;
            }
        }
        
        if(book==null) {
            System.out.println("Book not found!");
            return;
        }
        
        // Return book
        if(member.returnBook(book)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Member did not issue this book!");
        }
    }

}

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Member {
    private String name;
    private int id;
    private ArrayList<Book> issuedBooks;

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
        issuedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

   public void issueBook(Book book) { 
       book.setAvailable(false); 
       issuedBooks.add(book); 
   } 

   public boolean returnBook(Book book) { 
       if(issuedBooks.contains(book)) { 
           book.setAvailable(true); issuedBooks.remove(book); 
           return true; 
       } else { 
           return false; 
       } 
   } 

}