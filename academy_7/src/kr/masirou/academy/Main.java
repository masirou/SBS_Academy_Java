package kr.masirou.academy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> days = new ArrayList();
        days.add("MON");
        days.add("FRI");
        days.add("DD");
        List<Day> list;
        list = days
                .stream()
                .map((s) -> {
                    Day day = Day.NONE;
                    try {
                        day = Day.valueOf(s);
                    } catch(IllegalArgumentException e) {

                    }
                    return day;
                })
                .filter((o) -> o != Day.NONE)
                .collect(Collectors.toList());

        System.out.println(list);

    }
}