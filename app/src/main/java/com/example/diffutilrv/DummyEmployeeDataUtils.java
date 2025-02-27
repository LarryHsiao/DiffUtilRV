package com.example.diffutilrv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Mock data.
 */
public class DummyEmployeeDataUtils {
    public static List<Employee> getEmployeeListSortedByName() {
        final List<Employee> employeeList = getEmployeeList();
        employeeList.sort(Comparator.comparing(Employee::getName));
        return employeeList;
    }

    public static List<Employee> getEmployeeListSortedByRole() {
        final List<Employee> employeeList = getEmployeeList();
        employeeList.sort((a1, a2) -> a2.getRole().compareTo(a1.getRole()));
        return employeeList;
    }

    private static List<Employee> getEmployeeList() {
        final List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Employee 1", "Developer"));
        employees.add(new Employee(2, "Employee 2", "Tester"));
        employees.add(new Employee(3, "Employee 3", "Support"));
        employees.add(new Employee(4, "Employee 4", "Sales Manager"));
        employees.add(new Employee(5, "Employee 5", "Manager"));
        employees.add(new Employee(6, "Employee 6", "Team lead"));
        employees.add(new Employee(7, "Employee 7", "Scrum Master"));
        employees.add(new Employee(8, "Employee 8", "Sr. Tester"));
        employees.add(new Employee(9, "Employee 9", "Sr. Developer"));
        return employees;
    }

}
