package com.java8.CollectorsExample;


import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExample {

    private static final int PASS_THRESHOLD = 40;

    public static void main(String[] args) {

        // 1. Accumulate names into a List
        List<Person> people = Arrays.asList(
                new Person("Amit"),
                new Person("Priya"),
                new Person("Rahul"),
                new Person("Amit")
        );

        List<String> list = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("1. Names List: " + list);


        // 2. Accumulate names into a TreeSet
        Set<String> set = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("2. Names TreeSet: " + set);


        // 3. Join strings separated by commas
        List<Object> things = Arrays.asList(
                "Java", "Spring Boot", "Kafka", 100
        );

        String joined = things.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println("3. Joined: " + joined);


        // Sample employees
        List<Employee> employees = Arrays.asList(
                new Employee("Amit", 50000, Department.IT),
                new Employee("Priya", 70000, Department.IT),
                new Employee("Rahul", 40000, Department.HR),
                new Employee("Sneha", 60000, Department.HR),
                new Employee("Ravi", 80000, Department.FINANCE)
        );


        // 4. Compute total salary
        int total = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));

        System.out.println("4. Total Salary: " + total);


        // 5. Group employees by department
        Map<Department, List<Employee>> byDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment
                        ));

        System.out.println("5. Employees By Department:");
        byDept.forEach((dept, emps) ->
                System.out.println(dept + " -> " + emps)
        );


        // 6. Sum salaries by department
        Map<Department, Integer> totalByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingInt(Employee::getSalary)
                        ));

        System.out.println("6. Total Salary By Department:");
        totalByDept.forEach((dept, salary) ->
                System.out.println(dept + " -> " + salary)
        );


        // 7. Partition students into passing/failing
        List<Student> students = Arrays.asList(
                new Student("Amit", 75),
                new Student("Priya", 35),
                new Student("Rahul", 60),
                new Student("Sneha", 25)
        );

        Map<Boolean, List<Student>> passingFailing =
                students.stream()
                        .collect(Collectors.partitioningBy(
                                s -> s.getGrade() >= PASS_THRESHOLD
                        ));

        System.out.println("7. Passing Students: "
                + passingFailing.get(true));

        System.out.println("   Failing Students: "
                + passingFailing.get(false));
    }


    // Person class
    static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    // Department enum
    enum Department {
        IT, HR, FINANCE
    }


    // Employee class
    static class Employee {
        private String name;
        private int salary;
        private Department department;

        Employee(String name, int salary, Department department) {
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        public int getSalary() {
            return salary;
        }

        public Department getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name + "(" + salary + ")";
        }
    }


    // Student class
    static class Student {
        private String name;
        private int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public int getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return name + "(" + grade + ")";
        }
    }
}
