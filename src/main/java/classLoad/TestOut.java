package classLoad;

public class TestOut {

    public static void main(String[] args) {
        Integer a=100;
        Integer b=200;
        Integer c=300;
        Long l=300L;
        System.out.println(l.equals(a+b));
        System.out.println((a+b)==c);
    }
}
