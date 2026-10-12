import java.util.*;

class Course{
    String courseCode;
    int capacity;
    HashSet<String> enrolledStudents;     
    ArrayList<String> prerequisites;      
    LinkedList<String> waitlist;         

    public Course(String courseCode, int capacity){
        this.courseCode = courseCode;
        this.capacity = capacity;
        this.enrolledStudents = new HashSet<>();
        this.prerequisites = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public void addPrerequisite(String prereqCode){
        prerequisites.add(prereqCode);
    }
}

public class CourseRegistrationSystem{
    private Map<String, Course> courses = new HashMap<>();

    public void addCourse(String courseCode, int capacity){
        courses.put(courseCode, new Course(courseCode, capacity));
    }

    public void registerStudent(String studentId, String courseCode, Set<String> completedCourses){
        Course course = courses.get(courseCode);
        if(course == null){
            System.out.println("Course " + courseCode + " not found.");
            return;
        }

        if(course.enrolledStudents.contains(studentId) || course.waitlist.contains(studentId)){
            System.out.println("Student " + studentId + " is already enrolled or waitlisted for " + courseCode);
            return;
        }

        for(String prereq : course.prerequisites){
            if (!completedCourses.contains(prereq)) {
                System.out.println("Registration failed: " + studentId + " has not completed prerequisite: " + prereq);
                return;
            }
        }

        if(course.enrolledStudents.size() < course.capacity){
            course.enrolledStudents.add(studentId);
            System.out.println("Successfully enrolled " + studentId + " in " + courseCode);
        } else{
            course.waitlist.addLast(studentId);
            System.out.println("Course full. " + studentId + " added to waitlist for " + courseCode);
        }
    }

    public void dropStudent(String studentId, String courseCode){
        Course course = courses.get(courseCode);
        if(course == null) return;

        if(course.enrolledStudents.remove(studentId)){
            System.out.println(studentId + " dropped from " + courseCode);

            if(!course.waitlist.isEmpty()){
                String nextStudent = course.waitlist.removeFirst();
                course.enrolledStudents.add(nextStudent);
                System.out.println("Promoted " + nextStudent + " from waitlist to enrolled in " + courseCode);
            }
        } 
        else{
            if(course.waitlist.remove(studentId)){
                System.out.println(studentId + " removed from waitlist for " + courseCode);
            } 
            else{
                System.out.println(studentId + " is not registered in " + courseCode);
            }
        }
    }

    public static void main(String[] args){
        CourseRegistrationSystem portal = new CourseRegistrationSystem();

        portal.addCourse("CS102", 2);
        portal.courses.get("CS102").addPrerequisite("CS101");

        Set<String> studentRecords = new HashSet<>(Arrays.asList("CS101"));

        portal.registerStudent("S1", "CS102", studentRecords);
        portal.registerStudent("S2", "CS102", studentRecords); 
        portal.registerStudent("S3", "CS102", studentRecords); 

        portal.dropStudent("S1", "CS102");
    }
}