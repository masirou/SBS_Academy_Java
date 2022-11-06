package kr.masirou;

public class PersonDTO {
    private String name;
    private int age;
    public PersonDTO(String name, int age) {
        this.name = name;
        this.age = age;

    }
    public int getAge() {
        return age;
    }
}
