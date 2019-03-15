import ARArrayList.ARArrayList;

import java.text.DecimalFormat;
import java.util.*;
//Author: Andrew Aguilar
//Date: 22 February 2019
public class Book<E> {
    public String title, subject;
    public int yearOfPub, pageNo;
    public double reviewRating;

    //    DecimalFormat df = new DecimalFormat("#.##");
    public Book() {
        this.title = "";
        String[] subs = {"Programming", "Data Structures", "Algorithms",
                "Operating Systems", "Gaming"};
        int rand = new Random().nextInt(5);//(int) (Math.random() * (5 - 1) + 1);
        this.subject = subs[rand];
        this.yearOfPub = (int) (Math.random() * (2019 - 1980) + 1980);
        this.pageNo = (int) (Math.random() * (1000 - 50) + 50);
        this.reviewRating = Math.random() * (10.0 - .1) + .1;
    }

    public Book(String t, String s, int yP, int pN, double rR) {
        this.title = t;
        this.subject = s;
        this.yearOfPub = yP;
        this.pageNo = pN;
        this.reviewRating = rR;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public int getYearOfPub() {
        return yearOfPub;
    }

    public int getPageNo() {
        return pageNo;
    }

    public double getReviewRating() {
        return (reviewRating);
    }

    public void setTitle(String t) {
        this.title = t;
    }
    public static void subjectLookUp(Book[] b){
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the subject you would like to look up: ");
            String subject = input.next();
            System.out.println("Displaying all books under the subject " + subject + ":");
            System.out.println("===================================================================================================" + "================================================");
            for (int i = 0; i < b.length; i++) {
                if (b[i].getSubject().equals(subject)) {
                    displayBook(b[i]);
                    System.out.println("===================================================================================================" + "================================================");
                }/*else{
                    System.out.println("No such book under subject "+subject+".");
                    break;
                }*/
            }
    }
    public static void bookLookUp(Book[] b){
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter the name of the book you are interested in: ");
        String bookName = input2.next();
        for(int i = 0; i < b.length; i++){
            if(b[i].getTitle().equals(bookName)){
                System.out.println("Details of book: ");
                displayBook(b[i]);
            }
        }
    }
    public static void displayBook(Book b){
        System.out.println("Book Name: " + b.getTitle() + " || " + " Book Subject: " + b.getSubject()
                + " || " + " Year of Publication: " + b.getYearOfPub() + " || " + " Number of pages: " + b.getPageNo() + " " + " || " +
                " Review Rating: " + b.getReviewRating());
    }
    public static void displayBooks(Book[] b) {
        System.out.println("===================================================================================================" + "================================================");
        for (int i = 0; i < b.length; i++) {
            System.out.println("Book Name: " + b[i].getTitle() + " || " + " Book Subject: " + b[i].getSubject()
                    + " || " + " Year of Publication: " + b[i].getYearOfPub() + " || " + " Number of pages: " + b[i].getPageNo() + " " + " || " +
                    " Review Rating: " + b[i].getReviewRating());
            System.out.println("===================================================================================================" + "================================================");
        }
    }
    public static void nameBooks(Book[] book){
        for(int i = 0; i < book.length; i++){
            book[i] = new Book();
            book[i].setTitle("Book"+(i+1));
        }
    }
    public void setYear() {
        int rand = (int) (Math.random() * (2019 - 1980) + 1980);
        this.yearOfPub = rand;
    }

    public void setSubject() {
        String[] subs = {"Programming", "Data Structures", "Algorithms",
                "Operating Systems", "Gaming"};
        int rand = new Random().nextInt(5);
        this.subject = subs[rand];

    }

    public static void resetSubjects(Book[] book) {
        for (int i = 0; i < book.length; i++) {
            book[i].setSubject();
        }
    }

    public static void resetYears(Book[] book) {
        for (int i = 0; i < book.length; i++) {
            book[i].setYear();
        }
    }
    public static void dupChecker(Book[] book){
        for(int i = 0; i < book.length; i++){
            while(subjectDup(book)) {
                resetSubjects(book);
            }
            while(yearDup(book)){
                resetYears(book);
            }
        }
    }

    public static Boolean subjectDup(Book[] book) {
        int programmingCount = 0;
        int dataStructCount = 0;
        int algorithmsCount = 0;
        int osCount = 0;
        int gamingCount = 0;
        for (int i = 0; i < book.length; i++) {
            if (book[i].getSubject().equals("Programming"))
                programmingCount++;
            if (book[i].getSubject().equals("Data Structures"))
                dataStructCount++;
            if (book[i].getSubject().equals("Algorithms"))
                algorithmsCount++;
            if (book[i].getSubject().equals("Operating Systems"))
                osCount++;
            if (book[i].getSubject().equals("Gaming"))
                gamingCount++;
        }
        if (programmingCount > 5 || dataStructCount > 5 || algorithmsCount > 5 || osCount > 5 || gamingCount > 5)
            return true;
        else
            return false;
    }

    public static Boolean yearDup(Book[] book) {
        for (int i = 0; i < book.length; i++) {
            for (int j = i + 1; j < book.length; j++) {
                if (j != i && book[j].getYearOfPub() == book[i].getYearOfPub())
                    return true;
            }
        }
        return false;
    }

    public static void pageSort(Book[] book) { /*Method inspired by https://www.cs.swarthmore.edu/~cfk/wg2iticse99/insortobs.html*/
        System.out.println("Books sorted according to page number: ");
        int insertSpot;
        Book insertBook;
        for (int i = 1; i < book.length; i++) {
            if (book[i].getPageNo() < book[i - 1].getPageNo()) {
                insertBook = book[i];
                insertSpot = i;
                do {
                    insertSpot--;
                    book[insertSpot + 1] = book[insertSpot];
                } while ((insertSpot > 0) && insertBook.getPageNo() < book[insertSpot - 1].getPageNo());
                book[insertSpot] = insertBook;
            }
        /*Book temp;
        int check = book[0].getPageNo();
        for(int i =1; i < book.length;i++){
            for(int j=i; j>0*//* && book[j-1].getPageNo()>book[j].getPageNo()*//*; j--){
                if(book[j].getPageNo()<book[j+1].getPageNo()){
                    temp = book[j];
                    book[j]= book[j-1];
                    book[j-1] = temp;
                }
            }*/
            /*int check = book[i].getPageNo();
            int k = i-1;
            while(k>=0 && book[k].getPageNo() > check){
                book[k+1] = book[k];
                k--;
            }*/
            //check = book[k+1].getPageNo();
        }
        displayBooks(book);
    }
    public static void yearPubSort(Book[] book) {
        System.out.println("Books sorted according to year: ");
        int insertSpot;
        Book insertBook;
        for (int i = 1; i < book.length; i++) {
            if (book[i].getYearOfPub() < book[i - 1].getYearOfPub()) {
                insertBook = book[i];
                insertSpot = i;
                do {
                    insertSpot--;
                    book[insertSpot + 1] = book[insertSpot];
                } while ((insertSpot > 0) && insertBook.getYearOfPub() < book[insertSpot - 1].getYearOfPub());
                book[insertSpot] = insertBook;
            }
        }
        displayBooks(book);
    }

    public static void reviewRatingSort(Book[] book) { /*Method inspired by https://www.cs.swarthmore.edu/~cfk/wg2iticse99/insortobs.html*/
        System.out.println("Books sorted according to review rating: ");
        int insertSpot;
        Book insertBook;
        for (int i = 1; i < book.length; i++) {
            if (book[i].getReviewRating() > book[i - 1].getReviewRating()) {
                insertBook = book[i];
                insertSpot = i;
                do {
                    insertSpot--;
                    book[insertSpot + 1] = book[insertSpot];
                } while ((insertSpot > 0) && insertBook.getReviewRating() > book[insertSpot - 1].getReviewRating());
                book[insertSpot] = insertBook;
            }
        }
        displayBooks(book);
    }
    public static ARArrayList<Book> convertArrayToArrayList(Book[] b){
        ARArrayList<Book> bookList = new ARArrayList<Book>();
        Book temp;
        for(int i=0; i < b.length; i++){
            //temp = b[i];
            bookList.add(b[i]);
        }
        return bookList;
    }
    public static Book[] convertArrayListToArray(ARArrayList<Book> b){
        Book[] newList = new Book[b.getSize()];
        for(int i =0; i < b.getSize(); i++){
            newList[i] = b.get(i);
        }
        return newList;
    }
    public static void addBooktoList(ARArrayList<Book> b){
        Scanner input3 = new Scanner(System.in);
        int yearPublished, pageNumber;
        String title, subject;
        double reviewRating;
        System.out.print("Please enter the books title: ");
        title = input3.nextLine();
        System.out.print("Please enter the books subject: ");
        subject = input3.nextLine();
        System.out.print("Please enter the year the book was published: ");
        yearPublished = input3.nextInt();
        System.out.print("Please enter the number of pages the book has: ");
        pageNumber = input3.nextInt();
        System.out.print("Please enter the books review rating: ");
        reviewRating = input3.nextDouble();
        b.add(new Book(title, subject, yearPublished, pageNumber, reviewRating));
    }
    public static void exit(){
        System.out.println("Closing program");
        System.exit(1);
    }
    public static void menu(Book[] b){
        dupChecker(b);
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("============== Library Options ==============");
            System.out.println("Choose an option : \n" + "1: Display Books.\n" + "2: Display Books sorted by year of publication.\n"
                    + "3: Display Books sorted by number of pages.\n" + "4: Display books sorted by review rating.\n" + "5: Look up books by subject.\n" +
                    "6: Look up book by name.\n" + "7: Add a book to the list.\n" + "8: Exit\n");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    displayBooks(b);
                    break;
                case 2:
                    yearPubSort(b);
                    break;
                case 3:
                    pageSort(b);
                    break;
                case 4:
                    reviewRatingSort(b);
                    break;
                case 5:
                    subjectLookUp(b);
                    break;
                case 6:
                    bookLookUp(b);
                    break;
                case 7:
                    ARArrayList<Book> convertedToArrayList = convertArrayToArrayList(b);
                    addBooktoList(convertedToArrayList);
                    Book[] convertedBack = convertArrayListToArray(convertedToArrayList);
                    b=convertedBack;
                    break;
                case 8:
                    exit();
                    break;
            }
        }
    }
}