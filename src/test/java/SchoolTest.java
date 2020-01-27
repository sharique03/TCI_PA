import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import w3.Course;
import w3.CourseDateException;
import w3.School;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class) // needed for parametrized tests
public class SchoolTest {
    private static final String SCHOOL_NAME = "Fontys";
    private static final LocalDate OPENNING_DATE = LocalDate.parse("2019-03-31");

//    @Test
//    public void createSchoolWithSchoolNameSuccessfully() throws CourseDateException
//    {
//        //arrange
//        Course c1 = new Course("TCICourseName1", LocalDate.parse("2019-04-04"), LocalDate.parse("2019-05-31"));
//        Course  c2 = new Course("TCICourseName2", LocalDate.parse("2019-05-04"), LocalDate.parse("2019-07-31"));
//        List<Course> courseList=new ArrayList<Course>();
//        courseList.add(c1);
//        courseList.add(c2);
//        School s=new School("mySchool",LocalDate.parse("2019-03-31"),courseList);
//        //verify(s);
//        assertThat(s, instanceOf(School.class));
//    }

//    @Test(expected = CourseDateException.class)
//    public void ThrcreateSchoolWithSchoolNameSuccessfully() throws CourseDateException
//    {
//        //arrange
//        Course c1 = new Course("TCICourseName1", LocalDate.parse("2019-04-04"), LocalDate.parse("2019-05-31"));
//        Course  c2 = new Course("TCICourseName2", LocalDate.parse("2019-05-04"), LocalDate.parse("2019-07-31"));
//        List<Course> courseList=new ArrayList<Course>();
//        courseList.add(c1);
//        courseList.add(c2);
//        School s=new School("mySchool",LocalDate.parse("2019-03-31"),courseList);
//        //verify(s);
//        assertThat(s, instanceOf(School.class));
//    }

    @Test
    public void schoolNameAndOpenningDateShouldBeSetAtCreation() throws CourseDateException {
        //arrange
        Course course1 = new Course("TCICourseName1", LocalDate.parse("2019-04-04"), LocalDate.parse("2019-05-31"));
        Course course2 = new Course("TCICourseName2", LocalDate.parse("2019-05-04"), LocalDate.parse("2019-07-31"));
        List<Course> courseList=new ArrayList<Course>();
        courseList.add(course1);
        courseList.add(course2);
        //act
        School school=new School(SCHOOL_NAME,OPENNING_DATE,courseList);
        //assert
        assertEquals(SCHOOL_NAME, school.getSchoolName());
        assertEquals(OPENNING_DATE, school.getOpenningDate());
    }


    @Test
    public void addCourseEndDateAfterStartDate() throws CourseDateException {
        //arrange
        final LocalDate startDate = LocalDate.parse("2019-03-31");
        final LocalDate endDate = LocalDate.parse("2019-04-05");
        //act
        Course course = new Course("TCICourseName", startDate, endDate);
        //assert
        Assert.assertNotNull(course);
    }

    @Test(expected = CourseDateException.class)
    public void cannotAddCourseEndDateBeforeStartDate() throws CourseDateException {
        //arrange
        final LocalDate startDate = LocalDate.parse("2019-03-31");
        final LocalDate endDate = LocalDate.parse("2019-03-05");
        //act
        Course course = new Course("TCICourseName", startDate, endDate);
        //assert
        Assert.assertNotNull(course);
    }
}
