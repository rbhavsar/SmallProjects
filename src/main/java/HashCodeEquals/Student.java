package HashCodeEquals;


public class Student {


  String studentRegistrationNumber;

  public Student(String studentRegistrationNumber) {
    this.studentRegistrationNumber = studentRegistrationNumber;
  }

  public String getStudentRegistrationNumber() {
    return studentRegistrationNumber;
  }

  public void setStudentRegistrationNumber(String studentRegistrationNumber) {
    this.studentRegistrationNumber = studentRegistrationNumber;
  }


  public boolean equals(Object o){
    System.out.println("In Equals..");
    if(o!=null && o instanceof Student){
      String regNumber = ((Student) o).getStudentRegistrationNumber();
      if(regNumber!=null && regNumber.equalsIgnoreCase(this.studentRegistrationNumber)){
        return true;
      }
    }
    return false;
  }

  public int hashCode(){
    System.out.println("In HashCode");
    return this.studentRegistrationNumber.hashCode();
  }





}
