import java.util.Date;

public class Offering {

    Product p;
    int price;
    Date startDate;
    Date endDate;

    // for buyer offers -> -1 for rejected,0 for waiting,1 for accepted
    int flag;
    Offering(Product p,int price){
        this.p=p;
        this.price=price;
        startDate=new Date();
    }
    public void show(){
        System.out.println("Product name" + this.p.name);
        System.out.println("Product type" + this.p.category);
        System.out.println("Price of offering" + this.price);
        System.out.println("Date offering was made" + startDate.toString());
    }
}
