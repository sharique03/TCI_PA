package w3;

import java.time.LocalDate;
import java.util.List;

public class School {

    public School(String schoolName, LocalDate openningDate, List<Course> courseList) {

    }

    public LocalDate getOpenningDate() {
        return LocalDate.parse("2019-03-31");
    }

    public String getSchoolName() {
        return "Fontys";
    }
}
