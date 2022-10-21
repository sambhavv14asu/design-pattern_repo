import java.util.ArrayList;
import java.util.Date;

public class Product {

    ArrayList<Trading> trades=new ArrayList<>();
    public String name;
    int category;
    Product(String name,int category){
        this.name=name;
        this.category=category;
        trades.add(new Trading("Trade"+name,new Date()));
    }
    Product(){

    }
    void accept(NodeVisitor visitor) {
        for(Trading t:this.trades){
            t.accept(visitor);
        }
    }

}
