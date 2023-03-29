public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int value;
        Dummy myDummy = new Dummy();
        myDummy.setAttr(1234);
        value = myDummy.getAttr();
        System.out.println(value);
    }
}