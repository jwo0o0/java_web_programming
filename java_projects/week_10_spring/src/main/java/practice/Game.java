package practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Game {
    @Autowired
    @Qualifier("teamA")
    private Team teamA;

    @Autowired
    @Qualifier("teamB")
    private Team teamB;

    @Autowired
    @Qualifier("referee1")
    private Referee referee1;

    @Autowired
    @Qualifier("referee2")
    private Referee referee2;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game() {
        this.setName("경기");
        System.out.println("경기 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
        teamA.info();
        teamB.info();
        referee1.info();
        referee2.info();
    }
}
