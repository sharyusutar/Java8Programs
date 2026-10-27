package com.java8.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SalaryStreamQuestions {

    public static void main(String[] args) {

        List<Integer> employeeSalaries =
                Arrays.asList(3, 4, 5, 6, 9);

        // 1. Highest salary
        Integer highest = employeeSalaries.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);

        employeeSalaries.stream().max(Comparator.naturalOrder()).orElse(null);

        System.out.println("Highest salary: " + highest);


        // 2. Lowest salary
        Integer lowest = employeeSalaries.stream()
                .min(Comparator.naturalOrder())
                .orElse(null);

        System.out.println("Lowest salary: " + lowest);


        // 3. Total salary
        Integer total = employeeSalaries.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total salary: " + total);


        // 4. Average salary
        double average = employeeSalaries.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("Average salary: " + average);


        // 5. Even salaries
        List<Integer> evenSalaries = employeeSalaries.stream()
                .filter(salary -> salary % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even salaries: " + evenSalaries);


        // 6. Odd salaries
        List<Integer> oddSalaries = employeeSalaries.stream()
                .filter(salary -> salary % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("Odd salaries: " + oddSalaries);


        // 7. Salaries greater than 5
        List<Integer> greaterThanFive = employeeSalaries.stream()
                .filter(salary -> salary > 5)
                .collect(Collectors.toList());

        System.out.println("Salaries greater than 5: "
                + greaterThanFive);


        // 8. Count salaries greater than or equal to 5
        long count = employeeSalaries.stream()
                .filter(salary -> salary >= 5)
                .count();

        System.out.println("Count >= 5: " + count);


        // 9. Ascending order
        List<Integer> ascending = employeeSalaries.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Ascending: " + ascending);


        // 10. Descending order
        List<Integer> descending = employeeSalaries.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Descending: " + descending);


        // 11. Second-highest salary
        Integer secondHighest = employeeSalaries.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second-highest salary: "
                + secondHighest);


        // 12. Second-lowest salary
        Integer secondLowest = employeeSalaries.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println("Second-lowest salary: "
                + secondLowest);


        // 13. Increase every salary by 10%
        List<Double> increasedSalaries = employeeSalaries.stream()
                .map(salary -> salary * 1.10)
                .collect(Collectors.toList());

        System.out.println("Salaries after 10% increase: "
                + increasedSalaries);


        // 14. Square of every salary
        List<Integer> salarySquares = employeeSalaries.stream()
                .map(salary -> salary * salary)
                .collect(Collectors.toList());

        System.out.println("Salary squares: " + salarySquares);


        // 15. Sum of even salaries
        int evenSalarySum = employeeSalaries.stream()
                .filter(salary -> salary % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of even salaries: "
                + evenSalarySum);


        // 16. Sum of odd salaries
        int oddSalarySum = employeeSalaries.stream()
                .filter(salary -> salary % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of odd salaries: "
                + oddSalarySum);


        // 17. Partition salaries into even and odd
        Map<Boolean, List<Integer>> partitioned =
                employeeSalaries.stream()
                        .collect(Collectors.partitioningBy(
                                salary -> salary % 2 == 0));

        System.out.println("Partitioned salaries: "
                + partitioned);


        // 18. Comma-separated salaries
        String joinedSalaries = employeeSalaries.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("Joined salaries: " + joinedSalaries);


        // 19. Skip first two salaries
        List<Integer> afterSkipping = employeeSalaries.stream()
                .skip(2)
                .collect(Collectors.toList());

        System.out.println("After skipping two: "
                + afterSkipping);


        // 20. First three salaries
        List<Integer> firstThree = employeeSalaries.stream()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("First three salaries: " + firstThree);


        // 21. Product of all salaries
        int product = employeeSalaries.stream()
                .reduce(1, (salary1, salary2) ->
                        salary1 * salary2);

        System.out.println("Product: " + product);


        // 22. Check whether every salary is greater than 2
        boolean allGreaterThanTwo = employeeSalaries.stream()
                .allMatch(salary -> salary > 2);

        System.out.println("All salaries > 2: "
                + allGreaterThanTwo);


        // 23. Check whether any salary is greater than 8
        boolean anyGreaterThanEight = employeeSalaries.stream()
                .anyMatch(salary -> salary > 8);

        System.out.println("Any salary > 8: "
                + anyGreaterThanEight);


        // 24. Check whether no salary is negative
        boolean noNegativeSalary = employeeSalaries.stream()
                .noneMatch(salary -> salary < 0);

        System.out.println("No negative salary: "
                + noNegativeSalary);


        // 25. Find salary closest to average
        double salaryAverage = employeeSalaries.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        Integer closestToAverage = employeeSalaries.stream()
                .min(Comparator.comparingDouble(
                        salary -> Math.abs(salary - salaryAverage)))
                .orElse(null);

        System.out.println("Salary closest to average: "
                + closestToAverage);


        // 26. Difference between highest and lowest salary
        int difference = highest != null && lowest != null
                ? highest - lowest
                : 0;

        System.out.println("Highest-lowest difference: "
                + difference);


        // 27. Create Map<salary, salary square>
        Map<Integer, Integer> salarySquareMap =
                employeeSalaries.stream()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                salary -> salary * salary
                        ));

        System.out.println("Salary-square map: "
                + salarySquareMap);


        // 28. Summary statistics
        IntSummaryStatistics statistics =
                employeeSalaries.stream()
                        .mapToInt(Integer::intValue)
                        .summaryStatistics();

        System.out.println("Count: " + statistics.getCount());
        System.out.println("Sum: " + statistics.getSum());
        System.out.println("Minimum: " + statistics.getMin());
        System.out.println("Maximum: " + statistics.getMax());
        System.out.println("Average: " + statistics.getAverage());


        // 29. Highest three salaries
        List<Integer> highestThree = employeeSalaries.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Highest three salaries: "
                + highestThree);


        // 30. Safely find maximum from empty list
        List<Integer> emptySalaries = Collections.emptyList();

        Optional<Integer> maximumSalary = emptySalaries.stream()
                .max(Comparator.naturalOrder());

        System.out.println("Maximum from empty list: "
                + maximumSalary.orElse(null));


        /*
         * Duplicate-related questions
         */

        List<Integer> salariesWithDuplicates =
                Arrays.asList(3, 4, 5, 6, 9, 4, 6, 9);


        // 31. Remove duplicate salaries
        List<Integer> uniqueSalaries =
                salariesWithDuplicates.stream()
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println("Unique salaries: " + uniqueSalaries);


        // 32. Find duplicate salaries
        Set<Integer> seen = new HashSet<>();

        Set<Integer> duplicateSalaries =
                salariesWithDuplicates.stream()
                        .filter(salary -> !seen.add(salary))
                        .collect(Collectors.toSet());

        System.out.println("Duplicate salaries: "
                + duplicateSalaries);


        // 33. Count frequency of every salary
        Map<Integer, Long> frequencyMap =
                salariesWithDuplicates.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        ));

        System.out.println("Salary frequency: " + frequencyMap);


        // 34. Find salaries occurring more than once
        List<Integer> repeatedSalaries =
                frequencyMap.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue() > 1)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        System.out.println("Repeated salaries: "
                + repeatedSalaries);


        // 35. Find the first duplicate salary
        Set<Integer> visited = new HashSet<>();

        Integer firstDuplicate = salariesWithDuplicates.stream()
                .filter(salary -> !visited.add(salary))
                .findFirst()
                .orElse(null);

        System.out.println("First duplicate salary: "
                + firstDuplicate);


        // 36. Second-highest distinct salary
        Integer secondHighestDistinct =
                salariesWithDuplicates.stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
                        .orElse(null);

        System.out.println("Second-highest distinct salary: "
                + secondHighestDistinct);
    }
}