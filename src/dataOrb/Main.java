package dataOrb;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        String s = "{}({)[]";
//        System.out.println(isValid(s));

        List<String> stringList = List.of("AHM-Eng", "BBS-HR", "MMI-Eng");
        Map<String, String> map = new HashMap<>();
        stringList.forEach(s -> {
            String[] arr = s.split("-");
            map.put(arr[0], arr[1]);
        });

        List<Employee> list = new ArrayList<>();
        Employee e1 = new Employee(1, "Mohit", "BBS", "HR");
        Employee e2 = new Employee(2, "Mohit", "BBS", "R");
        Employee e3 = new Employee(3, "Mohit", "BB", "R");

        list.add(e1);
        list.add(e2);
        list.add(e3);

        List<Employee> empList = list.stream()
                .filter(emp -> !(map.containsKey(emp.getCity()) && emp.getDepartment().equals(map.get(emp.getCity())))).toList();
        System.out.println(empList);

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if(map.containsKey(c)) {
                    if(map.get(c) == stack.peek()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
