package kr.masirou.academy;

public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }
    public Person(String data) {
        String[] args = data.split(" : ");
        this.name = args[0];
        this.age = Integer.parseInt(args[1]);
    }
    public void PrintInfo() {
        System.out.println(name + " " + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return name + " : " + age;
    }
}
