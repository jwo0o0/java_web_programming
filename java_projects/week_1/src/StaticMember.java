import java.util.Scanner;

//static을 사용한 환율 계산기
class CurrencyConverter {
    private static double rate; //한국 원화에 대한 환율
    static void printRate() {
        System.out.println("환율: " + rate);
    }
    public static double toDollar(double won) {
        return won/rate; //한국 원화를 달러로 변환
    }
    public static double toKWR(double dollar) {
        return dollar * rate; //달러를 한국 원화로 변환
    }
    public static void setRate(double r) {
        rate = r; // 환율 설정 KWR/$1
    }
}

public class StaticMember {
    public static void main(String[] args) {
        //static 메소드와 필드는 객체가 생성되지 않은 상황에서도 사용 가능
        CurrencyConverter.printRate(); //아직 0으로 초기화된 상황

        Scanner scanner = new Scanner(System.in);
        System.out.println("환율(1달러)>> ");
        double rate = scanner.nextDouble();
        CurrencyConverter.setRate(rate);
        System.out.println("백만원은 $" + CurrencyConverter.toDollar(1000000) + "입니다.");
        System.out.println("$100는 " + CurrencyConverter.toKWR(100) + "원입니다.");
        scanner.close();
    }
}