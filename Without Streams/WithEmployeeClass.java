import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}


public class Main {

    public static List<Employee> findSecondHighestSalary(
            List<Employee> employees) {

        // YOUR IMPLEMENTATION HERE
        List<Employee> res = new ArrayList<>();
        if (employees == null || employees.isEmpty()) {
            return res;
        }
        
        double maxi = Double.NEGATIVE_INFINITY;
        double secondMaxi = Double.NEGATIVE_INFINITY;
        for (Employee e: employees) {
            if (e.getSalary() > maxi) {
                secondMaxi = maxi;
                maxi = e.getSalary();
            } else if (e.getSalary() < maxi && e.getSalary() > secondMaxi) {
                secondMaxi = e.getSalary();
            }
        }
        for (Employee e: employees) {
            if (e.getSalary() == secondMaxi) {
                res.add(e);
            }
        }

        return res;
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> hm = new HashMap<>();
        if (employees == null || employees.isEmpty()) {
            return hm;
        }
        for(Employee e: employees) {
            hm.computeIfAbsent(e.getDepartment(), k -> new ArrayList<>()).add(e);
        }
        return hm;
    }

    public static Map<String, Employee> highestPaidByDepartment(List<Employee> employees) {
        Map<String, Employee> res = new HashMap<>();
        if (employees == null || employees.isEmpty()) {
            return res;
        }
        for(Employee employee: employees) {
             Employee currentHighest =
                res.get(employee.getDepartment());

            if (currentHighest == null ||
                    employee.getSalary() > currentHighest.getSalary()) {
    
                res.put(employee.getDepartment(), employee);
            }
        }
        return res;
    }

    public static List<String> getHighEarners(
        List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return List.of();
        }
        List<String> res = 
            employees.stream()
            .filter(e -> e.getSalary() >= 100000)
            .map(Employee::getName)
            .sorted()
            .toList();
        return res;
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.averagingDouble(
                        Employee::getSalary
                    )
                )
            );
    }
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "John", 90000, "IT"),
                new Employee(2, "Alice", 120000, "Finance"),
                new Employee(3, "Bob", 100000, "IT"),
                new Employee(4, "David", 120000, "Finance"),
                new Employee(5, "Emma", 100000, "IT"),
                new Employee(6, "Sam", 80000, "Finance")
        );

        // List<Employee> result =
        //         findSecondHighestSalary(employees);

        // System.out.println("Employees with second highest salary:");

        // result.forEach(System.out::println);

       // Map<String, List<Employee>> res = groupByDepartment(employees);
       //  System.out.println(res);
       Map<String, Employee> res = highestPaidByDepartment(employees);
        System.out.println(res);
    }
}
