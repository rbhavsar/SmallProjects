package Employee;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;// Define order of generated JSON

import java.io.Serializable;

@JsonPropertyOrder(value = {
        "name",
        "empNo"
})
public class Employee implements Serializable{


    private int empNo;
    private String name;
    @JsonIgnore // Ignore this in generated JSON
    private double salary;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }





}
