public class ShapeEx {
    static void paint(Shape p) {
        p.draw();
    }
    public static void main(String[] args) {
        //업캐스팅 -> 다형성 실형
        Shape s = new Circle();
        s.draw();
        paint(new Shape());
        paint(new Rect());
        paint(new Line());
    }
}
