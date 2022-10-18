import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

        if(buyerSellerDatabase.buyerDatabase.containsKey(username) &&
                buyerSellerDatabase.buyerDatabase.get(username).equals(password)) {
            thePerson.type = 0;
            thePerson.userName = username;
            return true;
        } else if(buyerSellerDatabase.sellerDatabase.containsKey(username) &&
                buyerSellerDatabase.sellerDatabase.get(username).equals(password)) {
            thePerson.type = 1;
            thePerson.userName=username;
            return true;
        } else {
            return false;
        }

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

    }

    public void createProductList() {

    }

    public void AttachProductToUser() {

    }

    public Product SelectProduct() {
        return null;
    }

    public void productOperation() {

    }
}
