//Used for implementing the factory method where we decide which instance of ProductMenu to
// instantiate depending on product type

public abstract class ProductMenu {

    ClassProductList items=new ClassProductList();

    public abstract void showMenu();

    public abstract void showAddButton();

    public abstract void showViewButton();

    public abstract void showRadioButton();

    public abstract void showLabels();

    public abstract void showComboxes();
}
