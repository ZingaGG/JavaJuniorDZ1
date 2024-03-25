import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Anna", 19, 51_000, new Department()));
        personList.add(new Person("David", 20, 52_000, new Department()));
        personList.add(new Person("David", 50, 52_000, new Department()));
        personList.add(new Person("David", 20, 42_000, new Department()));
        personList.add(new Person("Boris", 21, 53_000, new Department()));
        personList.add(new Person("Liza", 22, 54_000, new Department()));
        personList.add(new Person("Ilia", 23, 55_000, new Department()));
        personList.add(new Person("Albert", 24, 56_000, new Department()));
        personList.add(new Person("Victor", 25, 57_000, new Department()));
        personList.add(new Person("Alexandra", 26, 58_000, new Department()));
        personList.add(new Person("Maria", 27, 59_000, new Department()));
        personList.add(new Person("Phill", 28, 60_000, new Department()));
        personList.add(new Person("Jhon", 29, 61_000, new Department()));

        // Вывести на консоль отсортированные (по алфавиту) имена персонов
        System.out.println("Task 1:");
        System.out.println();
        Person.printNamesOrdered(personList);

        System.out.println();
        // В каждом департаменте найти самого взрослого сотрудника.
        //   * Вывести на консоль мапипнг department -> personName
        System.out.println("Task 2:");
        System.out.println();
        Person.printDepartmentOldestPerson(personList);

        System.out.println();

        // Найти 10 первых сотрудников, младше 30 лет, у которых зарплата выше 50_000
        System.out.println("Task 3:");
        System.out.println();

        for(Person x: Person.findFirstPersons(personList)){
            System.out.println(x);
        }

        System.out.println();

        //Найти депаратмент, чья суммарная зарплата всех сотрудников максимальна
        System.out.println("Task 4:");
        System.out.println();

        System.out.println(Person.findTopDepartment(personList));
    }
}
