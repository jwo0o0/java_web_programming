package model;

import java.util.ArrayList;

public class ArrayTest implements DAO {
    private ArrayList<BookList> booklist;

    public ArrayTest() {
        System.out.println("creating book list array...");
        booklist = new ArrayList<BookList>();
        booklist.add(new BookList(1, "축구의 역사", "굿스포츠", 7000));
        booklist.add(new BookList(2, "축구 아는 여자", "나무수", 13000));
        booklist.add(new BookList(3, "축구의 이해", "대한미디어", 22000));
        booklist.add(new BookList(4, "골프 바이블", "대한미디어", 35000));
        booklist.add(new BookList(5, "피겨 교본", "굿스포츠", 8000));
        booklist.add(new BookList(6, "역도 단계별 기술", "굿스포츠", 6000));
        booklist.add(new BookList(7, "야구의 추억", "이상미디어", 20000));
        booklist.add(new BookList(8, "야구를 부탁해", "이상미디어", 13000));
        booklist.add(new BookList(9, "올림픽 이야기", "삼성당", 7500));
        booklist.add(new BookList(10, "Olympic Champions", "Pearson", 1300));
    }

    public void extract() {
        System.out.println("BOOK ID \tBOOK NAME \t\tPUBLISHER \tPRICE");

        for (BookList item : booklist) {
            System.out.println(
                    item.getBookId() + "\t\t" + item.getTitle() + "\t\t"
                            + item.getPublisher() + "\t" + item.getPrice()
            );
        }
    }
}
