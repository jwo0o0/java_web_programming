abstract class abShape { //추상 클래스
    public abShape() {}
    public void paint() {draw();}
    abstract public void draw(); //추상 메소드
}

//추상 클래스를 상속받아, 추상 메소드를 구현하지 않으면 추상 클래스가 됨
abstract class abLine extends abShape { //추상 메소드
    public String toString() {return "Line";}
}
