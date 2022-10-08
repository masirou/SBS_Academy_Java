package kr.masirou.academy.entity;

public enum SchoolType {
    ELE("초등학교", 8, 13),
    MID("중학교", 14, 16),
    HIGH("고등학교", 17, 19),
    UNIV("대학교",20);

    private String school;
    private int minAge;
    private int maxAge;
    SchoolType(String school, int minAge, int maxAge) {
        this.school = school;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    SchoolType(String school, int minAge) {
        this.school = school;
        this.minAge = minAge;
        maxAge = Integer.MAX_VALUE;
    }

    public String getSchool() {
        return school;
    }
    public boolean checkAge(Person person) {
        return person.getAge() >= minAge && person.getAge() <= maxAge;

    }
}
