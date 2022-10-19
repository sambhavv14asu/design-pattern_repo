public class Login {

    static int validateLogin(String username,String password){
        if(buyerSellerDatabase.buyerDatabase.containsKey(username) &&
                buyerSellerDatabase.buyerDatabase.get(username).equals(password)) {
            return 0;
        } else if(buyerSellerDatabase.sellerDatabase.containsKey(username) &&
                buyerSellerDatabase.sellerDatabase.get(username).equals(password)) {
            return 1;
        } else {
            return -1;
        }
    }
}
