package kr.masirou.academy.object;

public class Person {


    private int age;
    private String name;
    private int weight;
    private int height;

    public Person(String name, int age, int weight, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            return equalsName((Person) obj);

        } else if (obj instanceof String) {
            return name == (String) obj;
        }
        return false;
    }

    public boolean equalsName(Person other) {
        return this.name == other.name;

    }
}
