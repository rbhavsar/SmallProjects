package HashCodeEquals;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exec {

  public static void main(String[] args) {
    Student s1 = new Student("H1");
    Student s2 = new Student("H1");

    System.out.println(s1.equals(s2));

    Map<Student,ReportCard> studentReportCardMap = new HashMap<Student,ReportCard>();

    studentReportCardMap.put(s1,new ReportCard()); //While adding in map , it goes to hashcode everytime
    studentReportCardMap.put(s2,new ReportCard()); //While adding second value in map , it goes to equals method of Student class

    System.out.println(studentReportCardMap.size()); //After adding equals and hashcode method in Student class this will show map size = 1 , before that it was 2

    Set<Student> studentSet = new HashSet<Student>();

    for(int i=0;i<studentSet.size();i++){
      studentSet.add(new Student("H"+1));
    }

    System.out.println(studentSet.size());

    long startTime = System.nanoTime();
    System.out.println(studentSet.contains(new Student("H4")));
    System.out.println("Elapse Time: "+(System.nanoTime()-startTime));//Comment out hashcode method in Student - Elapse time will be more

  }
}
