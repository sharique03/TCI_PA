import org.junit.Test;
import org.junit.Assert;
import w3.Course;
import w3.CourseDateException;

import java.time.LocalDate;

public class SchoolTest {

    @Test
    public void addCourseEndDateAfterStartDate() throws CourseDateException {
        //arrange
        final LocalDate startDate = LocalDate.parse("2019-03-31");
        final LocalDate endDate = LocalDate.parse("2019-04-05");
        //act
        Course course=new Course("TCICourseName",startDate,endDate);
        //assert
        Assert.assertNotNull(course);
    }
    @Test(expected = CourseDateException.class)
    public void cannotAddCourseEndDateBeforeStartDate() throws CourseDateException {
        //arrange
        final LocalDate startDate = LocalDate.parse("2019-03-31");
        final LocalDate endDate = LocalDate.parse("2019-03-05");
        //act
        Course course=new Course("TCICourseName",startDate,endDate);
        //assert
        Assert.assertNotNull(course);
    }
}
