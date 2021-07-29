import com.kdu.Cache;
import com.kdu.Database;
import com.kdu.Geocoder;
import com.kdu.Location;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class StartApp {

    private static final Geocoder api = new Geocoder();
    private static final Database mysqlDatabase = new Database();
    private static final Cache inMemoryCache = new Cache();
    private static final Map<MysqlxDatatypes.Scalar.String, Vector<Integer>> frequencyTable = new HashMap<>();
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ScheduledExecutorService executor =
            Executors.newSingleThreadScheduledExecutor();

    //app queries
    public static String appQuery(String inputAddressPoint) throws SQLException, IOException, ParseException, InterruptedException {
        String address = "";
        if(inputAddressPoint.equals("EXIT")){
            address = "Thank you for visiting GeoAPI!!";
            return address;
        }
        Location result = inMemoryCache.getLocationFromCache(inputAddressPoint);
        //cache search
        if(result.isLocationFound()){
            address = result.getLatLong();
        }
        else if(!result.isLocationFound()){
            //Database search
            result = mysqlDatabase.getLocationFromDatabase(inputAddressPoint);
            if(result.isLocationFound()){
                address =  result.getLatLong();
            }
            else if(!result.isLocationFound()){
                //Geocoding API search
                String url = "https://api.opencagedata.com/geocode/v1/json?key=81d33f6b153241c29298d33eedb45c05&q="+inputAddressPoint;
                result = api.getLocationFromGeoapi(url);
                if(result.isLocationFound()){
                    mysqlDatabase.putLocationInDatabase(inputAddressPoint,result);
                    address =  result.getLatLong();
                }
                else if(!result.isLocationFound())
                    address =  "Sorry we are unable to find the match of the address you entered. Please kindly refine your search:)";
            }
        }
        return address;
    }


    //main driver
    public static void main(String[] args) throws SQLException, IOException, ParseException, InterruptedException {
        System.out.println("Welcome to GeoCodingAPI!!!");

        //cache update thread
        //CacheUpdateThread();

        //reading task
        while (true){
            Scanner readInput = new Scanner(System.in);
            System.out.println("Please enter the address you wish to search. If you wish to exit the app, enter exit");
            String inputAddressPoint = readInput.nextLine();
            inputAddressPoint = inputAddressPoint.toUpperCase();
            String result = appQuery(inputAddressPoint);
            if(result.equals("Thank you for visiting GeoAPI!!")){

                executor.shutdown();

                mysqlDatabase.closeConnection();
                System.out.println(result);
                return;
            }
            if(!result.equals("Sorry we are unable to find the match of the address you entered. Please kindly refine your search:)")){
                if(frequencyTable.containsKey(inputAddressPoint)){
                    int temp = frequencyTable.get(inputAddressPoint).get(0);
                    frequencyTable.get(inputAddressPoint).set(0,temp+1);
                }else {
                    Vector<Integer> freq = new Vector<>();
                    freq.add(1);
                    freq.add(0);
                    frequencyTable.put(inputAddressPoint,freq);
                }
            }

            //printing result
            System.out.println("latitude and longitude of the address");
            System.out.println(result);
        }
    }



    }


}
