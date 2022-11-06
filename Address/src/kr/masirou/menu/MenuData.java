package kr.masirou.menu;

import java.lang.reflect.Method;

public class MenuData {
    private String name;
    private Method method;
    public MenuData(String name, Method method){
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return name;
    }

    public Method getMethod() {
        return method;
    }
}
