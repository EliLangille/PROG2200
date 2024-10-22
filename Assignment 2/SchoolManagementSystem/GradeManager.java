package SingleResponsibility.Assignment.SchoolManagementSystem;

public class GradeManager {
    public void recordGrades(Student student, Grade grade) {
        // Simulate recording a grade for a student
        System.out.println("Grade recorded for " + student.getName() + ": " + grade.getGrade());
    }
}