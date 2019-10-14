package Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import HashCodeEquals.Student;

public class App {

  public static void main(String[] args) {

    System.out.println("Hello World !!");

    Student[] students = new Student[2];
    students[0] = new Student("1");
    students[1] = new Student("2");
    students[2] = new Student("3");


    String testStr = "\"Testing\"";

    stripExampleQuotes(testStr);

    List<String> collect = Stream.of("How", "Are", "Welcome youtube", "Hello")
        .filter(text -> text.startsWith("H"))
        .map(text -> text.substring(2))
        .distinct()
        .sorted()
        .collect(Collectors.toList());

    for (int i = 0; i < 10; i++) {
      System.out.println("value: " + i);
    }


//        List<Student> students = new ArrayList<>();
//        students.add(new Student("1"));
//        students.add(new Student("2"));
//        students.add(new Student("3"));
//
//        for (Student student : students) {
//            System.out.println("student: "+student);
//        }


  }

  private static String stripExampleQuotes(String raw) {
    return raw
        .replaceAll("^\"+", "")  // Strip leading quotes
        .replaceAll("\"+$", ""); // Strip trailing quotes
  }
}
