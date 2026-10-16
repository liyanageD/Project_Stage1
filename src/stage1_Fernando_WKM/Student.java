
package stage1_Fernando_WKM;

public class Student {

    private String studentId;
    private String name;
    private String email;
    private Course course;

    public Student(String studentId, String name,
                   String email, Course course) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);

        if (course != null) {
            System.out.println("Course: " + course.getCourseName());
        } else {
            System.out.println("Course: Not enrolled");
        }
    }
}
