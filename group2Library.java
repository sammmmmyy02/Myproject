import java.util.ArrayList;
import java.util.Scanner;

class Book {

    protected String id;
    protected String title;
    protected String author;
    protected String genre;
    protected boolean isBorrowed = false;

 Book(String id, String title, String author, String genre) {

    this.id = id;
    this.title = title;
    this.author = author;
    this.genre = genre;

    }

void showInfo() {

    String status = isBorrowed ? "Borrowed" : "Available";
    System.out.println(id + " - " + title + " by " + author + "-" +genre +" [" + status + "]");
    }

    }

class Student {
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();
        Student(String name) {
        this.name = name;
        }

void borrowBook(Book book) {

    if (!book.isBorrowed) {
    book.isBorrowed = true;
    borrowedBooks.add(book);
        System.out.println(name + " borrowed \"" + book.title + "\"");
        } else {
        System.out.println("Book is already borrowed.");
        }
}

void returnBook(Book book) {
    if (borrowedBooks.contains(book)) {
    book.isBorrowed = false;
    borrowedBooks.remove(book);
        System.out.println(name + " returned \"" + book.title + "\"");
        } else {
        System.out.println("Book not found in your list.");
        }
    }

void showMyBooks() {
    System.out.println(name + "'s Borrowed Books:");
        if (borrowedBooks.isEmpty()) {
        System.out.println("No borrowed books.");
        } else {
        for (Book b : borrowedBooks) {
        System.out.println("- " + b.title);
        }
    }
    }
    }


    public class group2Library {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("f001", "The Very Hungry Caterpillar", "Eric Carle", "Educational"));
        books.add(new Book("f002", "Where the Wild Things Are", "Maurice Sendak", "Fantasy"));
        books.add(new Book("f003", "Green Eggs and Ham", "Dr. Seuss", "Humor"));
        books.add(new Book("f004", "Goodnight Moon", "Margaret Wise Brown", "Bedtime"));
        books.add(new Book("f005", "The Cat in the Hat", "Dr. Seuss", "Comedy"));
        books.add(new Book("f006", "Oh, the Places You’ll Go!", "Dr. Seuss", "Inspirational"));
        books.add(new Book("f007", "The Giving Tree", "Shel Silverstein", "Emotional"));
        books.add(new Book("f008", "The Gruffalo", "Julia Donaldson", "Adventure"));
        books.add(new Book("f009", "Don’t Let the Pigeon Drive the Bus!", "Mo Willems",
        "Comedy"));
        books.add(new Book("f010", "Curious George", "H.A. Rey", "Exploration"));

    ArrayList<Student> students = new ArrayList<>();
    Student student = null;

while (true) {
    if (student == null) {
    System.out.print("Enter your name: ");
    String studentName = scan.nextLine();
    Student foundStudent = null;
    for (Student s : students) {
    if (s.name.equals(studentName)) {
    foundStudent = s;
    break;
    }
}

if (foundStudent == null) {
    student = new Student(studentName);
    students.add(student);
    }
}
System.out.println("\n\n\t\t\t=== MA`AM LULU'S LIBRARY ===");
System.out.println("\n\t\t1. View Books");
System.out.println("\t\t2. Borrow a Book");
System.out.println("\t\t3. Return a Book");
System.out.println("\t\t4. My Borrowed Books");
System.out.println("\t\t5. Exit / Switch User");
System.out.println("");
System.out.print("\t\tChoose option: ");

int choice = scan.nextInt();
scan.nextLine();
switch (choice) {
case 1: {
    for (Book booklist : books) {
    booklist.showInfo();
}
break;
}

case 2: {
    System.out.print("Enter Book ID to borrow: ");
    String id = scan.nextLine();
    Book found = null;

    for (Book booklist : books) {
    if (booklist.id.equals(id)) {
    found = booklist;
    break;
    }
}
    if (found != null) {
    student.borrowBook(found);
    } else {
    System.out.println("Book not found.");
    }
    break; 
}

case 3: {
    System.out.print("Enter Book ID to return: ");
    String id = scan.nextLine();
    Book found = null;

    for (Book booklist : books) {
    if (booklist.id.equals(id)) {
    found = booklist;
    break;
    }
}
    if (found != null) {
    student.returnBook(found);
    } else {
    System.out.println("Book not found.");
    }
     break;
    }

case 4: {
    student.showMyBooks();
    break;
}

case 5: {
    System.out.println("Thank you, " + student.name + "!");
    student = null;
    break;
    }
default:
    System.out.println("Invalid option.");
}
}
}
}