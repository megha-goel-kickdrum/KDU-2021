

import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Country_data_info {

    public static void main(String[] args) throws Exception
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter Country Code:");

        int code = myObj.nextInt() ;
        Scanner scanner = new Scanner(System.in);

        C_data(code);
    }
    public static void C_data(int C_code) throws IOException, ParseException {
        // parsing file "CargoEntity.json"
        Object o = new JSONParser().parse(new FileReader("countryapi.json"));


        JSONArray jo=(JSONArray)o;


        for (Object ob : jo) {
            JSONObject country = (JSONObject)o;
            int countryCode = (int)country.get("callingCodes");

            if (countryCode == C_code) {

                int countryName = (int)country.get("name");
                int countryCapital = (int)country.get("capital");

                System.out.println("The Country details are:-   Name: " + countryName);
                System.out.println("   Capital: " + countryCapital);

            }
        }
    }

}
