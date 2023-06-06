package practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Team {
    @Autowired
    private Owner owner;

    @Autowired
    private Director director;

    @Autowired
    private Coach coach;

    @Autowired
    @Qualifier("player1")
    private Player player1;

    @Autowired
    @Qualifier("player2")
    private Player player2;

    @Autowired
    @Qualifier("player3")
    private Player player3;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team() {
        System.out.println("팀 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
        owner.info();
        director.info();
        coach.info();
        player1.info();
        player2.info();
        player3.info();
    }
}
