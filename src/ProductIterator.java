import java.util.ArrayList;

public class ProductIterator extends ListIterator<Product>{

    ClassProductList list;

    ProductIterator(ArrayList<Product> list){
        this.list= (ClassProductList) list;
    }
    @Override
    public boolean hasNext() {

        if(current< list.size()-1){
            return true;
        }
        return false;
    }

    @Override
    public Product next(){
        if(this.hasNext()){
            return list.get(++current);
        }else{
            return null;
        }
    }

    @Override
    public void moveToHead() {
        current=-1;
    }

    @Override
    public void remove() {
        if(current!=-1 && current<list.size()) {
            list.remove(current);
            current--;
        }
    }
}
