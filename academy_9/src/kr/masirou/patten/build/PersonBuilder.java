package kr.masirou.patten.build;

import com.sun.istack.internal.NotNull;

public class PersonBuilder {
    private String schoolName;
    private String name;
    private int age;
    private int height;
    private int weight;
    public PersonBuilder() {
        name = null;
        schoolName = null;
        age = 1;
        weight = 1;
        height = 1;

    }

    /**
     * 이름을 설정하는 메서드
     * @param name String값이며 null값을 무시합니다
     * @return
     */
    public  PersonBuilder setName(@NotNull String name) {
        this.name = name;
        return this;
    }
    public  PersonBuilder setSchoolName(String schoolName) {
        this.schoolName = schoolName;
        return this;
    }
    public  PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    public  PersonBuilder setHeight(int height) {
        this.height = height;
        return this;
    }
    public  PersonBuilder setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public Person build() throws PersonBuildException{
        if(name == null) {
            throw new PersonBuildException("이름");
        }
        return new Person(name,schoolName,age,height,weight);

    }

}
