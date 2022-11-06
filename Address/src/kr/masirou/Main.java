package kr.masirou;

import kr.masirou.db.DatabaseManager;
import kr.masirou.info.Info;
import kr.masirou.info.InfoManager;
import kr.masirou.menu.Menu;
import kr.masirou.menu.MenuData;
import kr.masirou.menu.MenuListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        new Main();


    }
    private List<MenuData> menulist;
    private MenuListener listener;
    private Main() throws InvocationTargetException, IllegalAccessException {
        menulist = new ArrayList<>();
        DatabaseManager.getInstance();
        listener = new MenuListener();
        findMenuMethod(listener);
        int index = 1;
        for(MenuData data : menulist) {
            System.out.println(index++  + "." + data.getName());
        }
        System.out.print("메뉴를 선택하세요 : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt() -1;
        if(input < 0) System.out.println("머함");
        else if (input >= menulist.size()) System.out.println("머함");
        else {
            MenuData data = menulist.get(input);
            data.getMethod().invoke(listener);
        }
    }
    private void findMenuMethod(MenuListener listener) {
        Arrays.stream(listener.getClass().getMethods()).filter((method) -> {

            return Arrays.stream(method.getAnnotations()).anyMatch(annotation -> annotation instanceof Menu);
        }).sorted((method1, method2) -> {
            Menu menu1 = method1.getDeclaredAnnotation(Menu.class);
            Menu menu2 = method2.getDeclaredAnnotation(Menu.class);
            return Integer.compare(menu1.priority(),menu2.priority());
        }).forEach((method) -> {
            Menu menu  =  method.getDeclaredAnnotation(Menu.class);
            menulist.add(new MenuData(menu.name(), method));
        });
    }

}