package kr.masirou.academy.calc2;

public class Mul extends Calc {
    public Mul(int  num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int calc() {
        return num1*num2;
    }

}
