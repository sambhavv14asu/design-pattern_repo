import java.util.ArrayList;

//iterator pattern
public class OfferingIterator extends ListIterator<Offering> {

    OfferingList list;

    OfferingIterator(ArrayList<Offering> list){
        this.list= (OfferingList) list;
    }
    @Override
    public boolean hasNext() {

        if(current< list.size()-1){
            return true;
        }
        return false;
    }

    @Override
    public Offering next(){
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
