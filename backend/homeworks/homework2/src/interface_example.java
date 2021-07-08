interface Bicycle{
    int a = 45;
    void applyBrake(int decrement);
    void speedUp(int increment);
}

interface HornBicycle{
    int x = 50;
    void blowHornK3g();
    void blowHornDhoom();
}

class AvonCycle implements Bicycle, HornBicycle{
    //public int x = 5;
    void blowHorn(){
        System.out.println("Pee pon");
    }
    public void applyBrake(int decrement){
        System.out.println("Applying Brake");
    }
    public void speedUp(int increment){
        System.out.println("Applying Speed");
    }
    public void blowHornK3g(){
        System.out.println("music plays ");
    }
    public void blowHornDhoom(){
        System.out.println("dhoom dhoom ");
    }
}



public class interface_example {
    public static void main(String[] args) {
        AvonCycle cycleMegha = new AvonCycle();
        cycleMegha.applyBrake(1);
        System.out.println(cycleMegha.a);
        System.out.println(cycleMegha.x);


        cycleMegha.blowHornK3g();
        cycleMegha.blowHornDhoom();
    }
}
