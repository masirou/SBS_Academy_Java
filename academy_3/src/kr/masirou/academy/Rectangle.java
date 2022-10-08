package kr.masirou.academy;

import kr.masirou.academy.abstract_.LenHei;
import kr.masirou.academy.interface_.Name;
import kr.masirou.academy.interface_.Re;

public class Rectangle extends LenHei implements Re, Name {
    public Rectangle() {
        super(5, 10);
    }
    public Rectangle(int length, int height) {
        super(length, height);
        super.length = length;
        super.height = height;
    }
    @Override
    public Integer getArea(){
        return  length*height;
    }
    @Override
    public String getName(){
        return "사각형";
    }
}
