package practice;

public class Referee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Referee() {
        System.out.println("심판 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
    }
}
