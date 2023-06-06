package practice;

public class Director {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director() {
        System.out.println("감독 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
    }
}
