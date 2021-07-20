class Data {
    private String strname;


    public String getName() {
        return this.strname;
    }

    public void setName(String name) {
        this.strname= name;
    }
}
class Main {
    public static void main(String[] main){
        Data a = new Data();

        a.setName("Megha");
        System.out.println(a.getName());
    }
}
