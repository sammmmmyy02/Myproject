public class LibrarySystem {

    static class Book {
        String bookId;
        String title;
        String author;
        boolean isAvailable;

        // Constructor
        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public void displayBookInfo() {
            System.out.println("\t\tBook ID: " + bookId);
            System.out.println("\tTitle: " + title);
            System.out.println("\tAuthor: " + author);
            System.out.println("\tAvailable: " + (isAvailable ? "Yes" : "No"));
            System.out.println();
        }

        // Mark the book as borrowed
        public boolean borrowBook() {
            if (isAvailable) {
                isAvailable = false;
                return true;
            }
            return false;
        }

        // Mark the book as returned
        public void returnBook() {
            isAvailable = true;
        }
    }

    // Student
    static class Student {
        String studentId;
        String name;
        Book[] borrowedBooks = new Book[5];
        int bookCount = 0;

        public Student(String studentId, String name) {
            this.studentId = studentId;
            this.name = name;
        }

        // Borrow a book
        public void borrowBook(Book book) {
            if (bookCount < borrowedBooks.length && book.isAvailable) {
                if (book.borrowBook()) {
                    borrowedBooks[bookCount++] = book;
                    System.out.println(name + " borrowed \"" + book.title + "\"");
                }
            } else {
                System.out.println(name + " cannot borrow \"" + book.title + "\"(Limit reached or not available)");
            }
        }

        // Return a book
        public void returnBook(Book book) {
            for (int i = 0; i < bookCount; i++) {
                if (borrowedBooks[i] == book) {
                    book.returnBook();
                    System.out.println(name + " returned \"" + book.title + "\"");
                    for (int j = i; j < bookCount - 1; j++) {
                        borrowedBooks[j] = borrowedBooks[j + 1];
                    }
                    borrowedBooks[--bookCount] = null;
                    return;
                }
            }
            System.out.println("Book not found in " + name + "'s borrowed list.");
        }

        // View borrowed books
        public void viewBorrowedBooks() {
            System.out.println(name + "'s Borrowed Books:");
            if (bookCount == 0) {
                System.out.println("None");
            }
            for (int i = 0; i < bookCount; i++) {
                System.out.println(" | " + borrowedBooks[i].title);
            }
            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {

        // Create books
        Book book1 = new Book("1", "To Kill a Mockingbird", "George Orwell");
        Book book2 = new Book("2", "The Great Gatsby", " F. Scott Fitzgerald");
        Book book3 = new Book("3", "The Lord of the Rings", "J.R.R. Tolkien");
        Book book4 = new Book("4", "The Alchemist", "Paulo Coelho");
       
        
        // Display book info
        System.out.println("=============================================");
        book1.displayBookInfo();
         System.out.println("============================================");
        book2.displayBookInfo();
        System.out.println("=============================================");
        book3.displayBookInfo();
        System.out.println("=============================================");
        book4.displayBookInfo();

        // Create students
        Student student1 = new Student("1", "Mark");
        Student student2 = new Student("2", "Jessa");
        Student student3 = new Student("3", "Ivan");
        Student student4 = new Student("4", "Ford");

         System.out.println("=============================================");
        student1.borrowBook(book1);  
        student1.borrowBook(book2);  
        student1.viewBorrowedBooks(); 

         System.out.println("=============================================");
        student2.borrowBook(book1);
        student2.viewBorrowedBooks();

        System.out.println("==============================================");
        student3.borrowBook(book3);
        student3.viewBorrowedBooks();

        System.out.println("==============================================");
        student4.borrowBook(book4);
        student4.viewBorrowedBooks();
        System.out.println("==============================================");

        // Updated availability
        System.out.println("\tUpdated Book Availability:");
        System.out.println("---------------------------------------------");
        book1.displayBookInfo();
        System.out.println("---------------------------------------------");
        book2.displayBookInfo();
        System.out.println("---------------------------------------------");
        book3.displayBookInfo();
        System.out.println("---------------------------------------------");
        book4.displayBookInfo();
        System.out.println("---------------------------------------------");
    }
}


