package kr.masirou.equip;

public abstract class Equip {
    private int grade ;
    private String name;

    public int getGrade() {
        return grade;
    }
    public String getName() {
        return name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Equip(String name) {
        this.name = name;
        grade = 0;
    }
    @Override
    public String toString() {
        if (grade == 0) return name;
        else return name + " +" + grade + "강";
    }
}

