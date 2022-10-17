public interface ListsIterator {

    boolean hasNext();

    Object next();

    void moveToHead();

    void remove();
}
