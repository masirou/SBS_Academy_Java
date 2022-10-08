package kr.masirou.academy;

import kr.masirou.academy.abstract_.LenHei;

public class Main {
    public static void main(String[] args) {
        SingletonRectangle Sr = SingletonRectangle.getInstance(5, 10);
        SingletonRectangle Sr1 = SingletonRectangle.getInstance();
        Sr.setLength(10);
        System.out.println(Sr.getLength());
        System.out.println(Sr1.getLength());


    }
}