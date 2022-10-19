public abstract class Person {

    public String userName;

    private ProductMenu theProductMenu;

    public ClassProductList userProductList;
    public void showAddButton() {

    }

    public void showViewButton() {

    }

    public void showRadioButton() {

    }
    public void showLabels() {

    }
    abstract void showMenu();

    abstract ProductMenu createProductMenu();
}
