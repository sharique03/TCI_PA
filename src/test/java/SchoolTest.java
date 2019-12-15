import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDate;

public class SchoolTest {

    @Test
    public void addCourseEndDateAfterStartDate(){
        //arrange
        final LocalDate startDate = LocalDate.parse("2019-03-31");
        final LocalDate endDate = LocalDate.parse("2019-04-05");
        //act
        Course course=new Course("TCICourseName",startDate,endDate);
        //assert
        Assert.assertNotNull(course);
    }
}
