//Used for implementing the factory method where we decide which instance of ProductMenu to
// instantiate depending on product type

public interface ProductMenu {

    public abstract void showMenu();

    public abstract void showAddButton();

    public abstract void showViewButton();

    public abstract void showRadioButton();

    public abstract void showLabels();

    void showComboxes();
}
