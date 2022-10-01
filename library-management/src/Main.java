import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String name;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
    } 

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

}

class Member {
    private int id;
    private String name;
    private List<Book> books;
    Member(int id, String name) {
        this.id = id;
        this.name = name;
        books = new ArrayList<>();
    } 
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void receiveBook(Book book) {
        books.add(book);
    }
    public void giveBook(Book book) {
        books.remove(book);
    }
    public List<Book> getBooks() {
        return books;
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;
    Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public List<Book> getBooks() {
        return books;
    }
    public void addMember(Member member) {
        members.add(member);
    }
    public List<Member> getMembers() {
        return members;
    }
    private int getMemberIndex(Member member) {
        return this.members.indexOf(member);
    }
    private Member getMemberById(int id) {
        for (Member member: this.members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }
    private Book getBookById(int id, List<Book> books) {
        for (Book book: books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    public void lendBook(int bookId, int memberId) {
        Book book = getBookById(bookId, this.books);
        this.books.remove(book);

        Member member = getMemberById(memberId);
        member.receiveBook(book);
    }
    public void returnBook(int bookId, int memberId) {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId, member.getBooks());

        member.giveBook(book);
        this.books.add(book);
    }
}

public class Main {

    static Library library = new Library();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initLibraryData();

        String exit = "y";
        while (exit.toLowerCase().equals("y")) {
            showMenu();
            System.out.println("Enter your option: ");
            int selectedMenu = scanner.nextInt();
            switch(selectedMenu) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    showMembers();
                    break;
                case 5:
                    addMember(scanner);
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
            }

            System.out.println("Would you like to continue? (Y/N)");
            exit = scanner.next();
        }

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("================WELCOME================");
        System.out.println("1: show books");
        System.out.println("2: borrow books");
        System.out.println("3: return books");
        System.out.println("4: show member");
        System.out.println("5: add member");
    }

    public static void initLibraryData() {
        Book b1 = new Book(1, "book1");
        Book b2 = new Book(2, "book2");
        Book b3 = new Book(3, "book3");
        Member m1 = new Member(1, "member1");
        Member m2 = new Member(2, "member2");
        Member m3 = new Member(3, "member3");
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addMember(m1);
        library.addMember(m2);
        library.addMember(m3);
    }

    public static void showBooks() {
        for (Book book : library.getBooks()) {
            System.out.println(book.getId() + ": " + book.getName());
        }
    }
    public static void showMembers() {
        for (Member member: library.getMembers()) {
            System.out.println(member.getId() + ": " + member.getName());
        }
    }
    public static void addMember(Scanner scanner) {
        System.out.print("enter member id: ");
        int id = scanner.nextInt();

        System.out.print("enter member name: ");
        String name = scanner.next();
        Member new_m = new Member(id, name);
        library.addMember(new_m);
    }
    public static void borrowBook(Scanner scanner) {
        System.out.print("enter book id: ");
        int id = scanner.nextInt();

        System.out.print("enter member id: ");
        int m_id = scanner.nextInt();

        library.lendBook(id, m_id);
    }
    public static void returnBook(Scanner scanner) {
        System.out.print("enter book id: ");
        int id = scanner.nextInt();

        System.out.print("enter member id: ");
        int m_id = scanner.nextInt();

        library.returnBook(id, m_id);
    }
    
}
