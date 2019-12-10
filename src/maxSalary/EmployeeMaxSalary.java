package maxSalary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeMaxSalary {

    public static void main(String[] args) {
        List<Employee> employee = new ArrayList<>();
        employee.add(new Employee(10,"Raghu",25000));
        employee.add(new Employee(120,"Krish",45000));
        employee.add(new Employee(210,"John",14000));
        employee.add(new Employee(150,"Kishore",24000));
        Employee employeeMaxSalary = Collections.max(employee,new EmployeeComparator());
        System.out.println("Employee with max Salary " + employeeMaxSalary);

    }
}
