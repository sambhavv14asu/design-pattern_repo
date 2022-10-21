import java.util.ArrayList;

public class Product {

    ArrayList<Trading> trades=new ArrayList<>();
    public String name;
    int category;
    Product(String name,int category){
        this.name=name;
        this.category=category;
    }
    Product(){

    }
    void accept(NodeVisitor visitor) {
        for(Trading t:this.trades){
            t.accept(visitor);
        }
    }

}
