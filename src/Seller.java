public class Seller extends Person{

    Seller(){
        this.userProductList=new ClassProductList();
    }
    @Override
    void showMenu() {
        showAddButton();
        showLabels();
        showViewButton();
        showRadioButton();
    }

    //factory pattern to decide the instance of productMenu based n category
    @Override
    ProductMenu createProductMenu(Product product) {
        if(product.category==0){
            theProductMenu=new MeatProductMenu();
        }else{
            theProductMenu=new ProduceProductMenu();
        }
        return theProductMenu;
    }
}
