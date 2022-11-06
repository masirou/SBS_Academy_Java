package kr.masirou.menu;

import kr.masirou.info.Info;
import kr.masirou.info.InfoManager;

import java.util.List;
import java.util.Scanner;

public class MenuListener {
    private Scanner sc;
    private String regPhone;
    public MenuListener() {
        sc = new Scanner(System.in);
        regPhone = "^010[-]?(\\d{4})[-]?(\\d{4})$";
    }
    @Menu(name = "추가", priority = 1)
    public void openAddMenu() {
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("번호을 입력하세요 : ");
        String phone = sc.nextLine();
        phone = phone.replace("-", "");
        if(phone.matches(regPhone)) {
            System.out.print("메모를 입력하세요(없으면 엔터) : ");
            String memo = sc.nextLine();
            Info info;
            if(memo.isEmpty()) {
                info  = new Info(name, phone);
            } else {
                info = new Info(name, phone, memo);
            }
            if(info.getNumber() == -1) {
                System.out.print("데이터 베이스 등록에 실패했습니다");
            } else if (info.getNumber() == -2) {
                System.out.print("중복 된 휴대폰 번호");
            }
            else System.out.println("데이터 베이스에 등록 되었습니다 (" + info.getNumber() + ")");


        }
        else System.out.println("폰 번호가 아닙니다");
    }
    @Menu(name = "삭제", priority = 2)
    public void openDelMenu() {
        System.out.println("삭제");
    }
    @Menu(name = "수정", priority = 3)
    public void openEditMenu() {
        System.out.println("수정");
    }
    @Menu(name = "목록", priority = 4)
    public void openListMenu() {
        List<Info> infos = InfoManager.getInstance().getInfos();
        if(infos.isEmpty()) {
            System.out.println("등록된 정보가 없습니다");
        }
        else {
            int page = 1;
            int maxPage = (infos.size() / 10) + 1 - (infos.size() % 10 == 0? 1 : 0);
            out:for(int i = page; i <= maxPage; i++) {
                System.out.println("목록 < " + i + "/" + maxPage + ">");
                for (int j = 0; j < 10; j++){
                    int index = j + (i-1)*10;
                    if(infos.size() <= index) break out;
                    infos.get(index).printInfo();
                }
                if(i != maxPage) {
                    System.out.println("-----More-----");
                    sc.nextLine();
                }
            }

        }
    }
}
