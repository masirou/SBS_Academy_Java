package kr.masirou.academy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(15);
        list.add(30);
        list.add(50);


        list = list.stream().filter((a) -> a < 13).collect(Collectors.toList());//.forEach((a) -> System.out.println(a));
        System.out.println(list);

    }

}