package kr.masirou.info;

public class Info {
    private int number;
    private String name;
    private String phone;
    private String memo;



    public String getName() {return name;}
    public int getNumber() {return number;}
    public String getPhone() {return phone;}
    public String getMemo() {return memo;}

    public Info(String name, String phone) {
        this(name, phone, null);
    }
    public Info(String name, String phone, String memo) {
        this.name = name;
        this.phone = phone;
        this.memo = memo;
        number = InfoManager.getInstance().registerInfo(this);
    }
    public Info(int number, String name, String phone) {
        this(number,name,phone,null);
    }
    public Info(int number, String name, String phone, String memo) {
        this.number = number;
        this.name = name;
        this.phone = phone;
        this.memo = memo;

    }
    public void printInfo() {
        System.out.print("[" + number + "]" + " : " + name + " : " + phone + " : ");
        if(memo == null) System.out.println("없음");
        else System.out.println(memo);
    }

}
