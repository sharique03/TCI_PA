import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BookWithChaptersTest {


    @Test
    public void createsABookSuccessfully(){
        //arrange
        //act
        BookWithChapters myBook1=new BookWithChapters("TCI","Erik");
        //assert
        Assert.assertNotNull(myBook1);
    }
    @Test
    public void checkChapterCompareToMethod(){
        //arrange
        BookWithChapters myBook=new BookWithChapters("TCI","Erik");
        //act
        myBook.addChapterToTheBook("mychapter3","3.1");
        myBook.addChapterToTheBook("mychapter2","2.1");
        //assert
        assertEquals(-1,myBook.listOfChapter.get(1).compareTo(myBook.listOfChapter.get(0)));
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWhenBookNameIsNullOrEmpty() {
        //arrange
        //act
        BookWithChapters myBook1=new BookWithChapters(null,"Erik");
        BookWithChapters myBook2=new BookWithChapters("","Erik2");
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWhenBookAuthorIsNullOrEmpty() {
        //arrange
        //act
        BookWithChapters myBook1=new BookWithChapters(null,"Erik");
        BookWithChapters myBook2=new BookWithChapters("","Erik2");
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWhenBookNameAndAuthorAreNull() {
        //arrange
        //act
        BookWithChapters myBook1=new BookWithChapters(null,null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenWhenBookNameAndAuthorAreEmpty() {
        //arrange
        //act
        BookWithChapters myBook1=new BookWithChapters("","");
    }
    @Test
    public void addsAChapterToTheBookSuccessfully() {
        //arrange
        //act
        BookWithChapters myBook=new BookWithChapters("TCI","Erik");
        myBook.addChapterToTheBook("mychapter","1.1");
        //assert
        Assert.assertNotNull(myBook.getSetOfSortedChapters());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForIncorrectFormatOfChapterNumber() {
        //arrange
        BookWithChapters myBook=new BookWithChapters("TCI","Erik");
        //act
        myBook.addChapterToTheBook("mychapter","x");
    }
    @Test
    public void addsMultipleChaptersToTheBookSuccessfully() {
        //arrange
        BookWithChapters myBook=new BookWithChapters("TCI","Erik");
        //act
        myBook.addChapterToTheBook("mychapter","1.1");
        myBook.addChapterToTheBook("mychapter2","2.1");
        //assert
        assertEquals(2,myBook.listOfChapter.size());

    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSameChaptersAreAddedInABook() {
        //arrange
        //act
        BookWithChapters myBook=new BookWithChapters("TCI","Erik");
        myBook.addChapterToTheBook("mychapter","1.1");
        myBook.addChapterToTheBook("mychapter","1.1");
    }
    @Test
    public void checkIfChaptersAreSorted() {
        //arrange
        BookWithChapters myBook=new BookWithChapters("TCI","Erik");
        BookWithChapters myBook2=new BookWithChapters("TCI2","Erik2");
        //act
        myBook.addChapterToTheBook("mychapter3","3.1");
        myBook.addChapterToTheBook("mychapter1","1.1");
        myBook.addChapterToTheBook("mychapter2","2.1");

        myBook2.addChapterToTheBook("mychapter1","1.1");
        myBook2.addChapterToTheBook("mychapter2","2.1");
        myBook2.addChapterToTheBook("mychapter3","3.1");
        //assert
        Assert.assertEquals(myBook.getSetOfSortedChapters(),myBook2.getSetOfSortedChapters());
    }


}
