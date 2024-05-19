package Compare;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableDemo {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(4, "Dave", 25, 28000));
        empList.add(new Employee(20, "Mike", 20, 10000));
        empList.add(new Employee(9, "Abhi", 32, 5000));
        empList.add(new Employee(1, "Lisa", 40, 19000));
        empList.add(new Employee(15, "Mike", 25, 15000));
        empList.add(new Employee(8, "Mike", 30, 20000));

        Collections.sort(empList);

        System.out.println("Comparable(ID): " + empList);

        Comparator<Employee> nameComparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
        Comparator<Employee> salaryComparator = (e1, e2) -> (int) (e1.getSalary() - e2.getSalary());
        Comparator<Employee> nameAgeComparator = (e1, e2) -> {
            int flag = e1.getName().compareTo(e2.getName());
            if (flag == 0) {
                flag = e1.getAge() - e2.getAge();
            }
            return flag;
        };

        Collections.sort(empList, nameComparator);
        System.out.println("NameComparator: " + empList);

        Collections.sort(empList, salaryComparator);
        System.out.println("SalaryComparator: " + empList);

        Collections.sort(empList, nameAgeComparator);
        System.out.println("NameAgeComparator: " + empList);

    }
}
