import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

    public ClassProductList() {
        super();
    }
    void accept(NodeVisitor visitor) {
        for(Product p:this){
            p.accept(visitor);
        }
    }
}
