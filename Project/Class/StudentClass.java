package Class;

public class StudentClass extends User {
    private String Sid;
    Courses[] courses = new Courses[10];

    public StudentClass() {
    }

    public StudentClass(String name, String password, String sid) {
        super(name, password);
        Sid = sid;

    }

    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public void addCourse(Courses course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                break;
            }
        }
    }

    public void addDelete(Courses course) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCName() == course.getCName()) {
                courses[i] = null;
                break;
            }
        }
    }

    public Courses[] gCourses() {
        return courses;
    }

    public void sCourses(Courses[] courses) {
        this.courses = courses;
    }

}
