package studyDesign.visitor;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameStructure game=new GameStructure();
        game.add(new Woman());
        game.show(new Succ());
        game.clear();
        game.add(new Man());
        game.show(new Fail());
    }
}

class GameStructure{
    private List<Person> list=new ArrayList<>();

    public void add(Person person){
        list.add(person);
    }

    public void clear(){
        list=new ArrayList<>();
    }

    public void show(Out out){
        for(Person p:list){
            p.say(out);
        }
    }
}

interface Person{
    void say(Out out);
}

interface Out{

    void manOut();

    void womanOut();
}

class Succ implements Out{

    @Override
    public void manOut() {
        System.out.println("成功");
    }

    @Override
    public void womanOut() {
        System.out.println("success");
    }
}

class Fail implements Out{

    @Override
    public void manOut() {
        System.out.println("失败");
    }

    @Override
    public void womanOut() {
        System.out.println("fail");
    }
}

class Man implements Person{

    @Override
    public void say(Out out) {
        System.out.println("男生说");
        out.manOut();
    }
}

class Woman implements Person{

    @Override
    public void say(Out out) {
        System.out.println("girl说");
        out.womanOut();
    }
}