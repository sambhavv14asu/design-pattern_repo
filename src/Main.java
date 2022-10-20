public class Main {
    public static void main(String[] args) {
        buyerSellerDatabase.createDatabase();
        // we will be running the system through the facade class which acts as an interface for the entire system
        Facade f = new Facade();
        boolean userLogin = f.login();
        if(userLogin) {
            System.out.println("Welcome to the PTBS");
        } else {
            System.out.println("No credentials found for the username");
            return;
        }
        f.runSystem();

    }
}
