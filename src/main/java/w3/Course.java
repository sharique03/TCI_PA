package w3;

import java.time.LocalDate;

public class Course {
    private final String courseName;
    private final LocalDate startDate, endDate;

    public Course(String courseName, LocalDate startDate, LocalDate endDate) throws CourseDateException {

            this.courseName = courseName;
            this.startDate=startDate;
            this.endDate=endDate;

    }
}
