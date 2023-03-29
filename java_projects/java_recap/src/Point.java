public class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void showPoint() {
        System.out.println("(" + x + "," + y + ")");
    }
}

class ColorPoint extends Point {
    private String color;
    public ColorPoint(int x, int y, String color) {
        //명시적으로 슈퍼 클래스의 생성자 지정
        super(x, y);
        this.color = color;
    }
    public void showColorPoint() {
        System.out.print(color);
        showPoint();
    }
}