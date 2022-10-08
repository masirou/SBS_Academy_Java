package kr.masirou.academy.abstract_;

public abstract class LenHei {
    protected int length;
    protected int height;
    public LenHei(int length, int height) {
        this.height = height;
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public int getHeight() {
        return height;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
