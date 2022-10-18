public abstract class Person {

    int type ;
    public String userName;

    private ProductMenu theProductMenu;

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
