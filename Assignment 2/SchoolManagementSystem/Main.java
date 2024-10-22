package SingleResponsibility.Assignment.SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {

        /*
        In this code, the SchoolManager class handles multiple responsibilities
        like enrolling students, scheduling classes, recording grades, and
        managing events. Students should refactor this class according to the
        Single Responsibility Principle, creating separate classes for each
        distinct responsibility.
         */

        StudentManager studentManager = new StudentManager();
        ClassManager classManager = new ClassManager();
        GradeManager gradeManager = new GradeManager();
        EventManager eventManager = new EventManager();

        Student student1 = new Student("Alice Johnson");
        studentManager.enrollStudent(student1);

        Class class1 = new Class("Biology 101");
        classManager.scheduleClasses(class1);

        Grade grade1 = new Grade("A");
        gradeManager.recordGrades(student1, grade1);

        Event event1 = new Event("Science Fair");
        eventManager.handleSchoolEvents(event1);
    }
}
