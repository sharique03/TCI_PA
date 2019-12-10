
public class Chapter implements Comparable<Chapter> {
    String chapterName,chapterNumber;

    public Chapter(String chapterName, String chapterNumber) {
        if (chapterName == null || !chapterNumber.matches("^\\d+(\\.\\d+)?$"))
        {
            throw new IllegalArgumentException("Chapter Name cannot be null!");
        }
        else
        {
            this.chapterName = chapterName;
            this.chapterNumber = chapterNumber;
        }
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if(other == null || (this.getClass() != other.getClass())){
            return false;
        }
        Chapter chapter = (Chapter) other;
        return (this.chapterName.equals(chapter.chapterName)) && (this.chapterNumber != null && chapterNumber.equals(chapter.chapterNumber));
    }

    @Override
    public int hashCode(){
        int result = 0;
        result = 37*result + (chapterName !=null ? chapterName.hashCode() : 0);
        result = 37*result + (chapterNumber  !=null ? chapterNumber.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Chapter chapter) {
        return this.chapterNumber.compareTo(chapter.chapterNumber);
    }
}
