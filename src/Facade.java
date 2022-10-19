import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Facade {

    private int UserType;

    private Product theSelectedProduct;

    private int nProductCategory;

    private ClassProductList theProductList;

    private Person thePerson;


    public boolean login() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");

        String username = scanner.nextLine().trim();

        System.out.println("Enter password: ");
        String password = scanner.nextLine().trim();
        int type = Login.validateLogin(username,password);
        if(type==-1){
            return false;
        }
        UserInfoItem item = new UserInfoItem(type,username);
        createUser(item);
        return true;
    }

    public void addTrading() {

    }

    public void viewTrading() {

    }

    public void decideBidding(Offering offer) {

    }

    public void discussBidding() {

    }

    public void submitBidding() {

    }

    public void remind() {

    }

    public void createUser(UserInfoItem userinfoitem) {
        if(userinfoitem.type==0){
            thePerson=new Buyer();
        }else{
            thePerson=new Seller();
        }
        thePerson.userName=userinfoitem.username;
    }

    public void createProductList() {
        theProductList=new ClassProductList();
        Map<String,String> products = new HashMap<>();
        try {
            URL path = Facade.class.getResource("ProductInfo.txt");
            File userProduct = new File(path.getFile());
            Scanner myReader = new Scanner(userProduct);
            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split(":");
                if(!products.containsKey(data[1])){
                    products.put(data[1],data[0]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for(String key:products.keySet()){
            theProductList.add(new Product(key,products.get(key)));
        }
        for(Product p:theProductList){
            System.out.println(p.name+" "+p.type);
        }
    }

    public void attachProductToUser() {
        HashSet<String> userProducts = new HashSet<>();
        try {
            URL path = Facade.class.getResource("UserProduct.txt");
            File userProduct = new File(path.getFile());
            Scanner myReader = new Scanner(userProduct);
            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split(":");
                if(data[0].equals(thePerson.userName)){
                    userProducts.add(data[1]);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for(String item:userProducts){
            for(Product p :theProductList){
                if(p.name.equals(item)){
                    thePerson.userProductList.add(p);
                    break;
                }
            }
        }
        for(Product p :thePerson.userProductList){
            System.out.println(p.name+" "+p.type);
        }
    }

    public Product SelectProduct() {
        return null;
    }

    public void productOperation() {

    }
}
