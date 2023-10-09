package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook, Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã sách :");
        this.bookId = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập Tên sách :");
        this.bookName = sc.nextLine();

        System.out.println("Nhập tiêu đề sách :");
        this.title = sc.nextLine();

        System.out.println("Nhập số trang sách :");
        this.numberOfPages = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập giá nhập sách :");
        this.importPrice = Float.parseFloat(sc.nextLine());

        System.out.println("Nhập giá bán sách :");
        this.exportPrice = Float.parseFloat(sc.nextLine());

        System.out.println("Nhập trạng thái sách :");
        this.bookStatus = Boolean.parseBoolean(sc.nextLine());

        interest = exportPrice - importPrice;
    }

    @Override
    public void displayData() {
        System.out.println("Mã sách : " + bookId + " | Tên sách :" + bookName + "| tiêu đề :" + title + "| Số trang sách : " +
                numberOfPages + "| Giá nhập sách :" + importPrice + " | giá bán sách :" + exportPrice +
                " | Lợi nhuận : " + interest + " | Trạng thái : " + (bookStatus ? " Còn Hàng " : " Hết Hàng "));
    }

    @Override
    public int compareTo(Book o) {
        if (this.interest > o.interest) {
            return -1;
        } else if (this.interest < o.interest) {
            return 1;
        } else {
            return 0;
        }
    }
}
