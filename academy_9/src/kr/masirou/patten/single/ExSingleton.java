package kr.masirou.patten.single;

public class ExSingleton {
    private static ExSingleton instance;
    public static  ExSingleton getInstance() {
        return  instance== null ? new ExSingleton() : instance;

    }
    private ExSingleton() { instance = this ; }
}
