public class Main {
    public static void main(String[] args) {

        Circle pizza = new Circle("자바피자",3);
        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area);

        Circle donut = new Circle("자바도넛", 2);
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area);
    }
}