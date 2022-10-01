package kr.masirou.academy;

public class Rectangle {

    private int height;
    private int length;

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }


    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
    public Rectangle(int length, int height) {
        this.length = length;
        this.height = height;
    }
}
