package kr.masirou.academy;

public enum Day {
    NONE("잉"),
    MON("월요일"),
    TUE("화요일"),
    WED("수요일"),
    THU("목요일"),
    FRI("금요일"),
    SAT("토요일"),
    SUN("일요일");
    private String kor;
    Day(String kor) {
        this.kor = kor;
    }
    public String getKor() {
        return kor;
    }
}
