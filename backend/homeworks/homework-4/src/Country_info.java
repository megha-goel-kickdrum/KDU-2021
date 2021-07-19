class MyThread extends Thread{
    @Override
    public void run(){
        int i =0;
        String[] countries = { "Britain ","India", "France", "Germany"   };
        while(i<4){
            System.out.println("The name of the country is" +"   " + countries[i]);

            i++;
        }
    }
}
public class Country_info {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}