import java.util.Date;
import java.util.HashMap;

public class Trading {

    String name;
    Product product;
    OfferingList offers;
    Date startDate;
    Date endDate;
    Trading(String name,Date endDate){
        this.name=name;
        this.endDate=endDate;
    }
    Trading(){

    }
    void accept(NodeVisitor visitor) {
        if(new Date().compareTo(this.endDate)<0) {
            visitor.makeReminder(this,"You still have time to close this trade");
        }else if(new Date().compareTo(this.endDate)==0){
            visitor.makeReminder(this,"Reminder! Today is the last date to close this trade");
        }else{
            visitor.makeReminder(this,"Reminder! The trade end date has passed, please close it");
        }
    }
    public void addBuyerOffer(Product p,Offering offer){

    }

    public void createTrade(Offering sellerOffer, Offering buyerOffer) {

    }
}
