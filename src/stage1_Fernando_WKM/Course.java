
package stage1_Fernando_WKM;

public class Course {

    private String courseId;
    private String courseName;
    private String duration;

    public Course(String courseId, String courseName, String duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration);
    }
}
