package ra.run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    private static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách [15 điểm]\n" +
                    "2. Hiển thị thông tin các sách [15 điểm]\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần [15 điểm]\n" +
                    "4. Xóa sách theo mã sách [10 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi trạng thái của sách theo mã sách [10 điểm]\n" +
                    "7. Thoát [05 điểm]");
            System.out.print("Chọn một chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBook();
                    break;
                case 3:
                    SortByDecreasingProfit();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBookName();
                    break;
                case 6:
                    changeBookStatus();
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
    }

    public static void addBook() {
        System.out.println("nhập số sách cần thêm :");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData();
            bookList.add(book);
        }
        System.out.println(" thêm sách thành công !");
    }

    public static void displayBook() {
        for (Book book : bookList) {
            book.displayData();
        }
    }

    public static void deleteBook() {
        System.out.println("Nhập mã sách cần xóa :");
        int bookId = Integer.parseInt(scanner.nextLine());
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                bookList.remove(book);
                System.out.println("xóa thành công");
                return;
            }
        }
        System.err.println("Không tìm thấy sách có mã " + bookId);
    }

    public static void searchBookName() {
        System.out.println("Nhập tên sách cần tìm :");
        String bookName = scanner.nextLine();
        boolean check = false;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                book.displayData();
                check = true;
            }
        }
        if (!check) {
            System.err.println("Không tim sách có tên " + bookName);
        }
    }

    public static void changeBookStatus() {
        System.out.println("Nhập mã sách cần thay đổi trạng thái :");
        int bookId = Integer.parseInt(scanner.nextLine());
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                book.setBookStatus(!book.isBookStatus());
                System.out.println("trạng thái của sách có mã " + bookId + "đã được thay đổi");
                return;
            }
        }
        System.err.println("không tìm thấy sách có mã " + bookId);
    }

    public static void SortByDecreasingProfit() {
        Collections.sort(bookList);
        System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần.");
    }
}
