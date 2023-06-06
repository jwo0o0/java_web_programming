package practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import practice.*;

@Configuration
@ComponentScan
public class PracticeConfig {
    @Bean
    public Owner owner() {
        Owner owner = new Owner();
        owner.setName("구단주");
        return owner;
    }

    @Bean
    public Director director() {
        Director director = new Director();
        director.setName("감독");
        return director;
    }

    @Bean
    public Coach coach() {
        Coach coach = new Coach();
        coach.setName("코치");
        return coach;
    }

    @Bean(name="player1")
    public Player player1() {
        Player player1 = new Player();
        player1.setName("선수1");
        return player1;
    }

    @Bean(name="player2")
    public Player player2() {
        Player player2 = new Player();
        player2.setName("선수2");
        return player2;
    }

    @Bean(name="player3")
    public Player player3() {
        Player player3 = new Player();
        player3.setName("선수3");
        return player3;
    }

    @Bean(name="teamA")
    public Team teamA() {
        Team teamA = new Team();
        teamA.setName("팀A");
        return teamA;
    }

    @Bean(name="teamB")
    public Team teamB() {
        Team teamB = new Team();
        teamB.setName("팀B");
        return teamB;
    }

    @Bean(name="teamC")
    public Team teamC() {
        Team teamC = new Team();
        teamC.setName("팀C");
        return teamC;
    }

    @Bean(name="referee1")
    public Referee referee1() {
        Referee referee1 = new Referee();
        referee1.setName("심판1");
        return referee1;
    }

    @Bean(name="referee2")
    public Referee referee2() {
        Referee referee2 = new Referee();
        referee2.setName("심판2");
        return referee2;
    }

//    @Bean
//    public Game game() {
//        Game game = new Game();
//        game.setName("경기");
//        return game;
//    }
//
//    @Bean
//    public Sports sports() {
//        Sports sports = new Sports();
//        sports.setName("축구");
//        return sports;
//    }
}
