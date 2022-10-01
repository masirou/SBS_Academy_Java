package kr.masirou.academy.calc2;

public abstract class Calc {
        protected int num1, num2;

    public Calc(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public abstract int calc();
 }
