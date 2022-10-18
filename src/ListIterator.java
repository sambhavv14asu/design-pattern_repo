import java.util.ArrayList;

public abstract class ListIterator<T> {


    int current=-1;
    public abstract boolean hasNext();

    public abstract Object next();

    public abstract void moveToHead();

    public abstract void remove();
}
