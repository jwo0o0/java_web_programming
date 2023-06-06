package chap2;

public class Greeter {
    private String format;

    public String greet(String guest) {
        return String.format(format, guest);
    }

    //greet 메서드에서 사용할 문자열 포맷 설정
    public void setFormat(String format) {
        this.format = format;
    }
}
