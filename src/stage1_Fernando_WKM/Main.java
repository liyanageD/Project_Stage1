
package stage1_Fernando_WKM;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=== STUDENT COURSE MANAGEMENT SYSTEM ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    studentMenu();
                    break;

                case 2:
                    courseMenu();
                    break;

                case 3:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        input.close();
    }

    // STUDENT MENU

    public static void studentMenu() {

        int choice;

        do {
            System.out.println("\n=== STUDENT MENU ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    // CREATE STUDENT

    public static void addStudent() {

        System.out.println("\n--- Add Student ---");

        System.out.print("Enter student ID: ");
        String id = input.nextLine();

        if (id.trim().isEmpty()) {
            System.out.println("Student ID cannot be blank.");
            return;
        }

        if (findStudent(id) != null) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student email: ");
        String email = input.nextLine();

        if (name.trim().isEmpty() || email.trim().isEmpty()) {
            System.out.println("Student name and email cannot be blank.");
            return;
        }

        Course course = selectCourse();

        Student student = new Student(id, name, email, course);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    // READ ALL STUDENTS

    public static void viewStudents() {

        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                student.displayDetails();
                System.out.println("--------------------");
            }
        }
    }

    // SEARCH STUDENT

    public static void searchStudent() {

        System.out.print("Enter student ID: ");
        String id = input.nextLine();

        Student student = findStudent(id);

        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("Student not found.");
        }
    }

    // UPDATE STUDENT

    public static void updateStudent() {

        System.out.print("Enter student ID to update: ");
        String id = input.nextLine();

        Student student = findStudent(id);

        if (student != null) {

            System.out.print("Enter new name: ");
            String name = input.nextLine();

            System.out.print("Enter new email: ");
            String email = input.nextLine();

            if (!name.trim().isEmpty()) {
                student.setName(name);
            }

            if (!email.trim().isEmpty()) {
                student.setEmail(email);
            }

            System.out.println("Change the course? (y/n): ");
            String answer = input.nextLine();

            if (answer.equalsIgnoreCase("y")) {
                Course course = selectCourse();
                student.setCourse(course);
            }

            System.out.println("Student updated successfully.");

        } else {
            System.out.println("Student not found.");
        }
    }

    // DELETE STUDENT

    public static void deleteStudent() {

        System.out.print("Enter student ID to delete: ");
        String id = input.nextLine();

        Student student = findStudent(id);

        if (student != null) {

            students.remove(student);
            System.out.println("Student deleted successfully.");

        } else {
            System.out.println("Student not found.");
        }
    }

    // FIND STUDENT BY ID

    public static Student findStudent(String id) {

        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    // COURSE MENU

    public static void courseMenu() {

        int choice;

        do {
            System.out.println("\n=== COURSE MENU ===");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addCourse();
                    break;

                case 2:
                    viewCourses();
                    break;

                case 3:
                    searchCourse();
                    break;

                case 4:
                    updateCourse();
                    break;

                case 5:
                    deleteCourse();
                    break;

                case 6:
                    System.out.println("Returning to main menu.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    // CREATE COURSE

    public static void addCourse() {

        System.out.println("\n--- Add Course ---");

        System.out.print("Enter course ID: ");
        String id = input.nextLine();

        if (id.trim().isEmpty()) {
            System.out.println("Course ID cannot be blank.");
            return;
        }

        if (findCourse(id) != null) {
            System.out.println("Course ID already exists.");
            return;
        }

        System.out.print("Enter course name: ");
        String name = input.nextLine();

        System.out.print("Enter course duration: ");
        String duration = input.nextLine();

        if (name.trim().isEmpty() || duration.trim().isEmpty()) {
            System.out.println("Course name and duration cannot be blank.");
            return;
        }

        Course course = new Course(id, name, duration);
        courses.add(course);

        System.out.println("Course added successfully.");
    }

    // READ ALL COURSES

    public static void viewCourses() {

        System.out.println("\n--- All Courses ---");

        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            for (Course course : courses) {
                course.displayDetails();
                System.out.println("--------------------");
            }
        }
    }

    // SEARCH COURSE

    public static void searchCourse() {

        System.out.print("Enter course ID: ");
        String id = input.nextLine();

        Course course = findCourse(id);

        if (course != null) {
            course.displayDetails();
        } else {
            System.out.println("Course not found.");
        }
    }

    // UPDATE COURSE

    public static void updateCourse() {

        System.out.print("Enter course ID to update: ");
        String id = input.nextLine();

        Course course = findCourse(id);

        if (course != null) {

            System.out.print("Enter new course name: ");
            String name = input.nextLine();

            System.out.print("Enter new course duration: ");
            String duration = input.nextLine();

            if (!name.trim().isEmpty()) {
                course.setCourseName(name);
            }

            if (!duration.trim().isEmpty()) {
                course.setDuration(duration);
            }

            System.out.println("Course updated successfully.");

        } else {
            System.out.println("Course not found.");
        }
    }

    // DELETE COURSE

    public static void deleteCourse() {

        System.out.print("Enter course ID to delete: ");
        String id = input.nextLine();

        Course course = findCourse(id);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        boolean enrolled = false;

        for (Student student : students) {
            if (student.getCourse() != null
                    && student.getCourse().getCourseId()
                            .equalsIgnoreCase(id)) {
                enrolled = true;
            }
        }

        if (enrolled) {
            System.out.println(
                "Cannot delete this course. Students are enrolled in it."
            );
        } else {
            courses.remove(course);
            System.out.println("Course deleted successfully.");
        }
    }

    // FIND COURSE BY ID

    public static Course findCourse(String id) {

        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(id)) {
                return course;
            }
        }

        return null;
    }

    // SELECT COURSE FOR A STUDENT

    public static Course selectCourse() {

        if (courses.isEmpty()) {
            System.out.println("No courses available. Student will not be enrolled.");
            return null;
        }

        System.out.println("\nAvailable Courses:");

        for (Course course : courses) {
            System.out.println(
                course.getCourseId() + " - " + course.getCourseName()
            );
        }

        System.out.println("Enter 0 if the student has no course.");

        System.out.print("Enter course ID: ");
        String id = input.nextLine();

        if (id.trim().isEmpty() || id.equals("0")) {
            return null;
        }

        Course course = findCourse(id);

        if (course == null) {
            System.out.println("Course not found. Student will not be enrolled.");
        }

        return course;
    }
}
