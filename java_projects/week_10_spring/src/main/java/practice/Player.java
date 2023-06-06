package practice;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player() {
        System.out.println("선수 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
    }
}
