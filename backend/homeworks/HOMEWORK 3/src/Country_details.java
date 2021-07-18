

import java.util.*;
        import java.io.*;
class Country{
    String c_name, capital;
    int code;


    Country(String name,  int code, String capital)
    {
        this.c_name = name;
        this.code = code;
        this.capital = capital;

    }

    void print(FileWriter myWriter){
        String s = c_name+" "+code+" "+capital + "\n";
        try {
            myWriter.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File Updated");
    }
}

public class Country_details {
    public static void main(String[] args) throws IOException {
        HashSet<Country> hSet = new HashSet<>();
        Country country;
        Scanner scanner = new Scanner(System.in);
        int ch = 0, code;
        String c_name, capital;

        try (FileWriter myWriter = new FileWriter("countryDetails.txt")) {


            while (ch != 4) {
                System.out.println("Enter 1 : To View the Country details");
                System.out.println("Enter 2 : To Insert the Country details");
                System.out.println("Enter 3:  To Search the Country by capital or code");
                System.out.println("Enter 4 : To Terminate the program\n");
                System.out.println("Type your choice: ");
                ch = scanner.nextInt();
                if (ch == 1) {
                    System.out.println("Enter name of the  Country");
                    c_name = scanner.nextLine();
                    for (Country c : hSet) {
                        if (c_name.equals(c.c_name)) {
                            c.print(myWriter);
                        }
                    }
                } else if (ch == 2) {
                    System.out.println("Enter Country details in the order - Country_Name, Country_code, Country_Capital to insert the data\n");
                    c_name = scanner.nextLine();
                    code = scanner.nextInt();
                    capital = scanner.nextLine();
                    country = new Country(c_name, code, capital);
                    hSet.add(country);
                    System.out.println("\nSuccessfully inserted Country Details\n \n");
                } else if (ch == 3) {
                    System.out.println("Search the required Country using capital or Code\n Type 'cap' for using capital and 'code' for using code");
                    String check = scanner.nextLine();
                    if (check.equals("cap")) {
                        System.out.println("Enter Country Capital:");
                        capital = scanner.nextLine();
                        for (Country c : hSet) {
                            if (capital.equals(c.capital)) {
                                System.out.println(c.c_name);

                            }
                        }
                    } else {
                        System.out.println("Enter Country Code:");
                        code = scanner.nextInt();
                        for (Country c : hSet) {
                            if (code == c.code) {
                                System.out.println(c.c_name);
                                ;
                            }
                        }
                    }
                } else if (ch == 4) {
                    System.out.println("Exiting");
                } else
                    System.out.println("Invalid Request");

            
        }
    }
}