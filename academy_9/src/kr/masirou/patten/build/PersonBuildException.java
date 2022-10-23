package kr.masirou.patten.build;

public class PersonBuildException extends Exception{
    public PersonBuildException(String type) {
        super(type + "을(를) 설정하는 도중 오류가 발생헀습니다");
    }
}
