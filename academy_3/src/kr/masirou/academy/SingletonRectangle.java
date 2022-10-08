package kr.masirou.academy;

import kr.masirou.academy.abstract_.LenHei;
import kr.masirou.academy.interface_.Name;
import kr.masirou.academy.interface_.Re;

public class SingletonRectangle extends LenHei implements Re, Name {
    private static SingletonRectangle instance;
    public static SingletonRectangle getInstance(int length, int height) {
        if(instance == null) {
            instance = new SingletonRectangle(length, height);
        }
        return instance;
    }
    public static SingletonRectangle getInstance() {
        if(instance == null) {
            instance = new SingletonRectangle();
        }
        return instance;
    }
    private SingletonRectangle() {
        super(5, 10);
    }
    private SingletonRectangle(int length, int height) {
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
