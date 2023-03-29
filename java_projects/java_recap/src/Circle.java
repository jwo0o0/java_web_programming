public class Circle {
    public int radius;
    public String name;

    public Circle() {
        radius = 1;
        name = "";
    }
    public Circle(int r) {
        this("", r);
    }
    public Circle(String n, int r) {
        name = n;
        radius = r;
    }
    public double getArea() {

        return 3.14*radius*radius;
    }

    public static void main(String[] args) {
        Circle[] circles;
        circles = new Circle[5];
        for(int i = 0; i< circles.length; i++) {
            circles[i] = new Circle(i);
        }
        for(int i = 0; i< 5; i++) {
            System.out.print((int)(circles[i].getArea()) + " ");
        }
    }
}
