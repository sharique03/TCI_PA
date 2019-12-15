package w3;

import java.time.LocalDate;

public class Course {
    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    private final String courseName;
    private final LocalDate startDate, endDate;

    public Course(String courseName, LocalDate startDate, LocalDate endDate) throws CourseDateException {
        if(endDate.isAfter(startDate)) {
            this.courseName = courseName;
            this.startDate = startDate;
            this.endDate = endDate;
        }
        else throw new CourseDateException("End date should be greater than start date!");

    }
}
