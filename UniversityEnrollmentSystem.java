import java.util.*;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    String name;
    int capacity;
    int enrolled;
    String prerequisite;

    public Course(String name, int capacity, String prerequisite) {
        this.name = name;
        this.capacity = capacity;
        this.prerequisite = prerequisite;
        this.enrolled = 0;
    }

    public void enroll(String student, List<String> completedCourses)
            throws CourseFullException, PrerequisiteNotMetException {
        if (enrolled >= capacity) {
            throw new CourseFullException("Course is full.");
        }
        if (prerequisite != null && !completedCourses.contains(prerequisite)) {
            throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + name + ".");
        }

        enrolled++;
        System.out.println("Enrollment successful for " + student + " in " + name);
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> completedCourses = new ArrayList<>();
        completedCourses.add("OOP"); // Example of completed course

        Course advancedJava = new Course("Advanced Java", 2, "Core Java");

        try {
            System.out.println("Enroll in Course: " + advancedJava.name);
            System.out.println("Checking prerequisites...");
            advancedJava.enroll("Alice", completedCourses);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
