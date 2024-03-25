import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
public class Person {
    String name;
    int age;
    int salary;
    Department department;

    public static void printNamesOrdered(List<Person> personList) {
        personList.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
    }

    public static Map<Department, Person> printDepartmentOldestPerson(List<Person> persons) {
    Map<Department, Person> result = new HashMap<>();
        List<Person> temp;
        Person p1;

        temp = persons.stream().filter(person -> person.getDepartment().id == 1).toList();

        p1 = temp.stream()
                .max(Comparator.comparingInt(Person::getAge)).orElse(null);

        result.put(p1.department, p1);

        temp = persons.stream().filter(person -> person.getDepartment().id == 2).toList();

        p1 = temp.stream()
                .max(Comparator.comparingInt(Person::getAge)).orElse(null);

        result.put(p1.department, p1);

        result.forEach(((department1, person) -> System.out.println(department1 + " -> " + person.name + " " + person.age)));

        return result;
    }

    public static List<Person> findFirstPersons(List<Person> persons) {
        return persons.stream()
                .filter(person -> person.age < 30 && person.salary > 50000)
                .limit(5)
                .toList();
    }

    public static Optional<Department> findTopDepartment(List<Person> persons) {
        Map<Department, Integer> departmentSalaryTotal = persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.summingInt(Person::getSalary)));

        Optional<Map.Entry<Department, Integer>> maxEntry = departmentSalaryTotal.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return maxEntry.map(Map.Entry::getKey);
    }
}
