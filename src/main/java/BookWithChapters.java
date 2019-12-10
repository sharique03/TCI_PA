import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class BookWithChapters {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Chapter> getListOfChapter() {
        return listOfChapter;
    }

    public void setListOfChapter(List<Chapter> listOfChapter) {
        this.listOfChapter = listOfChapter;
    }

    String author;
    List<Chapter> listOfChapter;
    public BookWithChapters(String name, String author) {
        if ((name == null || name=="")||(author == null || author==""))
        {
            throw new IllegalArgumentException("Book Name/Author cannot be empty/null!");
        }
        else
        {
            this.name = name;
            this.author = author;
            listOfChapter=new ArrayList<>();
        }
    }

    public void addChapterToTheBook(String chapterName,String chapterNumber )
    {

        Chapter c=new Chapter(chapterName,chapterNumber);
        for (Chapter chapter:listOfChapter)
        {
            if(chapter.equals(c))
            {
                throw new IllegalArgumentException("Chapter is duplicate!");
            }
        }
        listOfChapter.add(c);
    }

    public SortedSet<Chapter> getSetOfSortedChapters()
    {
        SortedSet<Chapter> setOfClonedChapters=new TreeSet<>(listOfChapter);
        // List<Chapter> cloneListOfChapter=new ArrayList<>(listOfChapter);;

        //Collections.sort(listOfChapter);
//        Collections.sort(cloneListOfChapter);
//        return cloneListOfChapter;
        //System.out.println(setOfClonedChapters.toString());
        for(Chapter c:setOfClonedChapters)
        {
            System.out.println(c.chapterName+c.chapterNumber);

        }
        return setOfClonedChapters;
    }
}
