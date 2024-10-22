package SingleResponsibility.Assignment.SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void enrollStudent(Student student) {
        students.add(student);
        System.out.println("Student enrolled: " + student.getName());
    }
}
