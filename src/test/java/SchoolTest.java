import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SchoolTest {

    @Test
    public void addCourseEndDateAfterStartDate()
    {
        final LocalDate startDate = LocalDate.parse("2019-03-31");
        final LocalDate endDate = LocalDate.parse("2019-04-05");
        Course course=new Course("TCICourseName",startDate,endDate);

    }
}
