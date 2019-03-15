import ARArrayList.ARArrayList;
public class Driver extends Book{
    public static void main(String[] args){
        int bookNo = 20;
        Book[] book = new Book[bookNo];
        nameBooks(book);
        menu(book);
        /*dupChecker(book); displayBooks(book);System.out.println();
        yearPubSort(book);System.out.println();
        pageSort(book);System.out.println();
        reviewRatingSort(book);subjectLookUp(book);bookLookUp(book);
        ARArrayList<Book> convertedToArrayList = convertArrayToArrayList(book);
        addBooktoList(convertedToArrayList);
        Book[] converted = convertArrayListToArray(convertedToArrayList);
        displayBooks(converted);*/
        }
}
