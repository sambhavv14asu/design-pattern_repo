import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

public class Facade {

    //Buyer :0, Seller:1
    static public int UserType;

    private Product theSelectedProduct;

    private int nProductCategory;

    static ClassProductList theProductList=new ClassProductList();;

    private OfferingList offers;

    static Person thePerson;


    public boolean login() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");

        String username = scanner.nextLine().trim();

        System.out.println("Enter password: ");
        String password = scanner.nextLine().trim();
        int type = Login.validateLogin(username,password);
        UserType=type;
        if(type==-1){
            return false;
        }
        UserInfoItem item = new UserInfoItem(type,username);
        createUser(item);
        return true;
    }

    public void addTrading(Product product) {
        TradingMenu trademenu;
        if (UserType == 0) {

            trademenu = new BuyerTradingMenu();
        }

        else {
            trademenu = new SellerTradingMenu();
        }


        Trading trade = new Trading();
        trade.product=product;
        trademenu.add(trade, thePerson);

    }

    public void viewTrading(Trading trade) {
        TradingMenu trademenu;
        if(UserType == 0) {
            trademenu = new BuyerTradingMenu();
        }
        else {
            trademenu = new SellerTradingMenu();
        }
        trademenu.show(trade, thePerson );
    }

    public void decideBidding(Offering offer) {
        offer.show();
    }

    public void discussBidding(Offering sellerOffer,Offering buyerOffer) {

        if(buyerOffer.price>=sellerOffer.price){
            if(buyerOffer.startDate.compareTo(sellerOffer.endDate)<=0){
                buyerOffer.flag=1;
                buyerSellerDatabase.remove(sellerOffer,buyerOffer);
            }else{
                buyerOffer.flag=-1;
            }
        }else{
            if(buyerOffer.startDate.compareTo(sellerOffer.endDate)<=0){
                buyerOffer.flag=0;
            }else{
                buyerOffer.flag=-1;
            }
        }

    }

    public void submitBidding() {
        if(UserType==1){
            System.out.println("Only buyers can submit offerings");
        }else{
            Product p =new Product();
            Scanner scn=new Scanner(System.in);
            System.out.println("Enter product name");
            p.name=scn.nextLine();
            System.out.println("Enter category of product: 0 for meat, 1 for produce");
            p.category=scn.nextInt();
            System.out.println("Enter the price for offering");
            int price = scn.nextInt();
            Offering buyOffer = new Offering(p,price);
            offers.add(buyOffer);
        }
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

    public ClassProductList createProductList() {
        Map<String,Integer> products = new HashMap<>();
        try {
            URL path = Facade.class.getResource("ProductInfo.txt");
            File userProduct = new File(path.getFile());
            Scanner myReader = new Scanner(userProduct);
            while (myReader.hasNextLine()) {
                String data[] = myReader.nextLine().split(":");
                if(!products.containsKey(data[1])){
                    products.put(data[1],data[0].equals("Meat")? 0:1);
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
        return theProductList;
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
    }

    public Product SelectProduct() {
        return null;
    }

    public void productOperation() {

    }

    public void runSystem() {
        ClassProductList l = createProductList();
        attachProductToUser();
        ProductMenu menu = thePerson.createProductMenu();
        thePerson.showMenu(menu);

    }
}
