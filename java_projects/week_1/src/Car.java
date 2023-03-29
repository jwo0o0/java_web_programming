public class Car {
    public String name;
    protected int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car() {
        this("", 0);
    }
    public Car(String name) {
        this(name, 0);
    }
    public Car(String name, int price) {
        name = name;
        setPrice(price);
    }
}

class SuperCar extends Car {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printCarInfo() {
        System.out.println("이름: " + this.name + " 가격: " + this.price + " 브랜드: " + this.brand);
    }

    public static void main(String[] args) {
        SuperCar s = new SuperCar();
        s.setBrand("람보르기니");
        s.printCarInfo();

        Car c = new SuperCar();
    }
}



