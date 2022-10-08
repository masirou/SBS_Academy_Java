package kr.masirou.academy;

import kr.masirou.academy.interface_.Name;
import kr.masirou.academy.interface_.Re;

public class Tri implements Re, Name {

    private int height;
    private int length;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }


    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
    public Tri(int length, int height) {
        this.length = length;
        this.height = height;
    }
    @Override
    public Integer getArea(){
        return length*height/2;
    }

    @Override
    public String getName(){
        return "삼각형";
    }
}
