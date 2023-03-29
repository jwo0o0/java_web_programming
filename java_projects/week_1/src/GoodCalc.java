public class GoodCalc extends Calculator{
    public int add(int a, int b) {
        return a+b;
    }
    public int subtract(int a, int b) {
        return a-b;
    }
    public double average(int[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum /a.length;
    }
    public static void main(String[] args) {
        //추상 클래스는 객체를 생성할 수 없음
        //Calculator cal = new Calculator();

        GoodCalc c = new GoodCalc();
        System.out.println(c.add(2, 3));
        System.out.println(c.subtract(3, 4));
        System.out.println(c.average(new int[] {2, 3, 4}));
    }
}
