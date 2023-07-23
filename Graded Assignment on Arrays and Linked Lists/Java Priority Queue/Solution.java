import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Create the Student and Priorities classes here.
 */
 class Student {
     
    // members 
    String  name;
    int     id;
    double  cgpa;
 
    // constructor 
    public Student(int id, String name, double cgpa) {
        this.name   = name;
        this.id     = id;
        this.cgpa   = cgpa;
    }
     
    // get student name 
    public String getName() {
        return this.name;
    }
     
    // get student ID
    public int getID() {
        return this.id;
    }
    
    // get student cgpa
    public double getCGPA() {
        return this.cgpa;
    }
     
    // student to string 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" " + this.cgpa);
        sb.append(" " + this.id);
        return sb.toString();
    }
}

/*
 * Comparator for the priority queue
 */
class StudentComparator implements Comparator<Student> { 
    public int compare(Student s1, Student s2) { 
     
        // compare on cgpa 
        int cgpaDiff = Double.compare(s2.getCGPA(), s1.getCGPA());
        if (cgpaDiff != 0)
            return cgpaDiff;
         
        //  compare on name 
        int nameDiff = s1.getName().compareTo(s2.getName());
        if (nameDiff != 0)
            return nameDiff;
         
        //  compare on ID 
        return Integer.compare(s1.getID(), s2.getID());
    } 
} 

class Priorities {
     
    // constructor
    public Priorities() {
    }
    public List<Student> getStudents(List<String> events) {
 
        // instantiate array list of students to return to caller
        List <Student> students   = new ArrayList<Student>();
 
        // instantiate a priority queue to keep students sorted ****
        PriorityQueue<Student> pq     = new PriorityQueue<Student>(events.size(), new StudentComparator());
         
        // traverse the list of events
        for (String e : events) {
                         
            // process ENTER
            if (e.startsWith("ENTER", 0)) {
                 
                // split the event into fields
                String[] fields = e.split(" ");
                 
                // instantiate this student
                Student student = new Student(Integer.parseInt(fields[3]), fields[1], Double.parseDouble(fields[2]));
 
                // add student to the priority queue  
                pq.add(student);
            } 
             
            // process SERVED (highest priority)
            else {
                 
//              // retrieve but NOT remove head of the queue 
//              Student student = pq.peek();
//              System.out.println(student.toString());
                 
                // retrieve and remove the head of the queue 
                pq.poll();
            }   
        }
         
        // get the number of remaining students in the priority queue 
        int n = pq.size();
         
        // build list of remaining students 
        for (int i = 0; i < n; i++) {
             
            // remove next student from the priority queue 
            Student student = pq.remove();
             
            // add the student to the list 
            students.add(student);
        }
         
        // return list of remaining students
        return students;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
