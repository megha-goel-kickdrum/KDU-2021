
abstract class Parent{
    public Parent(){
        System.out.println("hola i m parent k constructor");
    }
    public void sayHello(){
        System.out.println("Hello");
    }
    abstract public void greet();
    abstract public void greet2();
}

class Child extends Parent{
    @Override
    public void greet(){
        System.out.println("Namaste");
    }
    @Override
    public void greet2(){
        System.out.println("salaam alaikum");
    }
}

abstract class Child3 extends Parent{
    public void th(){
        System.out.println("I am good");
    }
}


public class abstract_example {
    public static void main(String[] args) {
        //Parent p = new Parent(); -- error
        Child c = new Child();
        //Child3 c3 = new Child3(); -- error
        c.greet();
        c.greet2();
    }
}
