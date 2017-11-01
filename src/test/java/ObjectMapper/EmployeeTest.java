package ObjectMapper;


import Employee.Employee;
import Employee.JsonUtil;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;
import java.util.Map;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setEmpNo(201);
        emp.setName("Ravi");
        emp.setSalary(1000);

        //Deal With Java Object
        String jsonEmployee = JsonUtil.convertJavaObjectToJson(emp);
        System.out.println("jsonEmployee String :"+jsonEmployee);

        //Deal With jsonString
        String jsonString = "{\"empNo\":201,\"name\":\"Ravi\",\"salary\":1000.0}";
        Employee employee = JsonUtil.convertJsonStringToJava(jsonString,Employee.class);
        System.out.println(employee.getEmpNo()+"----"+employee.getName()+"----"+employee.getSalary());

        //Deal with jsonArray
        String jsonArray = "[{\"empNo\":201,\"name\":\"Ravi\",\"salary\":1000.0}]";
        List<Employee> listEmployees = JsonUtil.convertJsonArrayToListObject(jsonArray, new TypeReference<List<Employee>>(){});
        System.out.println("**** list Employee Object Values ****");
        for (Employee listEmployee : listEmployees) {
            System.out.println(listEmployee.getEmpNo());
            System.out.println(listEmployee.getName());
            System.out.println(listEmployee.getSalary());
        }

        //Node Value
        String nodeValue = JsonUtil.getNodeValue(jsonString,"name");
        System.out.println("node Value :"+nodeValue);

        //Deal with Map
        Map<String, Object> stringObjectMap = JsonUtil.convertJsonStringToMapObject(jsonString, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(stringObjectMap);


        //in case the JSON string has some new fields, then the default process will run in an exception:
        String jsonString1 = "{\"empNo\":201,\"name\":\"Ravi\",\"salary\":1000.0,\"Department\":Engineering}";

    }

}
