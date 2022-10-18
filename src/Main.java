public class Main {
    public static void main(String[] args) {
        buyerSellerDatabase.createDatabase();
        Facade f = new Facade();
        boolean userLogin = f.login();
        if(userLogin) {
            System.out.println("Welcome to the PTBS");
        } else {
            System.out.println("No credentials found for the username");
        }

    }
}
