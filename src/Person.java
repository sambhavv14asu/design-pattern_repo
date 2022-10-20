public abstract class Person {

    public String userName;

    protected ProductMenu theProductMenu;

    public ClassProductList userProductList;
    public void showAddButton() {
        theProductMenu.showAddButton();
    }

    public void showViewButton() {
        theProductMenu.showViewButton();
    }

    public void showRadioButton() {
        theProductMenu.showRadioButton();
    }
    public void showLabels() {
        theProductMenu.showLabels();
    }
    abstract void showMenu(ProductMenu menu);

    abstract ProductMenu createProductMenu();
}
