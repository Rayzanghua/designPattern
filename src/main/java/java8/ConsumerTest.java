//package java8;
//
//
//import org.openjdk.jol.info.ClassLayout;
//
//import java.io.*;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class ConsumerTest {
//    public static void main(String[] args) throws IOException {
//        String path = ConsumerTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
//        File file=new File(path+"/java8/Who.class");
//        System.out.println(new FileInputStream(file).available());
//
//        byte[] bytes=new byte[new FileInputStream(file).available()];
//        new FileInputStream(file).read(bytes);
//        System.out.println();
//
//        System.out.println(ClassLayout.parseClass(Who.class).toPrintable());;
//    }
//}
//
