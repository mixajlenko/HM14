package org.hillel.demo;

import java.util.*;
import java.util.stream.Collectors;

public class Student {

    List<Student> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    private String name;
    private double age;
    private int mark;
    private boolean lifeCycle = true;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setLifeCycle(boolean lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public void app() {
        while (lifeCycle) {
            Scanner scanner = new Scanner(System.in);
                System.out.println("\nEnter the command:\n" +
                        "add\n" +
                        "view\n" +
                        "exit");
            String sig = scanner.nextLine();
            switch (sig) {
                case ("add"):
                    add();
                    break;
                case("view"):
                    view();
                    break;
                case ("exit"): {
                    setLifeCycle(false);
                    break;
                }
            }
        }
    }

    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the student`s name: ");
        String input = scanner.nextLine();
        Student test = new Student();
        test.setName(input);
        System.out.println("Enter the age: ");
        double input1 = scanner.nextDouble();
        test.setAge(input1);
        System.out.println("Enter the mark: ");
        int intput2 = scanner.nextInt();
        test.setMark(intput2);
        list.add(test);
        System.out.println("----SUCCESS ADDED----");
    }

        public void view(){
            System.out.println("Choose the collection:" +
                    "\nList of student`s names - set" +
                    "\nList of student`s names and age - map" +
                    "\nSorted list by age - list" +
                    "\nCount of students - count" +
                    "\nCount of unique students - unique");
            String choise = sc.nextLine();
            switch (choise){
                case("set"):
                    Set<String> set1 = list.stream().map(Student::getName).collect(Collectors.toSet());
                    set1.stream().forEach(System.out::println);
                    System.out.println("--------------------------");
                    break;
                case ("map"):
                    Set<Double> set = new HashSet<>();
                    Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
                    for (Student o : list) {
                        set.add(o.getAge());
                    }
                    for (String str : map.keySet()) {
                        String message = "key is: %s\tvalue is: " + set;
                        System.out.println(String.format(message, str));
                    }
                    System.out.println("--------------------------");
                    break;
                case ("list"):
                    list.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
                    System.out.println("--------------------------");
                    break;
                case ("count"):
                    long countOfStudents = list.stream().count();
                    System.out.println("\nCount of students in list: " + countOfStudents);
                    System.out.println("--------------------------");
                    break;
                case ("unique"):
                    long countOfUniqueStudents = list.stream().distinct().count();
                    System.out.println("\nCount of unique students in list: " + countOfUniqueStudents);
                    System.out.println("--------------------------");
                    break;
            }
        }
    @Override
    public String toString() {
        return "Student " +
                "name - " + name +
                ", age - " + age +
                ", mark - " + mark;
    }
}
