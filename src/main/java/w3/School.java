package w3;

import java.time.LocalDate;
import java.util.List;

public class School {
    private String schoolName;
    private LocalDate opennningDate;
    private List<Course>courseList;

    /**
     *
     * @param schoolName
     * @param openningDate
     * @param courseList
     */
    public School(String schoolName, LocalDate openningDate, List<Course> courseList) {
        this.schoolName=schoolName;
        this.opennningDate=openningDate;
        this.courseList=courseList;
    }


    public LocalDate getOpenningDate() {
        return this.opennningDate;
    }

    public String getSchoolName() {
        return this.schoolName;
    }
}
