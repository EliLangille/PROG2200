package SingleResponsibility.Assignment.SchoolManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class ClassManager {
    private List<Class> classes = new ArrayList<>();

    public void scheduleClasses(Class classInfo) {
        classes.add(classInfo);
        System.out.println("Class scheduled: " + classInfo.getClassName());
    }
}