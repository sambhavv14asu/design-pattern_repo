import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class buyerSellerDatabase {

    static Map<String, String> buyerDatabase = new HashMap<>();
    static Map<String, String> sellerDatabase = new HashMap<>();

    static void createDatabase(){
        try {
            URL path = buyerSellerDatabase.class.getResource("BuyerInfo.txt");
            File buyerDb = new File(path.getFile());
            Scanner myReader = new Scanner(buyerDb);
            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split(":");
                buyerDatabase.put(data[0],data[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            URL path = buyerSellerDatabase.class.getResource("SellerInfo.txt");
            File sellerDb = new File(path.getFile());
            Scanner myReader = new Scanner(sellerDb);
            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split(":");
                sellerDatabase.put(data[0],data[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
