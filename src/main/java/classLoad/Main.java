package classLoad;


import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
//        Main m=new Main();    AppClassLoader
//        Applet m=new Applet();    BootstrapClassLoader
//        String m="";    BootstrapClassLoader
//        System.out.println(m.getClass().getClassLoader());
//        System.out.println(m.getClass().getClassLoader().getParent());
//        System.out.println(m.getClass().getClassLoader().getParent().getParent());

//        String simpleClassName="classLoad.TestOut";
//
//        TestOut o=new TestOut();
//        o.say();
//        TimeUnit.SECONDS.sleep(10);
//
//        URLClassLoader urlClassLoader = new URLClassLoader(new URL[] {}, ClassLoader.getSystemClassLoader());
//        Class<?> aClass = urlClassLoader.loadClass("classLoad.TestOut");
//        aClass.getMethod("say").invoke(aClass.newInstance());

//        Main m=new Main();
//        System.out.println(m.getClass().getClassLoader());
//        Runnable r=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(this.getClass().getClassLoader());
//            }
//        };
//        new Thread(r).start();

//        System.out.println(new Main().show());

        new Main().show();
    }

    public void show(){
//        List<Integer> list= new ArrayList<>();
//        list.add(1);
//        List<Integer> list2=list;
//        list.remove(0);
//        System.out.println();
//        String s1="abc";
//        s1.re
    }
}

