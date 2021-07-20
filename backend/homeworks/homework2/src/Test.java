

class A
{
    public void show()
    {
        System.out.println("A");
    }
}

class B extends A
{
    public void show()
    {
        System.out.println("B");
    }
}
public class Test
{
    public static void main(String args[])
    {
        A obj= new A();
        obj.show();

        A obj1= new B();
        obj1.show();

        B obj2= new B();
        obj2.show();

        //B obj3= new A();
        //obj3.show();
    }
}


