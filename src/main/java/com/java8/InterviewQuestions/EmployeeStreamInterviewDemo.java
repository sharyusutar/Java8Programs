package com.java8.InterviewQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamInterviewDemo {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", "IT", 90000, 28),
                new Employee(102, "David", "HR", 60000, 35),
                new Employee(103, "Sam", "IT", 120000, 40),
                new Employee(104, "Peter", "Finance", 85000, 32),
                new Employee(105, "Mary", "HR", 75000, 29),
                new Employee(106, "Alice", "IT", 95000, 26),
                new Employee(107, "Bob", "Finance", 110000, 45),
                new Employee(108, "Tom", "Sales", 70000, 31)
        );

        List<Integer> employeesSalary = Arrays.asList(3,4,5,6,9);

         Integer highestSalary = employeesSalary.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);


        // 1. Highest Paid Employee
        System.out.println("\n1. Highest Paid Employee");
        Employee highest =
                employees.stream()
                        .max(Comparator.comparing(Employee::getSalary))
                        .orElse(null);

        System.out.println(highest);

        // 2. Second Highest Salary
        System.out.println("\n2. Second Highest Salary");

        Employee secondHighest =
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getSalary)
                                .reversed())
                        .skip(1)
                        .findFirst()
                        .orElse(null);

        System.out.println(secondHighest);

        // 3. Group By Department
        System.out.println("\n3. Group By Department");

        Map<String, List<Employee>> groupByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment));

        groupByDept.forEach(
                (dept, emp) -> System.out.println(dept + " -> " + emp));

        // 4. Count Employees By Department
        System.out.println("\n4. Employee Count By Department");

        Map<String, Long> countByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()));

        System.out.println(countByDept);

        // 5. Highest Salary Per Department
        System.out.println("\n5. Highest Salary Per Department");

        Map<String, Optional<Employee>> highestSalaryDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparing(
                                                Employee::getSalary))));

        highestSalaryDept.forEach(
                (dept, emp) ->
                        System.out.println(dept + " -> " + emp.get()));

        // 6. Average Salary By Department
        System.out.println("\n6. Average Salary By Department");

        Map<String, Double> avgSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(
                                        Employee::getSalary)));

        System.out.println(avgSalary);

        // 7. Employees Older Than 30
        System.out.println("\n7. Employees Older Than 30");

        employees.stream()
                .filter(e -> e.getAge() > 30)
                .forEach(System.out::println);

        // 8. Sort Employees By Salary
        System.out.println("\n8. Sort By Salary");

        employees.stream()
                .sorted(Comparator.comparing(
                        Employee::getSalary))
                .forEach(System.out::println);

        // 9. Top 3 Highest Paid Employees
        System.out.println("\n9. Top 3 Highest Paid Employees");

        employees.stream()
                .sorted(Comparator.comparing(
                                Employee::getSalary)
                        .reversed())
                .limit(3)
                .forEach(System.out::println);

        // 10. Employee Names
        System.out.println("\n10. Employee Names");

        List<String> names =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.toList());

        System.out.println(names);

        // 11. Total Salary Expense
        System.out.println("\n11. Total Salary");

        double totalSalary =
                employees.stream()
                        .mapToDouble(Employee::getSalary)
                        .sum();

        System.out.println(totalSalary);

        // 12. Partition Employees By Age > 30
        System.out.println("\n12. Partition By Age");

        Map<Boolean, List<Employee>> partition =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getAge() > 30));

        System.out.println(partition);

        // 13. Names Sorted
        System.out.println("\n13. Names Sorted");

        employees.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        // 14. Department Names
        System.out.println("\n14. Unique Departments");

        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        // 15. Employee With Minimum Salary
        System.out.println("\n15. Minimum Salary Employee");

        Employee lowSalary =
                employees.stream()
                        .min(Comparator.comparing(
                                Employee::getSalary))
                        .orElse(null);

        System.out.println(lowSalary);

        // 16. Count Employees
        System.out.println("\n16. Employee Count");

        System.out.println(employees.stream().count());

        // 17. Employees In IT
        System.out.println("\n17. IT Employees");

        employees.stream()
                .filter(e ->
                        e.getDepartment().equals("IT"))
                .forEach(System.out::println);

        // 18. Employee Names Joined
        System.out.println("\n18. Employee Names Joined");

        String joined =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.joining(", "));

        System.out.println(joined);

        // 19. Salary Statistics
        System.out.println("\n19. Salary Statistics");

        DoubleSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingDouble(
                                Employee::getSalary));

        System.out.println(stats);

        // 20. Names To Map
        System.out.println("\n20. Name -> Salary");

        Map<String, Double> salaryMap =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getName,
                                Employee::getSalary));

        System.out.println(salaryMap);
    }

    static class Employee {

        private int id;
        private String name;
        private String department;
        private double salary;
        private int age;

        public Employee(int id,
                        String name,
                        String department,
                        double salary,
                        int age) {

            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    '}';
        }
    }
}