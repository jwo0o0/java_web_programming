 interface PhoneInterface {
    final int TIMEOUT = 10000; //상수 필드 - public static final 생략
    void sendCall(); //추상 메소드 - public abstract 생략
    void receiveCall(); //추상 메소드
    default void printLogo() {
        System.out.println("** Phone **");
    }
}

//인터페이스가 다른 인터페이스 상속 가능
interface MobilePhoneInterface extends PhoneInterface {
    void sendSMS();
    void receiveSMS();
}

interface MP3Interface {
    public void play();
    public void stop();
}
class PDA {
    public int calculate(int x, int y) {
        return x + y;
    }
}

//SmartPhone 클래스
//PDA를 상속
//MobilePhoneInterface와 MP3Interface 를 구현
class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface {
    //MobilePhoneInterface의 추상 메소드 구현
    @Override
    public void sendCall() {
        System.out.println("따르릉따르릉~");
    }
    @Override
    public void receiveCall() {
        System.out.println("전화 왔어요!");
    }
    @Override
    public void sendSMS() {
        System.out.println("문자 보내욥");
    }
    @Override
    public void receiveSMS() {
        System.out.println("문자 왔어욥");
    }

    //MP3Interface의 추상 메소드 구현
    @Override
    public void play() {
        System.out.println("play music");
    }
    @Override
    public void stop() {
        System.out.println("stop music");
    }

    //추가로 작성한 메소드
    public void schedule() {
        System.out.println("일정 관리");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone();
        myPhone.printLogo();
        myPhone.sendCall();
        myPhone.play();
        System.out.println("3과 5를 더하면 " + myPhone.calculate(3, 5));
        myPhone.schedule();
    }
}