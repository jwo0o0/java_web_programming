package practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Sports {
    @Autowired
    @Qualifier("teamA")
    private Team teamA;

    @Autowired
    @Qualifier("teamB")
    private Team teamB;

    @Autowired
    @Qualifier("teamC")
    private Team teamC;

    @Autowired
    private Game game;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sports() {
        this.setName("축구");
        System.out.println("스포츠 객체가 생성되었습니다.");
    }

    public void info() {
        System.out.println("name: " + name);
        teamA.info();
        teamB.info();
        teamC.info();
        game.info();
    }
}
