package maxSalary;

public class Employee {

    private int empId;
    private String name;
    private Integer salary;

    public Employee(int empId, String name, Integer salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    public String toString(){
        return empId+"  "+name+"   "+salary;
    }
}
